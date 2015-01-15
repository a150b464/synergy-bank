package com.synergy.bank.soap.web.provider.fault;

public class GalleryFaultMessage {
	
	private String messageCode;
	private String dmessage;
	private String description;
	private String serverip;

	public String getMessageCode() {
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getDmessage() {
		return dmessage;
	}

	public void setDmessage(String dmessage) {
		this.dmessage = dmessage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getServerip() {
		return serverip;
	}

	public void setServerip(String serverip) {
		this.serverip = serverip;
	}

	@Override
	public String toString() {
		return "GalleryFaultMessage [messageCode=" + messageCode
				+ ", dmessage=" + dmessage + ", description=" + description
				+ ", serverip=" + serverip + "]";
	}
}
