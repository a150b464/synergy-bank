package com.synergy.bank.admin.web.controller.form;

public class SecurityQuestionsForm {

	private String questionId;
	private String description;

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SecurityQuestionsForm [questionId=" + questionId
				+ ", description=" + description + "]";
	}

}
