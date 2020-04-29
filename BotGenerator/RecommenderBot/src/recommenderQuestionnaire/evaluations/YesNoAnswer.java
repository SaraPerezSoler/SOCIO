package recommenderQuestionnaire.evaluations;

import java.util.ArrayList;
import java.util.List;

public interface YesNoAnswer {

	default List<String> getYes() {
		List<String> yes = new ArrayList<String>();
		yes.add("yes");
		return yes;
	}

	default List<String> getNo() {
		List<String> no = new ArrayList<String>();
		no.add("no");
		return no;
	}

}
