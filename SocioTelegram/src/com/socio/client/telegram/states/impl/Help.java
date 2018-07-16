package com.socio.client.telegram.states.impl;

import java.util.ArrayList;
import java.util.List;

import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.CommandState;
import com.socio.client.telegram.states.State;

public class Help implements CommandState {
	private static Help HELP = new Help();

	public static Help getState() {
		return HELP;
	}

	private Help() {
	}
	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {

		String[] help=SOCIO.help();
		
		InlineKeyboardMarkup inlineKeyBoar = new InlineKeyboardMarkup();
		List<List<InlineKeyboardButton>> rows = new ArrayList<List<InlineKeyboardButton>>();
		List<InlineKeyboardButton> row = new ArrayList<InlineKeyboardButton>();
		InlineKeyboardButton button = new InlineKeyboardButton();
		button.setText("Help web page");
		button.setUrl(help[1]);
		row.add(button);
		rows.add(row);
		inlineKeyBoar.setKeyboard(rows);
		
		chat.sendMessage(help[0], message.getMessageId(), false, inlineKeyBoar);
		
		return Chat.getDefaultState();
	}

	@Override
	public String getCommand() {
		return "help";
	}

	@Override
	public String getDescription() {
		return "give you a help web page";
	}

}
