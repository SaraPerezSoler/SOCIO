package es.uam.app.channels.telegram;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.telegram.telegrambots.api.methods.send.SendDocument;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.methods.send.SendPhoto;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ForceReplyKeyboard;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardRemove;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import es.uam.app.channels.TelegramChannel;
import es.uam.app.main.Main;
import es.uam.app.message.ReceivedMessage;
import es.uam.app.message.SendMessageExc;
import es.uam.app.message.User;

public class TelegramControl extends TelegramLongPollingBot {

	public static final String ID_SEPARATOR = ";";
	public static final String CALL_BACK_SEPARATOR = "_";

	private static boolean debug = false;

	public static final String NAME_BOT_PRUEBA = "pruebaSarabot";
	private static final String ID_BOT_PRUEBA = "286872489:AAG83znaRy6MdSu0_yKlnwNVVORvI1-5ku0";

	public static final String NAME_BOT_MODELLING = "ModellingBot";
	private static final String ID_BOT_MODELLING = "307974624:AAFfE4qi_OcfFXj0PlyE8RlGJ2ITAPaWpcs";

	public static String NAME_BOT;
	private static String ID_BOT;

	private TelegramChannel channel;

	public TelegramControl(TelegramChannel channel) {
		this.channel = channel;
	}

	@Override
	public String getBotUsername() {
		return NAME_BOT;
	}

	@Override
	public String getBotToken() {
		return ID_BOT;
	}

	@Override
	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {
			String text = update.getMessage().getText().toLowerCase();
			if (text.startsWith("/")) {
				TelegramCommand tc = TelegramCommand.getCommand(text);
				if (tc != null) {
					tc.commandAction(update);
				} else {
					TelegramCommand.helpState.commandAction(update);
				}

			} else {
				TelegramCommand tc = TelegramCommand.getState(update.getMessage().getChatId());
				if (tc != null) {
					tc.userAnswerText(update);
				}
			}
		} else {
			TelegramCommand tc = TelegramCommand.getState(update.getMessage().getChatId());
			if (tc != null) {
				tc.userAnswer(update);
			}
		}

	}

	private ReceivedMessage standardMensaje(Update update, String command, String projectName, String text) {
		User us = getUser(update);
		Date date = getDate(update);
		String msgId = getId(update);
		String msgText;
		if (update.hasCallbackQuery()) {
			msgText = update.getCallbackQuery().getMessage().getText() + " " + update.getCallbackQuery().getData();
		} else {
			msgText = update.getMessage().getText();
		}
		ReceivedMessage msg = new ReceivedMessage(msgText, us, date, command,projectName, msgId);
		msg.setText(text);
		return msg;
	}

	private User getUser(Update update) {
		if (update.hasCallbackQuery()) {
			String username = update.getCallbackQuery().getFrom().getFirstName();
			long id = (long) update.getCallbackQuery().getFrom().getId();
			String nick = update.getCallbackQuery().getFrom().getUserName();

			return new User(username, id, nick, channel.getChannelName());

		} else {
			String username = update.getMessage().getFrom().getFirstName();
			long id = (long) update.getMessage().getFrom().getId();
			String nick = update.getMessage().getFrom().getUserName();

			return new User(username, id, nick, channel.getChannelName());

		}
	}

	private Date getDate(Update update) {
		int value = 0;
		if (update.hasCallbackQuery()) {
			value = update.getCallbackQuery().getMessage().getDate();
		} else {
			value = update.getMessage().getDate();
		}
		return new java.util.Date((long) value * 1000);
	}

	private String getId(Update update) {
		if (update.hasCallbackQuery()) {
			return update.getCallbackQuery().getMessage().getMessageId() + ID_SEPARATOR
					+ update.getCallbackQuery().getMessage().getChatId();
		}
		return update.getMessage().getMessageId() + ID_SEPARATOR + update.getMessage().getChatId();
	}

	public void sendAnswerMessage(ReceivedMessage rMessage, SendMessageExc sMessage) {
		String id = rMessage.getId();
		String[] split = id.split(ID_SEPARATOR);
		int msgId = Integer.parseInt(split[0]);
		long chatId = Long.parseLong(split[1]);

		TelegramCommand tc = TelegramCommand.getState(chatId);
		if (tc != null) {
			tc.modellingAnswer(chatId, msgId, rMessage, sMessage);
		}
	}

	public void sendMessage(int msgId, long chatId, SendMessageExc sMessage) {

		ReplyKeyboardRemove replyremove = new ReplyKeyboardRemove();
		if (sMessage.hasText()) {
			SendMessage send = new SendMessage().setChatId(chatId).setText(sMessage.getText());
			if (msgId != -1) {
				replyremove.setSelective(true);
				send.setReplyToMessageId(msgId);
			}
			send.setReplyMarkup(replyremove);
			try {
				sendMessage(send);

			} catch (TelegramApiException e) {
				Main.log.error(e);
				;
			}
		}
		if (sMessage.hasPng()) {
			SendPhoto photo = new SendPhoto().setChatId(chatId).setNewPhoto(sMessage.getPng());
			if (!sMessage.hasText()) {
				photo.setReplyMarkup(replyremove);
				if (msgId != -1) {
					replyremove.setSelective(true);
					photo.setReplyToMessageId(msgId);
				}
			}
			try {
				sendPhoto(photo);
			} catch (TelegramApiException e) {
				Main.log.error(e);
			}
		}
		if (sMessage.hasDocument()) {
			SendDocument document = new SendDocument().setChatId(chatId).setNewDocument(sMessage.getDocument());
			document.setReplyMarkup(replyremove);
			try {
				sendDocument(document);
			} catch (TelegramApiException e) {
				Main.log.error(e);
			}
		}
	}

	public void sendMessageWithURL(long chatId, SendMessageExc sMessage, String[][] options, String[][] urls) {

		InlineKeyboardMarkup inlineKeyBoar = new InlineKeyboardMarkup();
		List<List<InlineKeyboardButton>> buttons = new ArrayList<List<InlineKeyboardButton>>();
		for (int i = 0; i < options.length; i++) {
			List<InlineKeyboardButton> row = new ArrayList<InlineKeyboardButton>();
			for (int j = 0; j < options[i].length; j++) {
				InlineKeyboardButton button = new InlineKeyboardButton();
				button.setText(options[i][j]);
				button.setUrl(urls[i][j]);
				row.add(button);
			}
			buttons.add(row);
		}
		inlineKeyBoar.setKeyboard(buttons);

		if (sMessage.hasText()) {
			SendMessage send = new SendMessage().setChatId(chatId).setText(sMessage.getText());

			send.setReplyMarkup(inlineKeyBoar);
			try {
				sendMessage(send);

			} catch (TelegramApiException e) {
				Main.log.error(e);
				;
			}
		} else if (sMessage.hasPng()) {
			SendPhoto photo = new SendPhoto().setChatId(chatId).setNewPhoto(sMessage.getPng());
			if (!sMessage.hasText()) {
				photo.setReplyMarkup(inlineKeyBoar);
			}
			try {
				sendPhoto(photo);
			} catch (TelegramApiException e) {
				Main.log.error(e);
			}
		}
	}

	public void sendMessageWithKeyBoar(int msgId, long chatId, SendMessageExc sMessage, String[][] options) {

		ReplyKeyboardMarkup keyboardMarkup = new ReplyKeyboardMarkup();
		keyboardMarkup.setOneTimeKeyboad(true);
		

		List<KeyboardRow> buttons = new ArrayList<KeyboardRow>();
		for (int i = 0; i < options.length; i++) {
			KeyboardRow row = new KeyboardRow();
			for (int j = 0; j < options[i].length; j++) {
				KeyboardButton button = new KeyboardButton();
				button.setText(options[i][j]);
				row.add(button);
			}
			buttons.add(row);
		}
		keyboardMarkup.setKeyboard(buttons);

		if (sMessage.hasText()) {
			SendMessage send = new SendMessage().setChatId(chatId).setText(sMessage.getText());
			if (msgId != -1) {
				keyboardMarkup.setSelective(true);
				send.setReplyToMessageId(msgId);
			}
			send.setReplyMarkup(keyboardMarkup);
			try {
				sendMessage(send);

			} catch (TelegramApiException e) {
				Main.log.error(e);
				;
			}
		} 
		if (sMessage.hasPng()) {
			SendPhoto photo = new SendPhoto().setChatId(chatId).setNewPhoto(sMessage.getPng());
			if (!sMessage.hasText()) {
				photo.setReplyMarkup(keyboardMarkup);
				if (msgId != -1) {
					keyboardMarkup.setSelective(true);
					photo.setReplyToMessageId(msgId);
				}
			}
			try {
				sendPhoto(photo);
			} catch (TelegramApiException e) {
				Main.log.error(e);
			}
		}
	}

	public void sendMessageAndWait(int msgId, long chatId, SendMessageExc sMessage) {

		if (sMessage.hasPng()) {
			// ReplyKeyboard replyremove=new ReplyKeyboardRemove();
			SendPhoto photo = new SendPhoto().setChatId(chatId).setNewPhoto(sMessage.getPng());
			// photo.setReplyMarkup(replyremove);
			try {
				sendPhoto(photo);
			} catch (TelegramApiException e) {
				Main.log.error(e);
			}
		}
		if (sMessage.hasText()) {
			ForceReplyKeyboard replyK = new ForceReplyKeyboard();
			replyK.setSelective(true);
			SendMessage send = new SendMessage().setChatId(chatId).setText(sMessage.getText());
			send.setReplyMarkup(replyK);

			send.setReplyToMessageId(msgId);

			try {
				sendMessage(send);

			} catch (TelegramApiException e) {
				Main.log.error(e);
			}
		}
	}

	public void write(Update update, String command, String projectName, String text) {
		channel.write(standardMensaje(update, command, projectName, text));
	}

	public static boolean isDebug() {
		return debug;
	}

	public static void setDebug(boolean debug) {
		TelegramControl.debug = debug;
		if (debug) {
			NAME_BOT = NAME_BOT_PRUEBA;
			ID_BOT = ID_BOT_PRUEBA;
		} else {
			NAME_BOT = NAME_BOT_MODELLING;
			ID_BOT = ID_BOT_MODELLING;
		}
	}

}