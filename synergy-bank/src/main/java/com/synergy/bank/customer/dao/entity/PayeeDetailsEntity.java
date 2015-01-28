package com.synergy.bank.customer.dao.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="payee_information_tbl")
public class PayeeDetailsEntity {
	
	private int sno;
	private String userid;
	private String payeeAccountNo;
	private String payeeName;
	private String payeeNickName;
	private String mobile;
	private Date doe;
	private String email;
	private String status;
	
	@Column(length=40)
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Column(length=40)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	
	@Column(length=40)
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	@Column(length=40)
	public String getPayeeAccountNo() {
		return payeeAccountNo;
	}
	public void setPayeeAccountNo(String payeeAccountNo) {
		this.payeeAccountNo = payeeAccountNo;
	}
	
	@Column(length=40)
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	
	@Column(length=40)
	public String getPayeeNickName() {
		return payeeNickName;
	}
	public void setPayeeNickName(String payeeNickName) {
		this.payeeNickName = payeeNickName;
	}
	
	@Column(length=40)
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	
	public Date getDoe() {
		return doe;
	}
	public void setDoe(Date doe) {
		this.doe = doe;
	}
	
	
	@Override
	public String toString() {
		return "PayeeDetailsEntity [sno=" + sno + ", userid=" + userid
				+ ", payeeAccountNo=" + payeeAccountNo + ", payeeName="
				+ payeeName + ", payeeNickName=" + payeeNickName + ", mobile="
				+ mobile + ", doe=" + doe + ", email=" + email + ", status="
				+ status + "]";
	}
	
	
}
