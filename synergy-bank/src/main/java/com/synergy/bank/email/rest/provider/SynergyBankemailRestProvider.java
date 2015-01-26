package com.synergy.bank.email.rest.provider;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.email.EMailSenderVO;


@Controller
@Scope("request")
public class SynergyBankemailRestProvider {
	@Autowired
	@Qualifier("BankEmailServiceImpl")
	private BankEmailService bankEmailService;
	
	@RequestMapping(value = "sendEmail", method = RequestMethod.POST,produces = "application/xml")
	public  @ResponseBody String sendEmail(@RequestBody EMailSenderVO pemailMessageInput) {
		String names[]=pemailMessageInput.getReceipients().toArray(new String[pemailMessageInput.getReceipients().size()]);
		bankEmailService.sendMail(pemailMessageInput.getSender(), names, pemailMessageInput.getSubject(), pemailMessageInput.getBody());
		//Here we have to write business to send the email
		System.out.println("pemailMessageInput  = "+pemailMessageInput);
		return "Ahaha email is sent................";
	}

}


