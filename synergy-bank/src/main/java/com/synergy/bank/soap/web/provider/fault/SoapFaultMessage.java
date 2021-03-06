package com.synergy.bank.soap.web.provider.fault;

public class SoapFaultMessage {
	
	private String faultCode;
	private String detailMessage;
	
	public String getFaultCode() {
		return faultCode;
	}
	public void setFaultCode(String faultCode) {
		this.faultCode = faultCode;
	}
	public String getDetailMessage() {
		return detailMessage;
	}
	public void setDetailMessage(String detailMessage) {
		this.detailMessage = detailMessage;
	}
	
	@Override
	public String toString() {
		return "SoapFaultMessage [faultCode=" + faultCode + ", detailMessage="
				+ detailMessage + "]";
	}
}
