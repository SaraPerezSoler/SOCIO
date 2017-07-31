package es.uam.app.channels.telegramCommands;

import java.util.HashMap;
import java.util.Map;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.main.Main.MainCommandEnum;
import es.uam.app.message.SendMessageExc;

public class HistoryStatistics extends HistoryOption {

	private static HistoryStatistics historyStatistics = null;
	protected final String KIND = "Which kind?";

	public static HistoryStatistics getHistoryStatistics(History history) {
		if (historyStatistics == null) {
			historyStatistics = new HistoryStatistics(history);
		}
		return historyStatistics;
	}

	private final String[] KIND_OPTIONS = { "Messages from one user", "Messages from all users",
			"Actions from one user", "Actions from all user", "All actions", "Percent of authorship" };
	private final String YES_OPTION = "Yes";
	private final String NO_OPTION = "No";

	private Map<Long, Boolean> start_state = new HashMap<Long, Boolean>();
	private String option = null;

	private HistoryStatistics(History history) {
		super(history);
	}

	@Override
	public void userAnswerText(Update update) {

		String text = update.getMessage().getText();
		// start_state el usuario a elegido de que tipo quiere las estadisticas
		// (user-msg, user-actions, actions)
		if (start_state.get(update.getMessage().getChatId())) {
			start_state.put(update.getMessage().getChatId(), false);
			if (text.equals(KIND_OPTIONS[0]) || text.equals(KIND_OPTIONS[2])) {
				option = text;
				SendMessageExc sMessage = new SendMessageExc(WHO);
				history.setState(update.getMessage().getChatId());
				history.tChannel.sendMessageAndWait(update.getMessage().getMessageId(), update.getMessage().getChatId(),
						sMessage);
			} else if (text.equals(KIND_OPTIONS[1]) || text.equals(KIND_OPTIONS[3])) {

				option = text;
				SendMessageExc sMessage = new SendMessageExc("Do you want see the statistics sorted by date?");
				history.setState(update.getMessage().getChatId());
				history.tChannel.sendMessageWithKeyBoar(update.getMessage().getMessageId(),
						update.getMessage().getChatId(), sMessage,
						new String[][] { { YES_OPTION }, { NO_OPTION }, { BACK } });
			} else if (text.equals(KIND_OPTIONS[4])) {
				history.tChannel.write(update, MainCommandEnum.ACTIONS_STATISTICS.getName(),
						history.getProject(update.getMessage().getChatId()), "");
			} else if (text.equals(KIND_OPTIONS[5])) {
				history.tChannel.write(update, MainCommandEnum.RATE_STATISTICS.getName(),
						history.getProject(update.getMessage().getChatId()), "");
			} else {
				history.commandAction(update);
			}
			//
		} else {
			if (option == null) {
				history.exit(update);
			}
			if (option.equals(KIND_OPTIONS[0])) {
				history.tChannel.write(update, MainCommandEnum.USER_MSG_STATISTICS.getName(),
						history.getProject(update.getMessage().getChatId()), update.getMessage().getText());

			} else if (option.equals(KIND_OPTIONS[2])) {
				history.tChannel.write(update, MainCommandEnum.USER_ACTIONS_STATISTICS.getName(),
						history.getProject(update.getMessage().getChatId()), update.getMessage().getText());
			} else if (option.equals(KIND_OPTIONS[1])) {
				if (update.getMessage().getText().equals(YES_OPTION)) {
					history.tChannel.write(update, MainCommandEnum.USER_MSG_STATISTICS.getName(),
							history.getProject(update.getMessage().getChatId()), "");
				} else if (update.getMessage().getText().equals(NO_OPTION)) {
					history.tChannel.write(update, MainCommandEnum.ABS_USER_MSG_STATISTICS.getName(),
							history.getProject(update.getMessage().getChatId()), "");
				}
			} else if (option.equals(KIND_OPTIONS[3])) {

				if (update.getMessage().getText().equals(YES_OPTION)) {
					history.tChannel.write(update, MainCommandEnum.USER_ACTIONS_STATISTICS.getName(),
							history.getProject(update.getMessage().getChatId()), "");

				} else if (update.getMessage().getText().equals(NO_OPTION)) {
					history.tChannel.write(update, MainCommandEnum.ABS_USER_ACTIONS_STATISTICS.getName(),
							history.getProject(update.getMessage().getChatId()), "");

				} else {
					this.start(update);
				}

			} else {
				history.exit(update);
			}
			option = null;
		}

	}

	@Override
	public void start(Update update) {
		SendMessageExc sMessage = new SendMessageExc(KIND);
		String[][] options = new String[][] { { KIND_OPTIONS[0], KIND_OPTIONS[1] },
				{ KIND_OPTIONS[2], KIND_OPTIONS[3] }, { KIND_OPTIONS[4] , KIND_OPTIONS[5]}, { BACK }, };
		history.setState(update.getMessage().getChatId());
		start_state.put(update.getMessage().getChatId(), true);

		history.gettChannel().sendMessageWithKeyBoar(update.getMessage().getMessageId(),
				update.getMessage().getChatId(), sMessage, options);

	}

}
