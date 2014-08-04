package com.synergy.bank.loan.mdb.dto;

import java.io.Serializable;


/**
 * 
 * @author nagendra
 * This pojo is working as a dto
 * which will be used to transfer the data. 
 * 
 */
public class CarVO implements Serializable{
	
	private String carid;
	private String color;
	private String model;
	private String vendor;
	private String category;
	private String email;
	private String mobile;
	private double price;
	private byte[] image;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getCarid() {
		return carid;
	}

	public void setCarid(String carid) {
		this.carid = carid;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	@Override
	public String toString() {
		return "CarVO [carid=" + carid + ", color=" + color + ", model="
				+ model + ", vendor=" + vendor + ", category=" + category
				+ ", email=" + email + ", mobile=" + mobile + ", price="
				+ price + "]";
	}

}
