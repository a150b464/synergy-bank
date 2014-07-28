package com.synergy.bank.soap.web.provider.fault;

public class CustomerNotFoundException extends Exception{
	
	private SoapFaultMessage faultBean;
	
	public CustomerNotFoundException(){}
	
	public CustomerNotFoundException(String message, SoapFaultMessage faultBean){		
		super(message);
		this.faultBean = faultBean;
	}
	
	public SoapFaultMessage getFaultInfo(){
		return faultBean;
	}

}
