package ar.uba.fi.model;

public class Answer {
	private Integer questionIndex;
	private Question question;
	private String selectedOptionValue;
	private String selectedOptionDescription;
	
	public Answer() {
	}
	
	public Answer(Integer questionIndex) {
		this.questionIndex = questionIndex;
	}

	public Integer getQuestionIndex() {
		return questionIndex;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public void setQuestionIndex(Integer questionIndex) {
		this.questionIndex = questionIndex;
	}

	public String getSelectedOptionValue() {
		return selectedOptionValue;
	}

	public void setSelectedOptionValue(String selectedOptionValue) {
		this.selectedOptionValue = selectedOptionValue;
	}

	public String getSelectedOptionDescription() {
		return selectedOptionDescription;
	}

	public void setSelectedOptionDescription(String selectedOptionDescription) {
		this.selectedOptionDescription = selectedOptionDescription;
	}

}
