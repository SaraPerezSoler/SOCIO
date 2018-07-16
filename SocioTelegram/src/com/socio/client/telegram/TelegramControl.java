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

import com.socio.client.beans.Message;
import com.socio.client.beans.Project;
import com.socio.client.command.Channel;
import com.socio.client.telegram.states.CommandState;

public class TelegramControl extends TelegramLongPollingBot {

	public static final String TEST = "Test";
	public static final String MISO_TEST = "MisoTest";
	public static final String SOCIO = "SOCIO";

	private static final String NAME = "Name";
	private static final String ID = "ID";

	private static final String PASS = "pass.json";

	public static Map<String, Project> projects = new HashMap<>();
	public static Map<String, CommandState> commandState = new HashMap<>();
	public static Map<Long, Chat> chats = new HashMap<>();

	private TelegramChannel channel = new TelegramChannel();

	private String name;
	private String id;

	private static TelegramControl TELEGRAM_CONTROL = null;

	public static TelegramControl getTelegramControl() throws TelegramApiException {
		if (TELEGRAM_CONTROL == null) {
			TELEGRAM_CONTROL = new TelegramControl(SOCIO);
		}
		return TELEGRAM_CONTROL;
	}

	public static TelegramControl createTelegramControl(String debug) throws TelegramApiException {
		if (TELEGRAM_CONTROL == null) {
			TELEGRAM_CONTROL = new TelegramControl(debug);
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

	private TelegramControl(String debug) throws TelegramApiException {
		String text = readPass();
		if (text == null || text.isEmpty()) {
			throw new TelegramApiException("Impossible to read the bot tokens: File");
		}
		JSONObject object = new JSONObject(text);
		if (!debug.equals(TEST) && !debug.equals(MISO_TEST) && !debug.equals(SOCIO)) {
			debug = SOCIO;
		}
		if (!object.has(debug)) {
			throw new TelegramApiException("Impossible to read the bot tokens: Bot Name");
		}
		JSONObject bot = object.getJSONObject(debug);
		if (!bot.has(NAME) || !bot.has(ID)) {
			throw new TelegramApiException("Impossible to read the bot tokens: Bot info");
		}
		this.name = bot.getString(NAME);
		this.id = bot.getString(ID);
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


	private class TelegramChannel extends Channel {

		public TelegramChannel() {
			super();
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
			if (lastMessage.getUser().getChannel().equals(this.getChannelName())) {
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

		private long getChatId(Message msg) {
			String id = msg.getId().split("/")[0];
			try {
				long idLong = Long.parseLong(id);
				return idLong;
			} catch (NumberFormatException e) {
				return -1;
			}
		}
	}

}
