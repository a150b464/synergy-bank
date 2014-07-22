package com.synergy.bank.customer.web.controller.form;

public class CustomerRegistrationQuestionsForm {

	private int serialNumber;
	private String questionId;
	private String description;
	private String customerId;
	private String answer;

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}

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

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "CustomerRegistrationQuestionsForm [serialNumber="
				+ serialNumber + ", questionId=" + questionId
				+ ", description=" + description + ", customerId=" + customerId
				+ ", answer=" + answer + "]";
	}

}
