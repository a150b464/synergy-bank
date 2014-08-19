package com.synergy.bank.admin.controller.exception;

import org.apache.log4j.Logger;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.synergy.bank.admin.web.constant.NavigationConstantAdmin;
import com.synergy.bank.base.aop.logger.SynergyDaoLogger;

@ControllerAdvice
public class SynergyBankAdminExceptionHandler {
	
	Logger logger=Logger.getLogger(SynergyDaoLogger.class);
	
	@ExceptionHandler(BankAdminException.class)
	public String errorPage(BankAdminException adminException,Model model){
		logger.error(adminException.getCause());
		return NavigationConstantAdmin.ADMIN_PAGE+NavigationConstantAdmin.ADMIN_ERROR_PAGE ;
	}
	
	

	@ExceptionHandler(Exception.class)
	public String errorPage(Exception exception,Model model){
		logger.error(exception.getStackTrace());
		return NavigationConstantAdmin.ADMIN_PAGE+NavigationConstantAdmin.ADMIN_ERROR_PAGE ;
	}

}
