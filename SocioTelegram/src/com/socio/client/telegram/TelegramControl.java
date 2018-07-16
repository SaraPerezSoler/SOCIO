package com.socio.client.telegram;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.beans.Message;
import com.socio.client.beans.Project;
import com.socio.client.command.Channel;
import com.socio.client.telegram.states.CommandState;

public class TelegramControl extends TelegramLongPollingBot {

	public static Map<String, Project> projects = new HashMap<>();
	public static Map<String, CommandState> commandState = new HashMap<>();
	public static Map<Long, Chat> chats = new HashMap<>();

	private boolean debug = false;
	private TelegramChannel channel = new TelegramChannel();

	private static final String NAME_BOT_DEBUG = "pruebaSarabot";
	private static final String ID_BOT_DEBUG = "286872489:AAG83znaRy6MdSu0_yKlnwNVVORvI1-5ku0";

	 public static final String NAME_BOT_MODELLING = "ModellingBot";
	 private static final String ID_BOT_MODELLING ="307974624:AAFfE4qi_OcfFXj0PlyE8RlGJ2ITAPaWpcs";

//	private static final String NAME_BOT_MODELLING = "MisoTestBot";
//	private static final String ID_BOT_MODELLING = "480658734:AAHLl35mQFUFnS-p3AkCpiPCjnqbbODoyhg";
	private static TelegramControl TELEGRAM_CONTROL = null;

	public static TelegramControl getTelegramControl() {
		if (TELEGRAM_CONTROL == null) {
			TELEGRAM_CONTROL = new TelegramControl();
		}
		return TELEGRAM_CONTROL;
	}

	public static TelegramControl createTelegramControl(boolean debug) {
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

	private TelegramControl(boolean debug) {
		this.debug = debug;
	}

	private TelegramControl() {
	}

	@Override
	public String getBotUsername() {
		if (debug) {
			return NAME_BOT_DEBUG;
		} else {
			return NAME_BOT_MODELLING;
		}
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getChannelName() {
		return channel.getChannelName();
	}

	@Override
	public String getBotToken() {
		if (debug) {
			return ID_BOT_DEBUG;
		} else {
			return ID_BOT_MODELLING;
		}
	}

	public boolean isDebug() {
		return debug;
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
