package com.socio.client.telegram;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.EndConsensus;
import com.socio.client.beans.Message;
import com.socio.client.beans.Polling;
import com.socio.client.beans.Project;
import com.socio.client.beans.User;
import com.socio.client.command.Channel;
import com.socio.client.command.SocioCommands;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class TelegramControl extends TelegramLongPollingBot {

	public static final String TEST = "Test";
	public static final String MISO_TEST = "MisoTest";
	public static final String SOCIO = "SOCIO";

	private static final String NAME = "Name";
	private static final String ID = "ID";

	public static final String HOST = "host";
	public static final String DEBUG_HOST = "DebugHost";
	
	public static String PASS = "pass.json";

	public static Map<String, Project> projects = new HashMap<>();
	public static Map<String, CommandState> commandState = new HashMap<>();
	public static Map<Long, Chat> chats = new HashMap<>();

	private TelegramChannel channel = null;

	private String name;
	private String id;
	private String url;
	
	private static TelegramControl TELEGRAM_CONTROL = null;

	public static TelegramControl getTelegramControl() {
		if (TELEGRAM_CONTROL == null) {
			try {
				TELEGRAM_CONTROL = new TelegramControl(SOCIO, HOST);
			} catch (TelegramApiException e) {
				 System.exit(0);
			}
		}
		return TELEGRAM_CONTROL;
	}

	public static TelegramControl createTelegramControl(String botSelected, String hostSelected) throws TelegramApiException {
		if (TELEGRAM_CONTROL == null) {
			TELEGRAM_CONTROL = new TelegramControl(botSelected, hostSelected);
		}
		return TELEGRAM_CONTROL;
	}

	public static void regiterTelegramCommand(Class<? extends CommandState> command) {
		try {
			Method meth = command.getMethod("getState");
			CommandState state = (CommandState) meth.invoke(null);
			commandState.put(state.getCommand(), state);
		} catch (NoSuchMethodException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			System.out.println("I cant register the command " + command.getName() + "\n" + e.getMessage());
		}
	}

	private TelegramControl(String botSelected, String hostSelected) throws TelegramApiException {
		String text = readPass();
		if (text == null || text.isEmpty()) {
			throw new TelegramApiException("Impossible to read the bot tokens: File");
		}
		JSONObject object = new JSONObject(text);
		if (!botSelected.equals(TEST) && !botSelected.equals(MISO_TEST) && !botSelected.equals(SOCIO)) {
			botSelected = SOCIO;
		}
		if (!object.has(botSelected)) {
			throw new TelegramApiException("Impossible to read the bot tokens: Bot Name");
		}
		JSONObject bot = object.getJSONObject(botSelected);
		if (!bot.has(NAME) || !bot.has(ID)) {
			throw new TelegramApiException("Impossible to read the bot tokens: Bot info");
		}
		if (!hostSelected.equals(HOST)&& !hostSelected.equals(DEBUG_HOST)) {
			hostSelected = HOST;
		}
		if(!object.has(hostSelected)) {
			throw new TelegramApiException("Impossible to read the bot tokens: host");
		}
		
		this.name = bot.getString(NAME);
		this.id = bot.getString(ID);
		this.url = object.getString(hostSelected);
		this.channel = new TelegramChannel(this.url);
	}

	private String readPass() {
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;
		String text = "";
		try {
			file = new File(PASS);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			// Lectura del fichero

			String line;
			while ((line = br.readLine()) != null)
				text += "\n" + line;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return text;
	}

	@Override
	public String getBotUsername() {
		return name;
	}

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage()) {
			long id = update.getMessage().getChatId();
			Chat actualChat = chats.get(id);
			if (actualChat == null) {
				actualChat = new Chat(id);
				chats.put(id, actualChat);
			}
			try {
				actualChat.onReciveMessage(update.getMessage());
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
		}
	}

	public String getChannelName() {
		return channel.getChannelName();
	}

	@Override
	public String getBotToken() {
		return id;
	}
	
	public SocioCommands getSOCIO() {
		return channel.getSOCIO();
		
	}

	private class TelegramChannel extends Channel {

		public TelegramChannel(String url) {
			super(url);
		}

		@Override
		public String getChannelName() {
			return "telegram";
		}

		@Override
		public void onUpdate(Project p, List<Message> msgs, File f) {
			Set<Long> ids = chats.keySet();
			Message lastMessage = msgs.get(msgs.size() - 1);
			long lastChatId = -1;
			if (lastMessage.getUser().getChannel().equalsIgnoreCase(this.getChannelName())) {
				lastChatId = getChatId(lastMessage);
			}
			for (Long id : ids) {
				if (p.equals(chats.get(id).getProject()) && lastChatId != id) {
					try {
						chats.get(id).setProject(p, -1);
						chats.get(id).sendHistory(msgs, -1);
						chats.get(id).sendPhoto(f);
					} catch (TelegramApiException e) {
						e.printStackTrace();
					}
				}
			}
		}

		@Override
		public void onPolling(Polling polling) {

			for (User u : polling.getUsers()) {
				if (u.getChannel().equals(getChannelName())) {
					Chat chat = chats.get(u.getId());
					if (chat != null) {
						try {
							chat.onStartPolling(polling.getProject(), polling.getBranchGroup(), polling.getBranchs());
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}

		}

		private long getChatId(Message msg) {
			String id = msg.getId().split("/")[0];
			try {
				long idLong = Long.parseLong(id);
				return idLong;
			} catch (NumberFormatException e) {
				return -1;
			}
		}

		@Override
		public void onEndConsensus(EndConsensus cons) {
			long chatId = State.getChatId(cons.getMessageId());
			Chat adminChat = chats.get(chatId);

			for (User u : cons.getNotVoted()) {
				if (u.getChannel().equals(getChannelName())) {
					Chat chat = chats.get(u.getId());
					if (chat != null) {
						try {
							chat.onEndPolling(cons);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}
			for (User u : cons.getClose().keySet()) {
				if (u.getChannel().equals(getChannelName())) {
					Chat chat = chats.get(u.getId());
					if (chat != null) {
						try {
							chat.onEndPolling(cons);
						} catch (TelegramApiException e) {
							e.printStackTrace();
						}
					}
				}
			}
			try {
				adminChat.onEndPollingAdmin(cons);
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}

		}
		public SocioCommands getSOCIO() {
			return this.SOCIO;
			
		}

	}


}
