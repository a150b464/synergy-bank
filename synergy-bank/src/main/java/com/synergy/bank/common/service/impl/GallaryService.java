package com.synergy.bank.common.service.impl;

import java.util.List;

import com.synergy.bank.admin.web.controller.form.GallaryPhotoForm;
import com.synergy.bank.common.dao.entity.GallaryPhotoEntity;



public interface GallaryService {
	public byte[] findImageById(int imageid);

	public GallaryPhotoForm findGalleryById(int imageid);

	public String updateGallery(GallaryPhotoForm form);

	public String findImageFilePathById(int imageid);

	public String deleteImageById(int imageid);
	
	public List<GallaryPhotoForm> findGalleryList();	
}
