package com.synergy.bank.common.service;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface BankEmailService {

	public void sendMail(String from,String to,String subject,String body);
	public void sendMail(String from, String[] to, String subject, String body);

}
