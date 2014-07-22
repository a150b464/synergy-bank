package com.synergy.bank.customer.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_registration_questions_tbl")
public class CustomerRegistrationQuestionsEntity {

	private int serialNumber;
	private String questionId;
	private String description;
	private String customerId;
	private String answer;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
		return "CustomerRegistrationQuestionsEntity [serialNumber="
				+ serialNumber + ", questionId=" + questionId
				+ ", description=" + description + ", customerId=" + customerId
				+ ", answer=" + answer + "]";
	}

}
