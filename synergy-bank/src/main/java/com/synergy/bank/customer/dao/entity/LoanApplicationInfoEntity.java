package com.synergy.bank.customer.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_application_info_tbl")
public class LoanApplicationInfoEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8628147761267369261L;
		
	private int id;
	private String userid;
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	private Date dob;
	private String maritalStatus;
	private String type;
	private String state;
	private String number;
	private Date expiration;
	private String address;
	private String city;
	private String resState;
	private Integer zipCode;
	private String county;
	private String ownOrRent;
	private double rent;
	private String occupation;
	private String employer;
	private double salary;
	private double amount;
	private String frequency;
	private String source;
	private String email;
	private String repeatEmail;
	private String homePhone;
	private String workPhone;
	private String cellPhone;
	private String contactTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public Date getExpiration() {
		return expiration;
	}
	public void setExpiration(Date expiration) {
		this.expiration = expiration;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getResState() {
		return resState;
	}
	public void setResState(String resState) {
		this.resState = resState;
	}
	public Integer getZipCode() {
		return zipCode;
	}
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getOwnOrRent() {
		return ownOrRent;
	}
	public void setOwnOrRent(String ownOrRent) {
		this.ownOrRent = ownOrRent;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public String getEmployer() {
		return employer;
	}
	public void setEmployer(String employer) {
		this.employer = employer;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRepeatEmail() {
		return repeatEmail;
	}
	public void setRepeatEmail(String repeatEmail) {
		this.repeatEmail = repeatEmail;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public String getWorkPhone() {
		return workPhone;
	}
	public void setWorkPhone(String workPhone) {
		this.workPhone = workPhone;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getContactTime() {
		return contactTime;
	}
	public void setContactTime(String contactTime) {
		this.contactTime = contactTime;
	}
	
	@Override
	public String toString() {
		return "LoanApplicationInfoEntity [id=" + id + ", userid=" + userid
				+ ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", ssn=" + ssn + ", dob=" + dob
				+ ", maritalStatus=" + maritalStatus + ", type=" + type
				+ ", state=" + state + ", number=" + number + ", expiration="
				+ expiration + ", address=" + address + ", city=" + city
				+ ", resState=" + resState + ", zipCode=" + zipCode
				+ ", county=" + county + ", ownOrRent=" + ownOrRent + ", rent="
				+ rent + ", occupation=" + occupation + ", employer="
				+ employer + ", salary=" + salary + ", amount=" + amount
				+ ", frequency=" + frequency + ", source=" + source
				+ ", email=" + email + ", repeatEmail=" + repeatEmail
				+ ", homePhone=" + homePhone + ", workPhone=" + workPhone
				+ ", cellPhone=" + cellPhone + ", contactTime=" + contactTime
				+ "]";
	}
	
	

}
