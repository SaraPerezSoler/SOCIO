package answers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import answers.QuestionAnswer.RelevanceLevel;
import recommenderQuestionnaire.Option;
import recommenderQuestionnaire.Question;
import recommenderQuestionnaire.Tool;

public class UserResponse {
	
	private long id;
	private List<QuestionAnswer> answers = new ArrayList<QuestionAnswer>();
	private Map<Tool, Double> raitings = null;
	private List<Tool> allTools;
	
	public UserResponse(long id, List<Tool> allTools) {
		super();
		this.id = id;
		this.allTools = allTools;
	}
	
	public void addQuestionAnswer (Question question, List<Option> selected, RelevanceLevel relevanceLevel) {
		answers.add(new QuestionAnswer(question, selected, relevanceLevel));
	}
	public void changeRelevance(Question q, String value) {
		for (QuestionAnswer ans: answers) {
			if (ans.getQuestion().equals(q)) {
				ans.setRelevanceLevel(RelevanceLevel.getRelevanceLevelByText(value));
				break;
			}
		}
	}
	public long getId() {
		return id;
	}
	
	public Map<Tool, Double> getToolRanking() {
		for (Tool t: allTools) {
			double raiting = 0; 
			int totalQuestions = answers.size();
			for (QuestionAnswer ans: answers) {
				double ansRaiting = ans.getRaiting(t);
				if (ans.getRelevanceLevel() == RelevanceLevel.NOT_RELEVANT) {
					totalQuestions--;
					continue;
				}else if (ans.getRelevanceLevel() ==  RelevanceLevel.CRITICAL_ALL || ans.getRelevanceLevel() == RelevanceLevel.CRITICAL) {
					if (ansRaiting != 1) {
						raiting = 0;
						break;
					}
				}else if (ans.getRelevanceLevel() == RelevanceLevel.CRITICAL_ONE) {
					if (ansRaiting <= 0.5) {
						raiting = 0;
						break;
					}
				}else if (ans.getRelevanceLevel() == RelevanceLevel.DOBLE) {
					ansRaiting = ansRaiting *2;
				}
				raiting += ansRaiting;
			}
			if (totalQuestions == 0) {
				this.raitings.put(t, 1.0);
			}else {
				this.raitings.put(t, raiting/totalQuestions);
			}
		}
		
		raitings = raitings
		        .entrySet()
		        .stream()
		        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
		        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
		                LinkedHashMap::new));
		return raitings;
	}
}
