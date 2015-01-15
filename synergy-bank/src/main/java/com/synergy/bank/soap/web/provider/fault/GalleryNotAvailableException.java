package com.synergy.bank.soap.web.provider.fault;

public class GalleryNotAvailableException extends Exception{
	
  //This pojo would be part of detail message	
  private GalleryFaultMessage galleryFaultMessage;
  
  public GalleryNotAvailableException(){}
	
  	/**
  	 * 
  	 * 
  	 * @param message = faultstring
  	 * 
  	 * detail
  	 * @param galleryFaultMessage
  	 * 
  	 */
	public GalleryNotAvailableException(String message, GalleryFaultMessage galleryFaultMessage){		
		super(message);
		this.galleryFaultMessage = galleryFaultMessage;
	}
	
	/**
	 * This method name must be  getFaultInfo
	 * @return
	 */
	public GalleryFaultMessage getFaultInfo(){
		return galleryFaultMessage;
	}
}
