package com.synergy.bank.registration.provider;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.beans.BeanUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.email.ObjectFactory;
import com.synergy.bank.registration.RegistrationSenderRESVO;
import com.synergy.bank.registration.RegistrationSenderVO;
import com.synergy.bank.registration.SynergyRegistrationService;
import com.synergy.bank.rest.web.provider.wrapper.CustomerTransactionWrapper;
//00
//synergy-email.wsdl =>>>>>SynergyEMailService
//==name =portType
@WebService(name="SynergyRegistrationService",portName="SynergyRegistrationServicePort",serviceName="SynergyRegistrationServiceProvider",targetNamespace="http://www.bank.synergy.com/registration/",endpointInterface="com.synergy.bank.registration.SynergyRegistrationService",wsdlLocation="/xsd/synergy-registration.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public class SynergyBankRegistrationProvider implements SynergyRegistrationService{
	@Override
	public RegistrationSenderRESVO customerRegistration(
			RegistrationSenderVO pregistrationMessageInput) {
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		BankCustomerService bankCustomerService= (BankCustomerService)applicationContext.getBean("BankCustomerServiceImpl");
		CustomerForm customerForm=new CustomerForm();
		BeanUtils.copyProperties(pregistrationMessageInput, customerForm);
		bankCustomerService.addCustomer(customerForm);
		
		RegistrationSenderRESVO registrationSenderRESVO = new RegistrationSenderRESVO();
		registrationSenderRESVO.setFirstName(pregistrationMessageInput.getFirstName());
		registrationSenderRESVO.setLastName(pregistrationMessageInput.getLastName());
		registrationSenderRESVO.setUserID(pregistrationMessageInput.getUserID());
		registrationSenderRESVO.setMiddleName(pregistrationMessageInput.getMiddleName());
		
		
		//registrationSenderRESVO.toString();
		// it will not go to view resolver
	    return registrationSenderRESVO;
	}

}
	

	
	