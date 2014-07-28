package com.synergy.bank.common.service.impl;

import com.synergy.bank.common.service.BankEmailService;

/**
 * 
 * @author xxxxxxxxxxx
 *
 */
public class EmailSenderThread extends Thread {
	
	private  BankEmailService bankEmailService;
	private String toEMail;
	private String message;
	private String subject;
	
	public EmailSenderThread(BankEmailService bankEmailService, String toEMail,
			String message,String subject) {
		this.bankEmailService = bankEmailService;
		this.toEMail = toEMail;
		this.message = message;
		this.subject=subject;
	}

	public EmailSenderThread(String tname){
	  super(tname);
	}
	
	public void run() {
		try {
			
			bankEmailService.sendMail("nagen@gmail.com",toEMail,subject,message);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}