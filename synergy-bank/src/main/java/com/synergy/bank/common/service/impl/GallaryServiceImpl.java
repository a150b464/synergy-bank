package com.synergy.bank.common.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergy.bank.admin.web.controller.form.GallaryPhotoForm;
import com.synergy.bank.common.dao.GallaryDao;
import com.synergy.bank.common.dao.entity.GallaryPhotoEntity;

@Service("GallaryServiceImpl")
public class GallaryServiceImpl implements GallaryService{
	
	@Autowired
	@Qualifier("GallaryDaoImpl")
	private GallaryDao gallaryDao;

	@Override
	public byte[] findImageById(int imageid) {
		return gallaryDao.findImageById(imageid);
	}
	
	@Override
	public String findImageFilePathById(int imageid) {
		return gallaryDao.findImageFilePathById(imageid);
	}

	@Override
	public GallaryPhotoForm findGalleryById(int imageid) {
		GallaryPhotoForm gallaryPhotoForm=new GallaryPhotoForm();
		GallaryPhotoEntity gallaryPhotoEntity=gallaryDao.findGalleryById(imageid);
		BeanUtils.copyProperties(gallaryPhotoEntity, gallaryPhotoForm);
		return gallaryPhotoForm;
	}
	
	@Override
	public String updateGallery(GallaryPhotoForm form) {
		GallaryPhotoEntity gallaryPhotoEntity=new GallaryPhotoEntity();
		BeanUtils.copyProperties(form, gallaryPhotoEntity);
		gallaryDao.updateGallery(gallaryPhotoEntity);
		return "updated";
	}
	
	@Override
	public String deleteImageById(int imageid) {
		return gallaryDao.deleteImageById(imageid);
	}

	@Override
	public List<GallaryPhotoForm> findGalleryList() {
		List<GallaryPhotoEntity> gallaryPhotoEntitiesList=gallaryDao.findGalleryList();
		List<GallaryPhotoForm> gallaryPhotoList=new ArrayList<GallaryPhotoForm>();
		for(GallaryPhotoEntity entity:gallaryPhotoEntitiesList){
			GallaryPhotoForm gallaryPhotoForm=new GallaryPhotoForm();
			BeanUtils.copyProperties(entity, gallaryPhotoForm);
			gallaryPhotoList.add(gallaryPhotoForm);
		}
		return gallaryPhotoList;
	}
	

}
