package com.synergy.bank.payee.dao.entity;

/**
 * @author this Tridib.Bandopadhyay
 * @since 9th July 2014
 * This is contract for customer for the bank.
 */
public class PayeeTransferAmountToCustomerEntity {

	private String payeeAccountNumber;
	private String payeeName;
	private String payeeNickName;
	private String payeeReAccountNumber;
	private String payeeAccountType;
	private String payeeEmailId;
	
	
	
	public String getPayeeReAccountNumber() {
		return payeeReAccountNumber;
	}
	public void setPayeeReAccountNumber(String payeeReAccountNumber) {
		this.payeeReAccountNumber = payeeReAccountNumber;
	}
	public String getPayeeAccountNumber() {
		return payeeAccountNumber;
	}
	public void setPayeeAccountNumber(String payeeAccountNumber) {
		this.payeeAccountNumber = payeeAccountNumber;
	}
	public String getPayeeName() {
		return payeeName;
	}
	public void setPayeeName(String payeeName) {
		this.payeeName = payeeName;
	}
	public String getPayeeNickName() {
		return payeeNickName;
	}
	public void setPayeeNickName(String payeeNickName) {
		this.payeeNickName = payeeNickName;
	}
	public String getPayeeEmailId() {
		return payeeEmailId;
	}
	public void setPayeeEmailId(String payeeEmailId) {
		this.payeeEmailId = payeeEmailId;
	}
	public String getPayeeAccountType() {
		return payeeAccountType;
	}
	public void setPayeeAccountType(String payeeAccountType) {
		this.payeeAccountType = payeeAccountType;
	}
	
	@Override
	public String toString() {
		return "PayeeTransferAmountToCustomerEntity [payeeAccountNumber="
				+ payeeAccountNumber + ", payeeName=" + payeeName
				+ ", payeeNickName=" + payeeNickName + ", payeeEmailId="
				+ payeeEmailId + ", payeeAccountType=" + payeeAccountType
				+ ", payee_phone=" + payeeReAccountNumber + "]";
	}
	
	
	
}

