package recommenderQuestionnaire.evaluations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

import generator.Bot;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import recommenderQuestionnaire.Evaluation;
import recommenderQuestionnaire.Questionnaire;

public abstract class Evaluator {

	protected List<String> options = null;
	protected String text;

	public static void loadEvaluators(Questionnaire questionnaire, String json)
			throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		// Buscar todas las clases que van a evaluarse sobre el modelo
		List<Class<? extends Evaluator>> evaluators = new ArrayList<>();
		new FastClasspathScanner(Evaluator.class.getPackage().getName())
				.matchSubclassesOf(Evaluator.class, evaluators::add).scan();
		JSONObject object = null;
		if (json != null) {
			object = readJsonFile(json);
		}
		// Crear una instancia de cada clase
		for (Class<? extends Evaluator> evaluatorClass : evaluators) {
			// Obtenemos el constructos, si es null pasamos al siguiente
			Constructor<? extends Evaluator> evaluatorConstructor = evaluatorClass
					.getConstructor(new Class[] { List.class });

			if (evaluatorConstructor != null) {
				Evaluation qEvaluation = questionnaire.getEvaluation(evaluatorClass.getName());
				List<String> options;
				// Si el modelo no tiene la evaluación la crea
				if (qEvaluation == null) {
					if (object != null) {
						String name = evaluatorClass.getSimpleName();
						options = getOptions(object, name);
						Map<String, List<String>> accepted = getAccepted(object, name);
						Map<String, List<String>> refused = getRefused(object, name);
						Map<String, List<String>> unknown = getUnknwon(object, name);
						List<String> tools = getTools(accepted, refused, unknown);
						// create tools in the model
						for (String tool : tools) {
							questionnaire.createTool(tool);
						}
						Evaluator ev = evaluatorConstructor.newInstance(options);
						qEvaluation = questionnaire.createEvaluation(evaluatorClass.getName(), ev.getText(),
								ev.getMultiresponse(), options, accepted, refused, ev);
					}
				} else {
					options = qEvaluation.getOptionsString();
					Evaluator ev = evaluatorConstructor.newInstance(options);
					qEvaluation.setEvaluator(ev);

				}
			}
		}

	}

	protected String getText() {
		if (text == null) {
			text = "";
		}
		return text;
	}

	private static JSONObject readJsonFile(String json) {
		return new JSONObject(readFile(json));

	}

	private static String readFile(String json) {
		String ret = "";
		try {
			// FileReader reads text files in the default encoding.
			FileReader fileReader = new FileReader(json);

			// Always wrap FileReader in BufferedReader.
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				ret += line;
			}

			// Always close files.
			bufferedReader.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return ret;
	}


	private static Map<String, List<String>> getAccepted(JSONObject object, String name) {
		return getWhatever(object, name, "accepted");
	}

	private static Map<String, List<String>> getRefused(JSONObject object, String name) {
		return getWhatever(object, name, "refused");
	}

	private static Map<String, List<String>> getUnknwon(JSONObject object, String name) {
		return getWhatever(object, name, "unknown");
	}

	private static List<String> getTools(Map<String, List<String>> accepted, Map<String, List<String>> refused,
			Map<String, List<String>> unknown) {
		List<String> ret = new ArrayList<String>();
		for (String s : accepted.keySet()) {
			for (String tool : accepted.get(s)) {
				if (!ret.contains(tool)) {
					ret.add(tool);
				}
			}
		}
		for (String s : refused.keySet()) {
			for (String tool : refused.get(s)) {
				if (!ret.contains(tool)) {
					ret.add(tool);
				}
			}
		}
		for (String s : unknown.keySet()) {
			for (String tool : unknown.get(s)) {
				if (!ret.contains(tool)) {
					ret.add(tool);
				}
			}
		}
		return ret;
	}

	private static Map<String, List<String>> getWhatever(JSONObject object, String name, String whatever) {
		Map<String, List<String>> whateverMap = new HashMap<>();
		if (object.has(name)) {
			JSONObject subObject = object.getJSONObject(name);
			for (String opt : subObject.keySet()) {
				JSONObject options = subObject.getJSONObject(opt);
				JSONArray aceptedJSONArray = options.getJSONArray(whatever);
				List<String> tools = getToolList(aceptedJSONArray);
				whateverMap.put(opt, tools);
			}
		}
		return whateverMap;
	}

	private static List<String> getOptions(JSONObject object, String name) {
		List<String> options = new ArrayList<>();
		if (object.has(name)) {
			JSONObject subObject = object.getJSONObject(name);
			options.addAll(subObject.keySet());
		}
		return options;
	}

	public Evaluator(List<String> options) {
		this.options = options;
	}

	private static List<String> getToolList(JSONArray toolsName) {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < toolsName.length(); i++) {
			String tool = toolsName.getString(i);
			ret.add(tool);
		}
		return ret;
	}

	public String getValue(String val) {
		for (String opt : getOptions()) {
			if (opt.equalsIgnoreCase(val)) {
				return opt;
			}
		}
		return null;
	}

	protected abstract boolean getMultiresponse();

	/* returns the list of options the bot satisfy */
	public abstract List<String> evaluate(Bot bot);

	protected List<String> getOptions() {
		return options;
	}

	protected void setOptions(List<String> options) {
		this.options = options;
	}
}
