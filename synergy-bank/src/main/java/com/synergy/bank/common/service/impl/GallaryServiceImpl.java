package com.synergy.bank.common.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.synergy.bank.common.dao.GallaryDao;

@Service("GallaryServiceImpl")
public class GallaryServiceImpl implements GallaryService{
	
	@Autowired
	@Qualifier("GallaryDaoImpl")
	private GallaryDao gallaryDao;

	@Override
	public byte[] findImageById(int imageid) {
		return gallaryDao.findImageById(imageid);
	}
	

}
