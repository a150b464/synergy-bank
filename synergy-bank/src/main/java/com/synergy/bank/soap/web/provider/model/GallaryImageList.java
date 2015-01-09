package com.synergy.bank.soap.web.provider.model;

import java.util.List;

import com.synergy.bank.admin.web.controller.form.GallaryPhotoForm;

/**
 * 
 * @author nagendra.yadav
 *
 */
public class GallaryImageList {
    
	private List<GallaryPhotoForm> gallaryPhotoForms;

	public List<GallaryPhotoForm> getGallaryPhotoForms() {
		return gallaryPhotoForms;
	}

	public void setGallaryPhotoForms(List<GallaryPhotoForm> gallaryPhotoForms) {
		this.gallaryPhotoForms = gallaryPhotoForms;
	}
	
	@Override
	public String toString() {
		return "GallaryImageList [gallaryPhotoForms=" + gallaryPhotoForms + "]";
	}

}
