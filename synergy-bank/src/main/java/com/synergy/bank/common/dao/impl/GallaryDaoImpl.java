package com.synergy.bank.common.dao.impl;

import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
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
	
	@Override
	public String findImageFilePathById(int imageid) {
		String path = super.getJdbcTemplate().queryForObject(CustomerQuery.FIND_IMAGE_FROM_FILE +imageid, 
															String.class);
		return path;
	}
	
	@Override
	public String deleteImageById(int imageid){
		int a = super.getJdbcTemplate().update(CustomerQuery.DELETE_FROM_IMAGE_GALLERY+imageid);
		String message = "Not Deleted";
		if(a > 0)
			message = "Deleted";
		return message;
	}
	

	@Override
	public GallaryPhotoEntity findGalleryById(int imageid) {
		GallaryPhotoEntity gallaryPhotoEntity = super.getJdbcTemplate().queryForObject(
				CustomerQuery.SELECT_FROM_IMAGE_GALARY +imageid, new BeanPropertyRowMapper<GallaryPhotoEntity>(
						GallaryPhotoEntity.class));
		return gallaryPhotoEntity;
	}
	
	@Override
	public List<GallaryPhotoEntity> findGalleryList() {
		List<GallaryPhotoEntity> gallaryPhotoEntityList = super.getJdbcTemplate().query(
				CustomerQuery.SELECT_FROM_IMAGE_GALARY_LIST, new BeanPropertyRowMapper<GallaryPhotoEntity>(
						GallaryPhotoEntity.class));
		return gallaryPhotoEntityList;
	}
	
	@Override
	public String updateGallery(GallaryPhotoEntity gallaryPhotoEntity) {
		// To insert a photo into the database we need to
		// create the LobHandler object and wrap it with default lob handler
		LobHandler lobHandler = new DefaultLobHandler();
		// Create a sqllobvalue object and pass the photo and lobhandler as
		// arguements
		SqlLobValue sqlLobValue = new SqlLobValue(gallaryPhotoEntity.getImage(),
				lobHandler);
		// Create a array of columnsType and pass the datatype for each column .
		// This is spring neccessity
		int[] columnsType = new int[] {Types.BLOB, Types.VARCHAR, Types.INTEGER};
		// We introduce a new coloumn photo in insert query
		if(gallaryPhotoEntity.getImage()!=null && gallaryPhotoEntity.getImage().length>0) {
			super.getJdbcTemplate().update("update image_galary_tbl set image=?,path=? where imageid=?",
						new Object[] { sqlLobValue,	gallaryPhotoEntity.getPath(),gallaryPhotoEntity.getImageid() }, columnsType);
		}
		else{
			columnsType = new int[] { Types.VARCHAR, Types.INTEGER };
			super.getJdbcTemplate().update("update image_galary_tbl set path=? where imageid=?",
					new Object[] { gallaryPhotoEntity.getPath(),gallaryPhotoEntity.getImageid() }, columnsType);
		}
		return "update";

	}
	
}
