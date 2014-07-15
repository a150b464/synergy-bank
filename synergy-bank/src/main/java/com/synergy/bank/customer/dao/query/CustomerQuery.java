package com.synergy.bank.customer.dao.query;

import java.util.Date;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface CustomerQuery {
 public static final String INSERT_CUSTOMER="insert into customer_details_tbl(userId,password,salutation,gender,firstName,middleName,lastName,maritalStatus,dob,category,motherMaidenName,fatherName,email,mobile,ssn,occupation,occupationType,education,grossAnualIncome,sourceOfFunds,role,photo,doe,dom,description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
 public static final String FIND_CUTOMER ="select * from customer_details_tbl";
 public static final String SHOW_PART_PAYEELIST ="select * from payee_information_tbl where userid=";
 public static final String SHOW_PAYEE_LIST="select * from payee_information_tbl where userid=";
 public static final String ADD_PAYEE="insert into payee_information_tbl(sno,userid,payeeAccountNo,payeeName,payeeNickName,mobile,doe,email,status) values(?,?,?,?,?,?,?,?,?)";
 public static final String APPROVE_PAYEE_STATUS="update payee_information_tbl set status='approved' where userid=";
}
