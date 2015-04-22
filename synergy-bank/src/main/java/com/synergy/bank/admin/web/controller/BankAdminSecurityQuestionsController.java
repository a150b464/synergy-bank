package com.synergy.bank.admin.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.synergy.bank.admin.web.constant.NavigationConstantAdmin;

@Controller
@Scope("request")
public class BankAdminSecurityQuestionsController {

	
	@RequestMapping(value="uploadSecurityQuestions",method=RequestMethod.GET)
	public String showUploadSecurityQuestions(Model model){

		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.UPLOAD_SECURITY_QUESTIONS_PAGE;
	}

}
