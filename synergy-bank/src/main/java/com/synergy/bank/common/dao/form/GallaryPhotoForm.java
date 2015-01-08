package com.synergy.bank.common.dao.form;

import java.util.Arrays;

public class GallaryPhotoForm {
   
	private int imageid;
    private byte[] image;
    private String path;
    
	
	@Override
	public String toString() {
		return "GallaryPhotoEntity [imageid=" + imageid + ", image="
				+ Arrays.toString(image) + ", path=" + path + "]";
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
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
    
    

}
