package com.synergy.bank.soap.web.provider.fault;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class CustomerNotFoundException extends Exception {

	private SoapFaultMessage faultBean;
	
	public CustomerNotFoundException(){
	}
	
	/**
	 * @param message
	 * This is high level description about the soap fault
	 * @param faultBean
	 *  This is detail description about the soap fault
	 */
	public CustomerNotFoundException(String message,SoapFaultMessage faultBean){
		super(message);
		this.faultBean=faultBean;
	}
	
	//method name which return detail message must be getFaultInfo
	public SoapFaultMessage getFaultInfo(){
		return faultBean;
	}
	
}
