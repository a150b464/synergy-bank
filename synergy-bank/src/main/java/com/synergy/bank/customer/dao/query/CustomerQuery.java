package com.synergy.bank.customer.dao.query;

/**
 * 
 * @author nagendra.yadav
 * 
 */
public interface CustomerQuery {
	public static final String INSERT_CUSTOMER = "insert into customer_details_tbl(userId,password,salutation,gender,firstName,middleName,lastName,maritalStatus,dob,category,motherMaidenName,fatherName,email,mobile,ssn,occupation,occupationType,education,grossAnualIncome,sourceOfFunds,role,photo,doe,dom,description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String FIND_CUTOMER = "select * from customer_details_tbl";
	public static final String FIND_CUTOMER_USER_ID = "select * from customer_details_tbl where userid=";
	public static final String CHECK_PAYEE_ACC_DETAILS = "select * from payee_information_tbl where userid=";
	public static final String CHECK_PAYEE_USER_ID = "select * from payee_information_tbl where userid=";
	public static final String SHOW_PAYEE_LIST = "select * from payee_information_tbl where userid=";
	public static final String ADD_PAYEE = "insert into payee_information_tbl(sno,userid,payeeAccountNo,payeeName,payeeNickName,mobile,doe,email,status) values(?,?,?,?,?,?,?,?,?)";
	public static final String APPROVE_PAYEE_STATUS = "update payee_information_tbl set status='approved' where ";
	public static final String FIND_CUSTOMER_ACCOUNT_BY_ID = "select * from customer_account_info_tbl where userid=";
	public static final String VALIDATE_PAYEE = "select * from payee_information_tbl where ";
	public static final String FIND_PAYEE = "select * from payee_information_tbl where userid like ";
	public static final String FIND_ALL_PAYEES = "select * from payee_information_tbl where userid=";
	public static final String FIND_ALL_PAYEES_BY_EMAIL = "select * from payee_information_tbl where email=";
	public static final String FIND_ALL_PAYEES_LIST = "select * from payee_information_tbl";
	public static final String FIND_APPROVED_PAYEE_BY_USERID = "select * from payee_information_tbl where userid=? and status=?";
	public static final String SHOW_PART_PAYEELIST = null;
	public static final String FIND_TRANSACTION_BY_CUSTOMER_ACCOUNT_NUMBER = "select * from customer_transaction_tbl where customerAccountNumber =";
	public static final String FIND_IMAGE_FROM_GALARY_BY_ID = "select * from image_galary_tbl where imageid=";
	public static final String SELECT_FROM_IMAGE_GALARY_LIST = "select imageid,file_path as path from image_galary_tbl";
	public static final String DELETE_FROM_CUSTOMER_DETAILS_TBL = "delete from customer_details_tbl where userid=";
	public static final String FIND_IMAGE_FROM_PROJECT_FOLDER = "select path from image_galary_tbl where imageid=";
	public static final String SELECT_FROM_IMAGE_GALARY = "select * from image_galary_tbl where imageid=";
	public static final String FIND_IMAGE_FROM_FILE = "select file_path from image_galary_tbl where imageid=";
	public static final String DELETE_FROM_IMAGE_GALLERY = "delete from image_galary_tbl where imageid=";
	public static final String DELETE_FROM_PAYEE_INFO_TBL = "delete from payee_information_tbl where userid=";
	public static final String INSERT_CUSTOMER_TRANSACTION = "insert into customer_transaction_tbl (customerAccountNumber,customerAccountType,payeeAccountNumber,"
			+ "transactionAmount,transactionDate,transactionRemark,transactionPwd) values(?,?,?,?,?,?,?)";

	public static final String INSERT_CUSTOMER_TRANSACTIONS_HISTORY = "insert into customer_transactions_tbl (id,accountID,ammount,"
			+ "creditDr,description,transactionDate,transactionId) values(?,?,?,?,?,?,?)";
	public static final String INSERT_LOAN_FORM = "insert into loan_form_tbl(zipCode, purpose, purchase, jointCredit, permission, relation, preApprovedNo) values(?, ?, ?, ?, ?, ?, ?)";
	public static final String INSERT_LOAN_INFO_FORM = "insert into loan_info_tbl(checkAmount, repaymentTerm, trading) values(?, ?, ?)";
	public static final String INSERT_LOAN_APPLICATION_INFO_FORM = "insert into loan_application_info_tbl(firstName, middleName, lastName, ssn, dob, maritalStatus, type, state, number, expiration, address, city, resState, zipCode, county, ownOrRent, rent, occupation, employer, salary, amount, frequency, source, email, repeatEmail, homePhone, workPhone, cellPhone, contactTime) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
