package com.synergy.bank.admin.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.synergy.bank.admin.service.PortfolioService;
import com.synergy.bank.admin.web.constant.NavigationConstantAdmin;
import com.synergy.bank.admin.web.controller.form.PortfolioForm;
import com.synergy.bank.admin.web.controller.form.SecurityQuestionsForm;
import com.synergy.bank.common.dao.entity.SecurityQuestion;

/**
 * 
 * @author nagendra.yadav
 *   
 */
@Controller
@Scope("request")
public class PortfolioController {

	@Autowired
	@Qualifier("PortfolioServiceImpl")
	PortfolioService portfolioService;
	
	
	@RequestMapping(value="addSecuirtyQuestions",method=RequestMethod.GET)
	public String addSecuirtyQuestions(Model model){
		//WEB-INF/jsp/admin/portfolio
		SecurityQuestionsForm securityQuestionsForm=new SecurityQuestionsForm();
		model.addAttribute("securityQuestionsForm", securityQuestionsForm);
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.SECURITY_QUESTION_PAGE;
	}
	
	@RequestMapping(value="addSecuirtyQuestions",method=RequestMethod.POST)
	public @ResponseBody String addSecuirtyQuestions(@RequestParam("questionId") String questionId,@RequestParam("description") String description){
		//WEB-INF/jsp/admin/portfolio
		System.out.println(questionId);
		System.out.println(description);
		return "done";
	} 
	@RequestMapping(value="addImagePortfolio",method=RequestMethod.GET)
	public String addImagePortfolioPage(Model model){
		//WEB-INF/jsp/admin/portfolio
		PortfolioForm portfolioForm=new PortfolioForm();
		model.addAttribute("portfolioForm", portfolioForm);
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.ADD_IMAGE_PORTFOLIO_PAGE;
	}
	
	@RequestMapping(value="portfolio",method=RequestMethod.GET)
	public String showPortfolioPage(Model model){
		List<PortfolioForm> portfolioFormsList=portfolioService.findAllPortfolios();
		model.addAttribute("tportfolioFormsList", portfolioFormsList);
		//WEB-INF/jsp/admin/portfolio
		return NavigationConstantAdmin.ADMIN_PAGE
				+ NavigationConstantAdmin.PORTFOLIO_PAGE;
	}
	

}
