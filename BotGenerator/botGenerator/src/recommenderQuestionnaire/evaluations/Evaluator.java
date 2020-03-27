package recommenderQuestionnaire.evaluations;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONArray;
import org.json.JSONObject;

import generator.Bot;
import io.github.lukehutch.fastclasspathscanner.FastClasspathScanner;
import recommenderQuestionnaire.Evaluation;
import recommenderQuestionnaire.Questionnaire;

public abstract class Evaluator {

	public static String json = "language.json";

	protected List<String> options = null;
	protected List<String> tools = null;
	protected Map<String, List<String>> accepted;
	protected Map<String, List<String>> refused;
	protected Map<String, List<String>> unknown;

	public static void loadEvaluators(Questionnaire questionnaire) throws NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		// Buscar todas las clases que van a evaluarse sobre el modelo
		List<Class<? extends Evaluator>> evaluators = new ArrayList<>();
		new FastClasspathScanner(Evaluator.class.getPackage().getName())
				.matchSubclassesOf(Evaluator.class, evaluators::add).scan();

		JSONObject object = readJsonFile();
		// Crear una instancia de cada clase
		for (Class<? extends Evaluator> evaluatorClass : evaluators) {
			Constructor<? extends Evaluator> evaluatorConstructor = evaluatorClass
					.getConstructor(new Class[] { JSONObject.class });
			if (evaluatorConstructor != null) {
				Evaluator ev = evaluatorConstructor.newInstance(object);
				Evaluation qEvaluation = questionnaire.getEvaluation(evaluatorClass.getName());
				if (qEvaluation == null) {
					// create tools in the model
					for (String tool : ev.getTools()) {
						questionnaire.createTool(tool);
					}

					List<String> options = ev.getOptions();
					Map<String, List<String>> acepted = ev.getAccepted();
					Map<String, List<String>> refused = ev.getRefused();
					qEvaluation = questionnaire.createEvaluation(evaluatorClass.getName(), evaluatorClass.getName(),
							ev.getMultiresponse(), options, acepted, refused, ev);
				} else {
					qEvaluation.setEvaluator(ev);
				}

			}
		}
	}

	private static JSONObject readJsonFile() {
		return new JSONObject(readFile());

	}

	private static String readFile() {
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

	public Evaluator (JSONObject object, String name) {
		this.options = new ArrayList<String>();
		this.tools = new ArrayList<String>();
		this.accepted = new HashMap<String, List<String>>();
		this.refused = new HashMap<String, List<String>>();
		this.unknown = new HashMap<String, List<String>>();
		
		if (object.has(name)) {
			JSONObject subObject = object.getJSONObject(name);
			Set<String> keys = subObject.keySet();
			options.addAll(keys);

			for (String lan : keys) {

				JSONObject options = subObject.getJSONObject(lan);

				JSONArray aceptedJSONArray = options.getJSONArray("acepted");
				List<String> accepted = getToolList(aceptedJSONArray);
				this.accepted.put(lan, accepted);

				JSONArray refusedJSONArray = options.getJSONArray("refused");
				List<String> refused = getToolList(refusedJSONArray);
				this.refused.put(lan, refused);

				JSONArray unknownJSONArray = options.getJSONArray("unknown");
				List<String> unknown = getToolList(unknownJSONArray);
				this.unknown.put(lan, unknown);
			}
		}
	}

	private List<String> getToolList(JSONArray toolsName) {
		List<String> ret = new ArrayList<String>();
		for (int i = 0; i < toolsName.length(); i++) {
			String tool = toolsName.getString(i);
			ret.add(tool);
			if (!this.tools.contains(tool)) {
				this.tools.add(tool);
			}
		}
		return ret;
	}
	public String getValue(String val) {
		for (String opt: getOptions()) {
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

	protected List<String> getTools() {
		return tools;
	}

	protected void setTools(List<String> tools) {
		this.tools = tools;
	}

	protected Map<String, List<String>> getAccepted() {
		return accepted;
	}

	protected void setAccepted(Map<String, List<String>> accepted) {
		this.accepted = accepted;
	}

	protected Map<String, List<String>> getRefused() {
		return refused;
	}

	protected void setRefused(Map<String, List<String>> refused) {
		this.refused = refused;
	}

	protected Map<String, List<String>> getUnknown() {
		return unknown;
	}

	protected void setUnknown(Map<String, List<String>> unknown) {
		this.unknown = unknown;
	}
}
