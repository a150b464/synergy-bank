package com.synergy.bank.common.dao.entity;

import java.util.Arrays;

public class GallaryPhotoEntity {
   
	private int imageid;
    private byte[] image;
    
	@Override
	public String toString() {
		return "GallaryPhotoEntity [imageid=" + imageid + ", image="
				+ Arrays.toString(image) + "]";
	}
	public int getImageid() {
		return imageid;
	}
	public void setImageid(int imageid) {
		this.imageid = imageid;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
    
    

}
