package com.synergy.bank.admin.web.controller.form;

import java.util.Arrays;

public class GallaryPhotoForm {
   
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
