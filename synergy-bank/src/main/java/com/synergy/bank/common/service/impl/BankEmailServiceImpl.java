package com.synergy.bank.common.service.impl;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.synergy.bank.common.service.BankEmailService;

@Service("BankEmailServiceImpl")
public class BankEmailServiceImpl implements BankEmailService {

	@Autowired
	@Qualifier("synergyMailSender")
	private JavaMailSender mailSender;

	@Override
	public void sendMail(String from, String to, String subject, String body) {
		    SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom(from);
	        message.setTo(to);
	        message.setSubject(subject);
	        message.setText(body);
	        mailSender.send(message);
	}

	@Override
	public void sendMail(String from, String[] to, String subject, String body) {
		SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
	}
	
	private String birthdayMessagePrefix="<table border=\"0\">"+
			     "	<tr>"+
			     "	<td>"+
			     "	  &nbsp;"+
			     "	</td>"+
			     "	</tr>"+
			     "	<tr>"+
			     "	<td>"+
			     "		<font style=\"color: blue;font-weight: bold;font-size:18px;\">Wish you very happy birthday "; 
	
	private String birthdayMessageSuffix="</font> "+
			     "	</td>"+
			     "	</tr>"+
			     "	<tr>"+
			     "	<td>"+
			     "	  <img src=\"cid:image\">"+
			     "	</td>"+
			     "</tr>"+
			     "	<tr>"+
			     "	<td>"+
			     "	 Regards,"+
			     "	</td>"+
			     "	</tr>"+
			     "	    	<tr>"+
			     "	<td>"+
			     "	 <font style=\"color: black;font-weight: bold;font-size:16px;\">AMS Admin</font>"+
			     "	</td>"+
			     "	</tr>"+
			     "	<tr>"+
			  "</table>";

	@Override
	public void sendBirthdayEmails(String from, String to, String subject,
			String body,String name) {
				MimeMessage message = mailSender.createMimeMessage();
				try {
					
					try {
						message.setFrom(new InternetAddress(from,"Aditya Sethi"));
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					message.setRecipients(Message.RecipientType.TO,
					            InternetAddress.parse(to));
					message.setSubject(subject);
					message.setSentDate(new Date());
					// This mail has 2 part, the BODY and the embedded image
			         MimeMultipart multipart = new MimeMultipart("related");
			      // first part (the html)
			         BodyPart messageBodyPart = new MimeBodyPart();
			         messageBodyPart.setContent(birthdayMessagePrefix+name+birthdayMessageSuffix, "text/html");
			         // add it
			         multipart.addBodyPart(messageBodyPart);
			         
			         messageBodyPart = new MimeBodyPart();
			         DataSource fds = new FileDataSource("C:/Users/Nani/Desktop/images/Happy_Birthday.jpg");
			         messageBodyPart.setDataHandler(new DataHandler(fds));
			         messageBodyPart.setHeader("Content-ID", "<image>");
			         multipart.addBodyPart(messageBodyPart);
			         
			        /* messageBodyPart = new MimeBodyPart();
			         DataSource photoDs = new FileDataSource("E:/test/nagendra.jpg");
			         messageBodyPart.setDataHandler(new DataHandler(photoDs));
			         messageBodyPart.setHeader("Content-ID", "<photo>");
			         // add image to the multipart
			         multipart.addBodyPart(messageBodyPart);*/

			         // put everything together
			         message.setContent(multipart);
			 
			            System.out.println("\n5th ===> Finally Send message..");
			            mailSender.send(message);	
				} catch (MessagingException e) {
					e.printStackTrace();
					//throw new MailParseException(e);
				}
		
		
		
		
	}
	
	

}
