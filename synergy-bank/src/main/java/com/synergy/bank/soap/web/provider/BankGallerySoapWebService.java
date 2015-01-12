package com.synergy.bank.soap.web.provider;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;
import javax.jws.WebService;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.ContextLoader;

import com.synergy.bank.admin.web.controller.form.GallaryPhotoForm;
import com.synergy.bank.common.service.impl.GallaryService;
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
	

	public GallaryImageList findGalleryImages() {
		//fetching spring root web container........
		ApplicationContext applicationContext=ContextLoader.getCurrentWebApplicationContext();
		GallaryService gallaryService=(GallaryService)applicationContext.getBean("GallaryServiceImpl");
		List<GallaryPhotoForm>  gallaryPhotoForms=gallaryService.findGalleryList();
		
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
