package es.uam.app.channels.telegramCommands.secrect;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.telegram.telegrambots.api.objects.Update;

import es.uam.app.channels.CommandList;
import es.uam.app.channels.telegramCommands.TelegramControl;
import es.uam.app.message.ConsensusMsg;
import es.uam.app.message.SendMessageExc;
import socioProjects.User;

public class VoteAction extends SecretCommand {

	private Map<Long, Map<String, Integer>> options = new HashMap<Long, Map<String, Integer>>();

	// private static String star="\u2b50\ufe0f";

	private static final String[] OPTIONS = { "Select one branch", " Perform another iteration" };

	private Map<Long, List<String>> votingOptions = new HashMap<Long, List<String>>();
	private Map<Long, List<String>> votingBranchOptions = new HashMap<Long, List<String>>();
	private Map<Long, ConsensusMsg> msg = new HashMap<>();
	private Map<Long, String> last = new HashMap<>();

	private Map<Long, Integer> privateState = new HashMap<Long, Integer>();

	private static final int COLLECT_VOTE = 0;
	private static final int SELECT_CONTINUE = 1;
	private static final int SELECT_ONE = 2;
	// private static final int VOTE_AGAIN = 3;

	public VoteAction(TelegramControl tChannel) {
		super(tChannel);
	}

	@Override
	public String getCommand() {
		return "VoteAction";
	}

	@Override
	public void commandAction(Update update) {

	}

	public void modellingPrivateMsg(int msgId, long chatId, boolean isThisChannel, ConsensusMsg sMessage) {

		if (sMessage.start()) {
			SendMessageExc send = new SendMessageExc(sMessage.getMessage() + "\nFor the project "
					+ sMessage.getProjectName() + ", what are your preferences?", sMessage.getPng());

			for (User u : sMessage.getUsers()) {
				if (u.getChannel().equalsIgnoreCase(tChannel.getChannelName())) {

					long id = u.getId();
					this.setState(id);
					this.privateState.put(id, COLLECT_VOTE);
					tChannel.sendMessage(-1, id, send);

					Set<String> keySet = sMessage.getBranchs().keySet();
					for (String key : keySet) {
						SendMessageExc send2 = new SendMessageExc(key, sMessage.getBranchs().get(key));
						tChannel.sendMessage(-1, id, send2);
					}

					SendMessageExc send2 = new SendMessageExc("Give a value for each options");
					tChannel.sendMessage(-1, id, send2);
					options.put(id, new HashMap<>());
					createVotinOptions(id, sMessage.getBranchs().size());
					createVotinBranchOptions(id, sMessage.getBranchs().keySet());
					msg.put(id, sMessage);
					sendVotingOptions(id);
				}
			}

		} else if (sMessage.end()) {
			if (isThisChannel) {
				tChannel.sendMessage(msgId, chatId, sMessage);
				this.setStandardState(chatId);
				this.privateState.put(chatId, null);
			}
			SendMessageExc aux = new SendMessageExc("");
			for (User u : sMessage.getUsers()) {
				if (u.getChannel().equalsIgnoreCase(tChannel.getChannelName())) {
					long id = u.getId();
					this.setStandardState(chatId);
					this.privateState.put(id, null);
					aux.setText(sMessage.getUserMsg(u));
					tChannel.sendMessage(-1, id, aux);
				}
			}
		} else {

			SendMessageExc aux = new SendMessageExc("");
			for (User u : sMessage.getUsers()) {
				if (u.getChannel().equalsIgnoreCase(tChannel.getChannelName())) {
					long id = u.getId();

					// this.setStandardState(id);
					this.privateState.put(id, null);
					aux.setText(sMessage.getUserMsg(u));
					tChannel.sendMessage(-1, id, aux);
				}
			}
			if (isThisChannel) {
				if (!privateState.containsKey(chatId)) {
					msg.put(chatId, sMessage);
					tChannel.sendMessage(msgId, chatId, sMessage);
				}
				SendMessageExc send = new SendMessageExc("What do you want to do?");
				tChannel.sendMessageWithKeyBoar(msgId, chatId, send, new String[][] { { OPTIONS[0] }, { OPTIONS[1] } });

			}

			this.setState(chatId);
			this.privateState.put(chatId, SELECT_CONTINUE);
		}
	}

	private void createVotinOptions(long id, int max) {
		List<String> options = new ArrayList<String>();
		for (int i = 1; i <= max; i++) {
			options.add(i + "");
		}
		this.votingOptions.put(id, options);
	}

	private void createVotinBranchOptions(long id, Set<String> branches) {
		List<String> options = new ArrayList<String>();
		for (String s : branches) {
			options.add(s);
		}
		this.votingBranchOptions.put(id, options);
	}

	public boolean sendVotingOptions(long id) {
		List<String> projects = votingBranchOptions.get(id);
		if (projects.isEmpty()) {
			return false;
		}

		String p = projects.get(0);
		SendMessageExc send = new SendMessageExc(p, msg.get(id).getBranchs().get(p));
		tChannel.sendMessageWithKeyBoar(-1, id, send, votingOptionsToArray(votingOptions.get(id)));
		last.put(id, p);
		projects.remove(p);
		votingBranchOptions.put(id, projects);
		return true;
	}

	public String[][] votingOptionsToArray(List<String> v) {

		String[][] ret = new String[v.size()][1];
		for (int i = 0; i < v.size(); i++) {
			ret[i][0] = v.get(i);
		}

		return ret;
	}

	@Override
	public void userAnswerText(Update update) {
		long id = update.getMessage().getChatId();
		if (privateState.get(id) == COLLECT_VOTE) {
			Map<String, Integer> opt = options.get(id);
			if (opt == null) {
				opt = new HashMap<>();
			}

			int val = Integer.parseInt(update.getMessage().getText());
			opt.put(last.get(id), val);
			options.put(id, opt);

			List<String> votingOpt = votingOptions.get(id);
			votingOpt.remove(update.getMessage().getText());
			votingOptions.put(id, votingOpt);
			if (sendVotingOptions(id) == false) {
				String poll = "";
				for (String k : opt.keySet()) {
					poll += k + ":" + opt.get(k) + "-";
				}
				tChannel.write(update, CommandList.ADD_POLL, msg.get(id).getProjectName(), "",
						msg.get(id).getConsensusName() + "#" + poll);
			}
		} else if (privateState.get(id) == SELECT_CONTINUE) {
			ConsensusMsg sMessage = msg.get(id);

			if (update.getMessage().getText().equalsIgnoreCase(OPTIONS[0])) {// Select
																				// one
				Set<String> keySet = sMessage.getBranchs().keySet();
				String[][] opt = new String[keySet.size()][1];
				int i = 0;
				for (String key : keySet) {
					opt[i][0] = key;
					i++;
					SendMessageExc send2 = new SendMessageExc(key, sMessage.getBranchs().get(key));
					tChannel.sendMessage(-1, id, send2);
				}

				privateState.put(id, SELECT_ONE);
				this.setState(id);
				SendMessageExc send = new SendMessageExc("What?");

				tChannel.sendMessageWithKeyBoar(-1, id, send, opt);

			} else {// Vote again
				tChannel.write(update, CommandList.START_C_VOTING, sMessage.getProjectName(), "",
						sMessage.getConsensusName());

			}
		} else if (privateState.get(id) == SELECT_ONE) {
			ConsensusMsg sMessage = msg.get(id);
			String text = update.getMessage().getText();
			this.setStandardState(id);
			tChannel.write(update, CommandList.MAKE_DECISION, sMessage.getProjectName(), "",
					sMessage.getConsensusName() + "-" + text);
		}

	}

}
