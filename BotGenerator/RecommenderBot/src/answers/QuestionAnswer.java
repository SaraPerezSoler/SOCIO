package answers;

import java.util.List;

import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.Question;
import recommenderQuestionnaire.Tool;

public class QuestionAnswer {
	public enum RelevanceLevel {
		NOT_RELEVANT("Not relevant"), RELEVANT("Relevant"), DOBLE("Double relevant"),
		CRITICAL_ONE("Critical (at least one option)"), CRITICAL_ALL("Critical (all options)"), CRITICAL("Critical");

		private static final String[] MULTI_LEVEL = { RELEVANT.getText(), NOT_RELEVANT.getText(), DOBLE.getText(),
				CRITICAL_ONE.getText(), CRITICAL_ALL.getText() };
		private static final String[] NOT_MULTI_LEVEL = { RELEVANT.getText(), NOT_RELEVANT.getText(), DOBLE.getText(), CRITICAL.getText() };
		private String text;

		private RelevanceLevel(String text) {
			this.text = text;
		}

		public String getText() {
			return text;
		}
		public static RelevanceLevel getRelevanceLevelByText(String text) {
			for (RelevanceLevel level : RelevanceLevel.values()) {
				if (level.getText().equals(text)) {
					return level;
				}
			}
			return null;
		}
		public static String[] getLevelsString(boolean multi) {
			if (multi) {
				return MULTI_LEVEL;
			}
			return NOT_MULTI_LEVEL;
		}
	}

	private Question question;
	private List<Option> selecteds;
	private RelevanceLevel relevanceLevel;

	public QuestionAnswer(Question question, List<Option> selected, RelevanceLevel relevanceLevel) {
		super();
		this.question = question;
		this.selecteds = selected;
		this.relevanceLevel = relevanceLevel;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public List<Option> getSelected() {
		return selecteds;
	}

	public void setSelected(List<Option> selected) {
		this.selecteds = selected;
	}

	public RelevanceLevel getRelevanceLevel() {
		return relevanceLevel;
	}

	public void setRelevanceLevel(RelevanceLevel relevanceLevel) {
		this.relevanceLevel = relevanceLevel;
	}

	public double getRaiting(Tool t) {
		double value = 0;
		for (Option opt : getSelected()) {
			if (opt.getAcceptedTools().contains(t)) {
				value += 1;
			} else if (opt.getUnknown().contains(t)) {
				value += 0.5;
			}
		}
		return value / getSelected().size();
	}

}
