package com.synergy.bank.common.dao;

import java.util.List;

import com.synergy.bank.common.dao.entity.GallaryPhotoEntity;


public interface GallaryDao {
	public byte[] findImageById(int imageid);

	public GallaryPhotoEntity findGalleryById(int imageid);

	public String updateGallery(GallaryPhotoEntity gallaryPhotoEntity);

	public String findImageFilePathById(int imageid);

	public String deleteImageById(int imageid);

	public List<GallaryPhotoEntity> findGalleryList();	
}
