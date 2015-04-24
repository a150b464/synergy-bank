package com.synergy.bank.admin.web.controller.form;

public class PortfolioForm {

	private int sno;
	private String imageUrl;
	private String thumbUrl;
	private String imageTitle;
	private String description;
	private byte[] image;
	private byte[] timage;

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public byte[] getTimage() {
		return timage;
	}

	public void setTimage(byte[] timage) {
		this.timage = timage;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getThumbUrl() {
		return thumbUrl;
	}

	public void setThumbUrl(String thumbUrl) {
		this.thumbUrl = thumbUrl;
	}

	public String getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(String imageTitle) {
		this.imageTitle = imageTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "PortfolioForm [sno=" + sno + ", imageUrl=" + imageUrl
				+ ", thumbUrl=" + thumbUrl + ", imageTitle=" + imageTitle
				+ ", description=" + description + "]";
	}

}
