package com.synergy.bank.customer.dao.entity;

import java.util.Arrays;
import java.util.Date;

public class CreditEntity {

	private String salutation;
	private String gender;
	private String firstName;
	private String middleName;
	private String lastName;
	private String maritalStatus;
	private Date dob;
	private String category;
	private String motherMaidenName;
	private String fatherName;
	private String email;
	private String mobile;
	private String ssn;
	private String occupation;
	private String company;
	private String education;
	private String grossAnualIncome;
	private String sourceOfFunds;
	private String approve;
	
	public String getApprove() {
		return approve;
	}
	public void setApprove(String approve) {
		this.approve = approve;
	}
	private byte[] photo;
	private String userId;
	
	
	@Override
	public String toString() {
		return "CreditEntity [salutation=" + salutation + ", gender=" + gender
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", maritalStatus=" + maritalStatus
				+ ", dob=" + dob + ", category=" + category
				+ ", motherMaidenName=" + motherMaidenName + ", fatherName="
				+ fatherName + ", email=" + email + ", mobile=" + mobile
				+ ", ssn=" + ssn + ", occupation=" + occupation + ", company="
				+ company + ", education=" + education + ", grossAnualIncome="
				+ grossAnualIncome + ", sourceOfFunds=" + sourceOfFunds
				+ ", approve=" + approve + ", photo=" + Arrays.toString(photo)
				+ ", userId=" + userId + "]";
	}
	public String getSalutation() {
		return salutation;
	}
	public void setSalutation(String salutation) {
		this.salutation = salutation;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getMotherMaidenName() {
		return motherMaidenName;
	}
	public void setMotherMaidenName(String motherMaidenName) {
		this.motherMaidenName = motherMaidenName;
	}
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
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
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getGrossAnualIncome() {
		return grossAnualIncome;
	}
	public void setGrossAnualIncome(String grossAnualIncome) {
		this.grossAnualIncome = grossAnualIncome;
	}
	public String getSourceOfFunds() {
		return sourceOfFunds;
	}
	public void setSourceOfFunds(String sourceOfFunds) {
		this.sourceOfFunds = sourceOfFunds;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
}
