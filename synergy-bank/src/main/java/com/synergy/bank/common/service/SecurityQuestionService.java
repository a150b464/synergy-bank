package com.synergy.bank.common.service;

import java.util.List;

import com.synergy.bank.common.web.controller.form.SecurityQuestionForm;

public interface SecurityQuestionService {
	public String saveSecurityQuestions(List<SecurityQuestionForm> securityQuestionForms);

}
