package com.synergy.bank.customer.dao.query;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface CustomerQuery {
	public static final String INSERT_CUSTOMER			 	= "insert into customer_details_tbl(userId,password,salutation,gender,firstName,middleName,lastName,maritalStatus,dob,category,motherMaidenName,fatherName,email,mobile,ssn,occupation,occupationType,education,grossAnualIncome,sourceOfFunds,role,photo,doe,dom,description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String FIND_CUTOMER 			 	= "select * from customer_details_tbl";
	public static final String FIND_CUTOMER_USER_ID 		= "select * from customer_details_tbl where userid=";
	public static final String CHECK_PAYEE_ACC_DETAILS 	 	= "select * from payee_information_tbl where userid=";
	public static final String CHECK_PAYEE_USER_ID 		 	= "select * from payee_information_tbl where userid=";
	public static final String SHOW_PAYEE_LIST 			 	= "select * from payee_information_tbl where userid=";
	public static final String ADD_PAYEE 				    = "insert into payee_information_tbl(sno,userid,payeeAccountNo,payeeName,payeeNickName,mobile,doe,email,status) values(?,?,?,?,?,?,?,?,?)";
	public static final String APPROVE_PAYEE_STATUS 		= "update payee_information_tbl set status='approved' where ";
	public static final String FIND_CUSTOMER_ACCOUNT_BY_ID  = "select * from customer_account_info_tbl where userid=";
	public static final String VALIDATE_PAYEE 				= "select * from payee_information_tbl where ";
	public static final String FIND_PAYEE					= "select * from payee_information_tbl where userid like ";
	public static final String FIND_APPROVED_PAYEE_BY_USERID= "select * from payee_information_tbl where userid=? and status=?";
	public static final String SHOW_PART_PAYEELIST 			= null;
	public static final String FIND_TRANSACTION_BY_CUSTOMER_ACCOUNT_NUMBER = "select * from customer_transaction_tbl where customerAccountNumber =";
	public static final String FIND_IMAGE_FROM_GALARY_BY_ID 		= "select * from image_galary_tbl where imageid=";
	public static final String DELETE_FROM_CUSTOMER_DETAILS_TBL = "delete from customer_details_tbl where userid=";
	public static final String FIND_IMAGE_FROM_PROJECT_FOLDER = "select path from image_galary_tbl where imageid=";
	public static final String SELECT_FROM_IMAGE_GALARY = "select * from image_galary_tbl where imageid=";
	public static final String FIND_IMAGE_FROM_FILE = "select file_path from image_galary_tbl where imageid=";
	public static final String DELETE_FROM_IMAGE_GALLERY = "delete from image_galary_tbl where imageid=";
}
