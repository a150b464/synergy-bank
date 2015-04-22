package com.synergy.bank.common.service.impl;

import java.util.Collections;
import java.util.Date;
import java.util.List;


///it is immutable
//The object which 
final class Basket {

	final private String name;
	final private String color;
	final private Date dob;
	final private List<String> fruits;

	public Basket(String name, String color, Date dob, List<String> fruits) {
		this.name = name;
		this.color = color;
		this.dob = dob;
		List<String> ufruit=Collections.unmodifiableList(fruits);
		this.fruits = ufruit;
		
	}

	public String getName() {
		return name;
	}

	public String getColor() {
		return color;
	}

	public Date getDob() {
		//creating defensive copy
		Date c=new Date(dob.getTime());
		return c;
	}

	public List<String> getFruits() {
		return fruits;
	}

	@Override
	public String toString() {
		return "Basket [name=" + name + ", color=" + color + ", dob=" + dob
				+ ", fruits=" + fruits + "]";
	}
	
	public static void main(String[] args) {
		
	}

}