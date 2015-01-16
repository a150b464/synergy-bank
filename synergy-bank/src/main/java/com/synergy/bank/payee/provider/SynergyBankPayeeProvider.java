package com.synergy.bank.payee.provider;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.payee.ObjectFactory;
import com.synergy.bank.payee.PayeeVO;
import com.synergy.bank.payee.SynergyPayeeService;


@WebService(name="SynergyBankPayeeProvider", portName="SynergyBankPayeeProviderPort", serviceName="SynergyBankPayeeProviderService", targetNamespace="http://provider.payee.bank.synergy.com/", endpointInterface="com.synergy.bank.payee.SynergyPayeeService", wsdlLocation="/xsd/synergy-payee.wsdl")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    ObjectFactory.class
})
public class SynergyBankPayeeProvider implements SynergyPayeeService{

	@Override
	public String findPayees(PayeeVO payeeInput) {
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		BankPayeeService bankPayeeService = (BankPayeeService)applicationContext.getBean("BankPayeeServiceImpl");
		bankPayeeService.findPayees();
		return "Payee List exposed as Web Service!!!";
	}

}
