package com.synergy.bank.registration.provider;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.registration.ObjectFactory;
import com.synergy.bank.registration.RegistrationInputVO;
import com.synergy.bank.registration.RegistrationOutputVO;
import com.synergy.bank.registration.SynergyRegistrationService;


//synergy-email.wsdl =>>>>>SynergyEMailService
//==name =portType
@WebService(name="SynergyRegistrationService",portName="SynergyRegistrationServicePort",serviceName="SynergyRegistrationServiceProvider",targetNamespace="http://www.bank.synergy.com/registration/",endpointInterface="com.synergy.bank.registration.SynergyRegistrationService",wsdlLocation="/xsd/synergy-registration.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public class SynergyBankRegistrationProvider implements SynergyRegistrationService{

	@Override
	public RegistrationOutputVO addCustomer(RegistrationInputVO registrationInput) {
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		BankCustomerService bankCustomerService=(BankCustomerService)applicationContext.getBean("BankCustomerServiceImpl");
		CustomerForm customerForm = new CustomerForm();
		BeanUtils.copyProperties(registrationInput, customerForm);
		String message = bankCustomerService.addCustomer(customerForm);
		String[] str = message.split(",");
		String userid = str[0];
		String password = str[1];
		RegistrationOutputVO registrationOutputVO = new RegistrationOutputVO();
		registrationOutputVO.setUserId(userid);
		registrationOutputVO.setPassword(password);
		registrationOutputVO.setEmail(registrationInput.getEmail());
		registrationOutputVO.setMobile(registrationInput.getMobile());
		registrationOutputVO.setDescription(registrationInput.getDescription());
		return registrationOutputVO;
	}
	
}
