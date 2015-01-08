package com.synergy.bank.common.service.impl;

import com.synergy.bank.common.dao.form.GallaryPhotoForm;

public interface GallaryService {
	public byte[] findImageById(int imageid);

	public GallaryPhotoForm findGalleryById(int imageid);

	public String updateGallery(GallaryPhotoForm form);

	public String findImageFilePathById(int imageid);

	public String deleteImageById(int imageid);
}
