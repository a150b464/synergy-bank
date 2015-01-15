package com.synergy.bank.soap.web.provider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.ContextLoader;

import com.sun.org.apache.bcel.internal.generic.DMUL;
import com.synergy.bank.admin.web.controller.form.GallaryPhotoForm;
import com.synergy.bank.common.service.impl.GallaryService;
import com.synergy.bank.soap.web.provider.fault.GalleryFaultMessage;
import com.synergy.bank.soap.web.provider.fault.GalleryNotAvailableException;
import com.synergy.bank.soap.web.provider.model.GallaryImageList;


//I want to publish this class as web service

@WebService
//Here Spring container is not managing the web service
public class BankGallerySoapWebService {

	//This below autowire can be done only when the class is managed by spring container
	/*@Autowired
	@Qualifier("GallaryServiceImpl")
	private GallaryService gallaryService;*/
	/*We can make the class as managed by spring container by using @Service after @WebService by adding another jar
	 * But here we are not using spring container and uses Metro container and hence we cant use @Service */
	
	/* To use the spring code inside metro container, first call the spring container inside metro container */
	

	public void sendMessage(String firstName,String lastName){
		System.out.println("firstName = "+firstName);
		System.out.println("lastName = "+lastName);
		
	}
	
	public GallaryImageList findGalleryImages() throws GalleryNotAvailableException {
		//fetching spring root web container........
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		GallaryService gallaryService=(GallaryService)applicationContext.getBean("GallaryServiceImpl");
		List<GallaryPhotoForm>  gallaryPhotoForms=gallaryService.findGalleryList();
		if(gallaryPhotoForms!=null && gallaryPhotoForms.size()==0){
			GalleryFaultMessage deMessage=new  GalleryFaultMessage();
			deMessage.setDescription("Soap fault.");
			deMessage.setDmessage("Gallary is not available in database , please contact to administrator.");
			deMessage.setMessageCode("N1000");
			deMessage.setServerip("http://192.168.10.7");
			GalleryNotAvailableException availableException=new GalleryNotAvailableException("Gallery is empty",deMessage);
		    throw availableException;
		}
		
		for(GallaryPhotoForm form:gallaryPhotoForms){
			String path=form.getPath();
			try {
		        BufferedImage originalImage = ImageIO.read(new File(path));
		        ByteArrayOutputStream baos = new ByteArrayOutputStream();
		        ImageIO.write( originalImage, "jpg", baos );
		        baos.flush();
		        byte[] image = baos.toByteArray();
		        form.setImage(image);
		        form.setPath("");
			}catch(Exception exception){
				exception.printStackTrace();
			}
		}
		
		//we should not return List type (gallaryPhotosForms)in web service hence push the list in a wrapper class
		GallaryImageList gallaryImageList=new GallaryImageList();
		gallaryImageList.setGallaryPhotoForms(gallaryPhotoForms);
		
	  	return gallaryImageList;
	  	
	}
}
