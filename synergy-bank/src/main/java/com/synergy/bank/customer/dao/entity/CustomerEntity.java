package com.synergy.bank.customer.dao.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "customer_details_tbl")
public class CustomerEntity implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5144983715692295555L;
	private String userId;
	private String password;
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
	private String occupationType;
	private String education;
	private String grossAnualIncome;
	private String sourceOfFunds;
	private String role;
	private Date doe;
	private Date dom;
	private byte[] photo;
	private String description;

	private List<CustomerRegistrationQuestionsEntity> questionList = new ArrayList<CustomerRegistrationQuestionsEntity>();





	@Column(name = "photo", columnDefinition = "longblob")
	public byte[] getPhoto() {
		return photo;
	}

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "customer_and_registration_questions_tbl", joinColumns = { @JoinColumn(name = "customerId") }, inverseJoinColumns = { @JoinColumn(name = "serialNumber") })
	public List<CustomerRegistrationQuestionsEntity> getQuestionList() {
		return questionList;
	}
	
	public void setQuestionList(
			List<CustomerRegistrationQuestionsEntity> questionList) {
		this.questionList = questionList;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
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

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
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

	@Id
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Date getDoe() {
		return doe;
	}

	public void setDoe(Date doe) {
		this.doe = doe;
	}

	public Date getDom() {
		return dom;
	}

	public void setDom(Date dom) {
		this.dom = dom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "CustomerEntity [userId=" + userId + ", password=" + password
				+ ", salutation=" + salutation + ", gender=" + gender
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", maritalStatus=" + maritalStatus
				+ ", dob=" + dob + ", category=" + category
				+ ", motherMaidenName=" + motherMaidenName + ", fatherName="
				+ fatherName + ", email=" + email + ", mobile=" + mobile
				+ ", ssn=" + ssn + ", occupation=" + occupation
				+ ", occupationType=" + occupationType + ", education="
				+ education + ", grossAnualIncome=" + grossAnualIncome
				+ ", sourceOfFunds=" + sourceOfFunds + ", role=" + role
				+ ", doe=" + doe + ", dom=" + dom + ", photo="
				+ Arrays.toString(photo) + ", description=" + description
				+ ", meetings=" + questionList + "]";
	}
}
