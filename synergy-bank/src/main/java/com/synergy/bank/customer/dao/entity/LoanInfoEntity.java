package com.synergy.bank.customer.dao.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_info_tbl")
public class LoanInfoEntity implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9141885337401316502L;
	private int id;
	private Integer checkAmount;
	private Integer repaymentTerm;
	private String trading;
	private String userid;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getCheckAmount() {
		return checkAmount;
	}
	public void setCheckAmount(Integer checkAmount) {
		this.checkAmount = checkAmount;
	}
	public Integer getRepaymentTerm() {
		return repaymentTerm;
	}
	public void setRepaymentTerm(Integer repaymentTerm) {
		this.repaymentTerm = repaymentTerm;
	}
	public String getTrading() {
		return trading;
	}
	public void setTrading(String trading) {
		this.trading = trading;
	}
	public String getUserid() {
		return userid;
	}
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	@Override
	public String toString() {
		return "LoanInfoEntity [id=" + id + ", checkAmount=" + checkAmount
				+ ", repaymentTerm=" + repaymentTerm + ", trading=" + trading
				+ ", userid=" + userid + "]";
	}
	
	
}
