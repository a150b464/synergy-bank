package com.synergy.bank.common.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.common.dao.GallaryDao;
import com.synergy.bank.common.dao.entity.GallaryPhotoEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;



@Repository("GallaryDaoImpl")
@Transactional(value="jdbctransactionManager",propagation=Propagation.REQUIRED)
public class GallaryDaoImpl extends JdbcDaoSupport implements GallaryDao {
	
	@Autowired
	@Qualifier("bankDataSource")
	public void setBankDataSource(DataSource dataSource){
		super.setDataSource(dataSource);
	}

	@Override
	public byte[] findImageById(int imageid) {
		GallaryPhotoEntity gallaryPhotoEntity = super
				.getJdbcTemplate()
				.queryForObject(
						CustomerQuery.FIND_IMAGE_FROM_GALARY_BY_ID +imageid,
						new BeanPropertyRowMapper<GallaryPhotoEntity>(
								GallaryPhotoEntity.class));
		return gallaryPhotoEntity.getImage();
	}
	
}
