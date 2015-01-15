package com.synergy.bank.email.provider;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.email.EMailSenderVO;
import com.synergy.bank.email.ObjectFactory;
import com.synergy.bank.email.SynergyEMailService;

//synergy-email.wsdl =>>>>>SynergyEMailService
//==name =portType
@WebService(name="SynergyEMailService",portName="SynergyEMailServicePort",serviceName="SynergyEMailServiceProvider",targetNamespace="http://www.bank.synergy.com/email/",endpointInterface="com.synergy.bank.email.SynergyEMailService",wsdlLocation="/xsd/synergy-email.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public class SynerBankEmailProvider implements SynergyEMailService{
	@Override
	public String sendEmail(
			EMailSenderVO pemailMessageInput) {
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		BankEmailService bankEmailService=(BankEmailService)applicationContext.getBean("BankEmailServiceImpl");
		String names[]=pemailMessageInput.getReceipients().toArray(new String[pemailMessageInput.getReceipients().size()]);
		bankEmailService.sendMail(pemailMessageInput.getSender(), names, pemailMessageInput.getSubject(), pemailMessageInput.getBody());
		//Here we have to write busines to send the email
		System.out.println("pemailMessageInput  = "+pemailMessageInput);
		return "Ahaha email is sent................";
	}

}
