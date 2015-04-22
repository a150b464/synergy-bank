package com.synergy.bank.admin.dao.entity;

public class PortfolioEntity {

	private int sno;
	private String imageUrl;
	private String thumbUrl;
	private String imageTitle;
	private String description;

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
		return "PortfolioEntity [sno=" + sno + ", imageUrl=" + imageUrl
				+ ", thumbUrl=" + thumbUrl + ", imageTitle=" + imageTitle
				+ ", description=" + description + "]";
	}

}
