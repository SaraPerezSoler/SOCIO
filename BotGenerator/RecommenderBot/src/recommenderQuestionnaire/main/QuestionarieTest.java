package recommenderQuestionnaire.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import answers.QuestionAnswer.RelevanceLevel;
import generator.Bot;

public class QuestionarieTest {
	private static final String RECOMENDER_MODEL_PATH = "recomenderModel.xmi";


	public static void main(String[] args) {

		startMenu();

	}

	static void startMenu() {
		System.out.println(
				"This questionnaire is to recommend the chatbots creation tool that best suits your needs. You can:");
		String[] options = { "Answer the questionnaire", "Create new question", "Add new chatbot creation tool",
				"Exit" };
		int option = readOption(options);
		switch (option) {
		case 1:
			answerQuestionnaire();
			break;
		case 2:
			createQuestion();
		case 3:
			addTool();
		default:
			break;
		}
	}

	private static void addTool() {
		// TODO Auto-generated method stub

	}

	private static void createQuestion() {
		// TODO Auto-generated method stub

	}

	private static void answerQuestionnaire() {
		Bot bot = getBot();
		RecommenderControl control = RecommenderControl.getRecommenderControl(RECOMENDER_MODEL_PATH,  null);
		long id = control.newUser(bot, new HashMap<String, String>());
		Map<String, List<String>> questions = control.getQuestions();
		for (String key : questions.keySet()) {
			String[] options = new String[questions.get(key).size()];
			for (int i = 0; i < questions.get(key).size(); i++) {
				options[i] = questions.get(key).get(i);
			}
			System.out.println(key);
			if (control.isMulti(key)) {
				List<Integer> index = readSeveralOptions(options);
				List<String> answers = new ArrayList<String>();
				for (int i : index) {
					answers.add(options[i]);
				}
				control.addAnswer(id, key, answers, RelevanceLevel.RELEVANT);
			} else {
				int index = readOption(options);
				control.addAnswer(id, key, options[index], RelevanceLevel.RELEVANT);
			}

		}
		// Falta evaluar!

	}

	private static Bot getBot() {
		System.out.println("What is the path of the chatbot definition?");
		String path = readValue();
		Bot bot = RecommenderControl.getBot(path);
		while (bot == null) {
			System.out.println(
					"The bot definition path is not a valid path. What is the path of the chatbot definition?");
			path = readValue();
			bot = RecommenderControl.getBot(path);
		}
		return bot;
	}

	static int readOption(String[] options) {
		// MultiResponse!
		int ret = -1;
		System.out.println("Choose only one");
		while (ret == -1) {
			int max = 0;
			for (String option : options) {
				max++;
				System.out.println(max + "." + option);
			}

			try {
				String option = readValue();
				int aux = Integer.parseInt(option);
				if (aux > max || aux < 1) {
					throw new NumberFormatException();
				}
				ret = aux;
				return ret;
			} catch (NumberFormatException ex) {
				System.out.println("The option value must be a number between 1 and " + max);
			}
		}
		return 0;
	}

	static List<Integer> readSeveralOptions(String[] options) {
		List<Integer> ret = new ArrayList<>();
		System.out.println("You can choose more than one, but select it one by one. I ask you again.");
		boolean exit = false;
		int exitValue = -1;
		while (exit == false) {
			int max = 0;
			for (String option : options) {
				max++;
				System.out.println(max + "." + option);
			}
			if (!ret.isEmpty()) {
				max++;
				System.out.println(max + ". No more options (Exit)");
				exitValue = max;
			}

			try {
				String option = readValue();
				int aux = Integer.parseInt(option);
				if (aux > max || aux < 1) {
					throw new NumberFormatException();
				}
				if (exitValue != -1 && aux == exitValue) {
					exit = true;
				} else {
					ret.add(aux);
				}
				return ret;
			} catch (NumberFormatException ex) {
				System.out.println("The option value must be a number between 1 and " + max);
			}
		}
		return null;
	}

	static InputStreamReader isr = new InputStreamReader(System.in);
	static BufferedReader br = new BufferedReader(isr);

	static String readValue() {
		try {
			System.out.println("> ");
			return br.readLine();
		} catch (IOException e) {
			return "";
		}
	}

}
