package ar.uba.fi.model;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private String questionText;
	private String id;
	private String pageName;
	private List<Option> options = new ArrayList<Option>();

	public Question(String pageName, String id, String question, List<String> options) {
		this.pageName = pageName;
		this.questionText = question;
		this.id = id;
		this.addOptions(options);
	}
	
	private void addOptions(List<String> options) {
		for (int i = 0; i < options.size(); i++) {
			this.options.add(new Option(i, options.get(i)));
		}
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}
}
