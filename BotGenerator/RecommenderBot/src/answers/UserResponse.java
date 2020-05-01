package answers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import answers.QuestionAnswer.RelevanceLevel;
import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.Question;
import recommenderQuestionnaire.Tool;

public class UserResponse {

	private long id;
	private Map<Question, QuestionAnswer> answers = new HashMap<>();
	private Map<Tool, Double> raitings = null;
	private List<Tool> allTools;

	public UserResponse(long id, List<Tool> allTools) {
		super();
		this.id = id;
		this.allTools = allTools;
	}

	public void addQuestionAnswer(Question question, List<Option> selected, RelevanceLevel relevanceLevel) {
		answers.put(question, new QuestionAnswer(question, selected, relevanceLevel));
	}

	public void changeRelevance(Question q, String value) {
		for (QuestionAnswer ans : answers.values()) {
			if (ans.getQuestion().equals(q)) {
				ans.setRelevanceLevel(RelevanceLevel.getRelevanceLevelByText(value));
				break;
			}
		}
	}

	public long getId() {
		return id;
	}

	public void calculateRanking() {
		
		raitings = new HashMap<Tool, Double>();
		for (Tool t : allTools) {
			double raiting = 0;
			int totalQuestions = answers.size();
			for (QuestionAnswer ans : answers.values()) {
				double ansRaiting = ans.getRaiting(t);
				if (ans.getRelevanceLevel() == RelevanceLevel.NOT_RELEVANT) {
					totalQuestions--;
					continue;
				} else if (ans.getRelevanceLevel() == RelevanceLevel.CRITICAL_ALL
						|| ans.getRelevanceLevel() == RelevanceLevel.CRITICAL) {
					if (ansRaiting != 1) {
						raiting = 0;
						break;
					}
				} else if (ans.getRelevanceLevel() == RelevanceLevel.CRITICAL_ONE) {
					if (ansRaiting <= 0.5) {
						raiting = 0;
						break;
					}
				} else if (ans.getRelevanceLevel() == RelevanceLevel.DOBLE) {
					ansRaiting = ansRaiting * 2;
					totalQuestions++;
				}
				raiting += ansRaiting;
			}
			if (totalQuestions == 0) {
				this.raitings.put(t, 1.0);
			} else {
				this.raitings.put(t, raiting / totalQuestions);
			}
		}

	}
	
	public Map<Tool, Double> getRanking(){
		return raitings;
	}

	public double getToolAnswerScore(Tool tool, QuestionAnswer ans) {

		double ansRaiting = ans.getRaiting(tool);
		if (ans.getRelevanceLevel() == RelevanceLevel.NOT_RELEVANT) {
			return -1;
		} else if (ans.getRelevanceLevel() == RelevanceLevel.CRITICAL_ALL
				|| ans.getRelevanceLevel() == RelevanceLevel.CRITICAL) {
			if (ansRaiting != 1) {
				return 0;
			}
		} else if (ans.getRelevanceLevel() == RelevanceLevel.CRITICAL_ONE) {
			if (ansRaiting <= 0.5) {
				return 0;
			}
		}
		return ansRaiting;
	}

	public QuestionAnswer getAnswer(Question question) {
		for (QuestionAnswer ans : answers.values()) {
			if (ans.getQuestion().equals(question)) {
				return ans;
			}
		}
		return null;
	}
}
