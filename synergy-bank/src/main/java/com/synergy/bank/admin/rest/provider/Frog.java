package com.synergy.bank.admin.rest.provider;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Frog {
	private String name;
	private String color;
	private int age;
	private String category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Frog [name=" + name + ", color=" + color + ", age=" + age
				+ ", category=" + category + "]";
	}

}
