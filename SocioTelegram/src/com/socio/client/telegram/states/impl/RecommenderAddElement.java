package com.socio.client.telegram.states.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.telegram.telegrambots.api.objects.CallbackQuery;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import com.socio.client.command.responseExceptions.ForbiddenResponse;
import com.socio.client.command.responseExceptions.ResponseError;
import com.socio.client.telegram.Chat;
import com.socio.client.telegram.states.ConversationalState;
import com.socio.client.telegram.states.State;

public class RecommenderAddElement implements ConversationalState {

	private static final String FEATURES = "features";
	private static final String SUPERCLASSES = "superClasses";
	private static final String TYPE = "type";
	private static final String BACK = "\u2b05\ufe0f" + " back";
	// private JSONObject object;
	private String elementSelected = null;
	private Map<String, Map<String, Map<String, String>>> elements;

	public static RecommenderAddElement getState(JSONObject object) {
		return new RecommenderAddElement(object);
	}

	private RecommenderAddElement(JSONObject object) {
		// this.object = object;
		this.elements = new HashMap<String, Map<String, Map<String, String>>>();
		if (object.names() != null) {
			for (int i = 0; i < object.names().length(); i++) {
				String className = object.names().getString(i);
				JSONObject classObject = object.getJSONObject(className);
				Map<String, Map<String, String>> elements = new HashMap<String, Map<String, String>>();
				if (classObject.has(FEATURES)) {
					Map<String, String> featuresMap = new HashMap<String, String>();
					JSONObject features = classObject.getJSONObject(FEATURES);

					if (features.names() != null) {
						for (int j = 0; j < features.names().length(); j++) {
							String featureName = features.names().getString(j);
							String featureType = features.getJSONObject(featureName).getString(TYPE);
							double value = features.getJSONObject(featureName).getDouble("value");
//							featuresMap.put("A:" + className + "." + featureName + ":" + featureType,
//									featureName + ":" + featureType + ":" + value);
							featuresMap.put("A:" + className + "." + featureName + ":" + featureType + "/" + value,
									featureName + ":" + featureType);
						}
						featuresMap = sortedMap(featuresMap);
					}
					elements.put(FEATURES, featuresMap);
				}
				if (classObject.has(SUPERCLASSES)) {
					Map<String, String> superClassMap = new HashMap<String, String>();
					JSONObject superClass = classObject.getJSONObject(SUPERCLASSES);
					if (superClass.names() != null) {
						for (int j = 0; j < superClass.names().length(); j++) {
							String superClassName = superClass.names().getString(j);
							double value = superClass.getJSONObject(superClassName).getDouble("value");
							superClassMap.put("S:" + className + "." + superClassName + "/" + value,
									superClassName);
						}
						superClassMap = sortedMap(superClassMap);
					}
					elements.put(SUPERCLASSES, superClassMap);
				}
				this.elements.put(className, elements);
			}
		}
	}

	private Map<String, String> sortedMap(Map<String, String> featuresMap) {
		LinkedHashMap<String, String> ret = new LinkedHashMap<String, String>();
		List<Map.Entry<String, String>> list = new LinkedList<>(featuresMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> o1, Map.Entry<String, String> o2) {
				String string1 = o1.getKey();
				String string2 = o2.getKey();
				String valueString1 = string1.substring(string1.indexOf("/") + 1, string1.length());
				String valueString2 = string2.substring(string2.indexOf("/") + 1, string2.length());
				Double value1 = Double.parseDouble(valueString1);
				Double value2 = Double.parseDouble(valueString2);

				return value2.compareTo(value1);
			}
		});

		for (Map.Entry<String, String> entry : list) {
			String string1 = entry.getKey();
			String valueString1 = string1.substring(string1.indexOf("/") + 1, string1.length());
			ret.put(string1.replace("/" + valueString1, ""), entry.getValue());
		}
		return ret;
	}

	@Override
	public State runAndNext(Chat chat, Message message) throws TelegramApiException, ResponseError, ForbiddenResponse {
		chat.sendMessage("Nothing to do", false);

		return Chat.getDefaultState();
	}

	public void runAndNext(Chat chat, CallbackQuery callbackQuery)
			throws TelegramApiException, ResponseError, ForbiddenResponse {
		JSONObject model = null;
		String text = callbackQuery.getData();
		if (text.equals("Attribute")) {
			sendAttributesMenu(chat, callbackQuery, true);
			return;
		} else if (text.equals("Super type")) {
			sendSuperClassMenu(chat, callbackQuery, true);
			return;
		} else if (text.startsWith("back")) {
			if (text.equals("backAttr") || text.equals("backSuperClass")) {
				boolean back = elements.size() > 1;
				Map<String, Map<String, String>> classElement = elements.get(elementSelected);
				if (classElement.containsKey(FEATURES) && classElement.get(FEATURES).size() > 0
						&& classElement.containsKey(SUPERCLASSES) && classElement.get(SUPERCLASSES).size() > 0) {
					sendElementMenu(chat, callbackQuery, back);
				} else {
					sendTotalElementMenu(chat, callbackQuery);
				}
			} else {
				sendTotalElementMenu(chat, callbackQuery);
			}
			return;
		} else if (text.startsWith("A:")) {
			String text2 = text.replace("A:", "");
			model = getFeatureObject(text2);
			Map<String, String> featuresMap = elements.get(elementSelected).get(FEATURES);
			boolean back = false;
			if (elements.size() > 1) {
				back = true;
			} else if (elements.get(elementSelected).containsKey(SUPERCLASSES)) {
				if (elements.get(elementSelected).get(SUPERCLASSES).size() > 0 && featuresMap.size() > 1) {
					back = true;
				}
			}
			featuresMap.remove(text);
			if (featuresMap.size() > 0) {
				sendAttributesMenu(chat, callbackQuery, back);
			} else {
				sendElementMenu(chat, callbackQuery, back);
			}
		} else if (text.startsWith("S:")) {
			String text2 = text.replace("S:", "");
			model = getSperClassObject(text2);
			Map<String, String> superClassesMap = elements.get(elementSelected).get(SUPERCLASSES);
			boolean back = false;
			if (elements.size() > 1) {
				back = true;
			} else if (elements.get(elementSelected).containsKey(FEATURES)) {
				if (elements.get(elementSelected).get(FEATURES).size() > 0 && superClassesMap.size() > 1) {
					back = true;
				}
			}
			superClassesMap.remove(text);
			if (superClassesMap.size() > 0) {
				sendSuperClassMenu(chat, callbackQuery, back);
			} else {
				sendElementMenu(chat, callbackQuery, back);
			}
		} else {

			if (elements.containsKey(text)) {
				elementSelected = text;
				sendElementMenu(chat, callbackQuery, true);
			} else {
				chat.sendMessage("ERR: " + text, false);
			}
			return;

		}
		File file = State.SOCIO().add(chat.getProject(), State.getUser(callbackQuery.getFrom()),
				"Element added by recommender", new Date(), getMessageId(callbackQuery.getMessage()), model);
		chat.sendPhoto(file, callbackQuery.getMessage().getMessageId());
		chat.sendMessage("Element " + text + " added", false);
		return;
	}

	private JSONObject getSperClassObject(String text) {

		String[] split = text.split("\\.");
		String className = split[0];
		String superClassName = split[1];
		JSONObject model = new JSONObject();
		JSONObject classObject = new JSONObject();
		JSONArray superClasses = new JSONArray();
		superClasses.put(superClassName);
		classObject.put(SUPERCLASSES, superClasses);
		model.put(className, classObject);
		return model;
	}

	public void sendFirstMessage(Chat chat, CallbackQuery message) throws TelegramApiException {

		if (elements.keySet().size() > 1) {
			sendTotalElementMenu(chat, message);
		} else {
			elementSelected = elements.keySet().iterator().next();
			sendElementMenu(chat, message, false);
		}

	}

	public JSONObject getFeatureObject(String text) {
		String[] split = text.split("\\.");
		String className = split[0];
		split = split[1].split(":");
		String attrName = split[0];
		String type = split[1];

		JSONObject classObject = new JSONObject();
		JSONObject attr = new JSONObject();
		attr.put("type", type);
		JSONObject features = new JSONObject();
		features.put(attrName, attr);
		classObject.put("features", features);

		JSONObject model = new JSONObject();
		model.put(className, classObject);
		return model;
	}

	private void sendTotalElementMenu(Chat chat, CallbackQuery callbackQuery) throws TelegramApiException {
		this.elementSelected = null;
		List<String> optionsList = new ArrayList<>();
		List<String> valueList = new ArrayList<>();
		for (String key : elements.keySet()) {
			optionsList.add(key);
			valueList.add(key);
		}
		String text = "Select an element";
		String[] options = new String[optionsList.size()];
		options = optionsList.toArray(options);

		String[] values = new String[valueList.size()];
		values = valueList.toArray(values);
		if (callbackQuery == null) {
			chat.sendMessage(text, -1, false, createInlineKeyboard(options, values));
		} else {
			chat.updateMessage(text, callbackQuery, false, createInlineKeyboard(options, values));
		}

	}

	private void sendElementMenu(Chat chat, CallbackQuery callbackQuery, boolean back) throws TelegramApiException {
		List<String> optionsList = new ArrayList<>();
		List<String> valueList = new ArrayList<>();
		String text;
		Map<String, Map<String, String>> classElement = elements.get(elementSelected);
		if (classElement.containsKey(FEATURES) && classElement.get(FEATURES).size() > 0
				&& classElement.containsKey(SUPERCLASSES) && classElement.get(SUPERCLASSES).size() > 0) {
			text = "Select what kind of element do you want for the class " + elementSelected;
			optionsList.add("Attributes");
			optionsList.add("Super types");

			valueList.add("Attribute");
			valueList.add("Super type");
			if (back) {
				optionsList.add(BACK);
				valueList.add("backElementMenu");
			}
			String[] options = new String[optionsList.size()];
			options = optionsList.toArray(options);

			String[] values = new String[valueList.size()];
			values = valueList.toArray(values);
			if (callbackQuery == null) {
				chat.sendMessage(text, -1, false, createInlineKeyboard(options, values));
			} else {
				chat.updateMessage(text, callbackQuery, false, createInlineKeyboard(options, values));
			}
		} else if (classElement.containsKey(FEATURES) && classElement.get(FEATURES).size() > 0) {
			sendAttributesMenu(chat, callbackQuery, back);
		} else {
			sendSuperClassMenu(chat, callbackQuery, back);
		}

	}

	private void sendAttributesMenu(Chat chat, CallbackQuery callback, boolean back) throws TelegramApiException {
		String text = "Select an attribute to add to the class " + elementSelected;
		List<String> optionsList = new ArrayList<>();
		List<String> valueList = new ArrayList<>();
		Map<String, Map<String, String>> classObject = elements.get(elementSelected);
		Map<String, String> features = classObject.get(FEATURES);
		if (features != null) {
			for (String value : features.keySet()) {
				String option = features.get(value);
				valueList.add(value);
				optionsList.add(option);

			}
		}
		if (back) {
			optionsList.add(BACK);
			valueList.add("backAttr");
		}
		String[] options = new String[optionsList.size()];
		options = optionsList.toArray(options);

		String[] values = new String[valueList.size()];
		values = valueList.toArray(values);
		if (callback == null) {
			chat.sendMessage(text, -1, false, createInlineKeyboard(options, values));
		} else {
			chat.updateMessage(text, callback, false, createInlineKeyboard(options, values));
		}

	}

	private void sendSuperClassMenu(Chat chat, CallbackQuery callback, boolean back) throws TelegramApiException {
		String text = "Select a super class to add to the class " + elementSelected;
		List<String> optionsList = new ArrayList<>();
		List<String> valueList = new ArrayList<>();
		Map<String, Map<String, String>> classObject = elements.get(elementSelected);
		Map<String, String> superClass = classObject.get(SUPERCLASSES);
		if (superClass != null) {
			for (String value : superClass.keySet()) {
				String option = superClass.get(value);
				valueList.add(value);
				optionsList.add(option);

			}
		}

		if (back) {
			optionsList.add(BACK);
			valueList.add("backSuperClass");
		}
		String[] options = new String[optionsList.size()];
		options = optionsList.toArray(options);

		String[] values = new String[valueList.size()];
		values = valueList.toArray(values);

		if (callback == null) {
			chat.sendMessage(text, -1, false, createInlineKeyboard(options, values));
		} else {
			chat.updateMessage(text, callback, false, createInlineKeyboard(options, values));
		}
	}

	private InlineKeyboardMarkup createInlineKeyboard(String[] options, String[] values) throws TelegramApiException {
		List<List<InlineKeyboardButton>> rows = new ArrayList<List<InlineKeyboardButton>>();
		;
		if (options.length <= 4) {
			for (int j = 0; j < options.length; j++) {
				String option = options[j];
				String value = values[j];
				List<InlineKeyboardButton> row = new ArrayList<InlineKeyboardButton>();
				InlineKeyboardButton button = new InlineKeyboardButton();
				button.setText(option);
				button.setCallbackData(value);
				row.add(button);
				rows.add(row);
			}
		} else {
			int cols = 2;
			int i = 0;
			List<InlineKeyboardButton> row = null;
			for (int j = 0; j < options.length; j++) {
				String option = options[j];
				String value = values[j];

				if (i % cols == 0) {
					if (row != null) {
						rows.add(row);
					}
					row = new ArrayList<InlineKeyboardButton>();
				}

				InlineKeyboardButton button = new InlineKeyboardButton();
				button.setText(option);
				button.setCallbackData(value);
				row.add(button);
				i++;
			}
			rows.add(row);
		}
		InlineKeyboardMarkup keyboardMarkup = new InlineKeyboardMarkup();
		keyboardMarkup.setKeyboard(rows);
		return keyboardMarkup;
	}

//	List<String> optionsList = new ArrayList<>();
//	if (elements.names() != null) {
//		for (int i = 0; i < elements.names().length(); i++) {
//			String className = elements.names().getString(i);
//			JSONObject classObject = elements.getJSONObject(className);
//			if (classObject.has("features")) {
//				JSONObject features = classObject.getJSONObject("features");
//				if (features.names() != null) {
//					for (int j = 0; j < features.names().length(); j++) {
//						String type = features.getJSONObject(features.names().getString(j)).getString("type");
//						String featreName = className + "." + features.names().getString(j);
//						optionsList.add("A: " + featreName + ":" + type);
//					}
//				}
//			}
//		}
//	}
//
//	String[] options = new String[optionsList.size()];
//	options = optionsList.toArray(options);
//
//	chat.sendMessageWithInlineKeyboard("This is are your recommendations", message.getMessageId(), false, options);

}
