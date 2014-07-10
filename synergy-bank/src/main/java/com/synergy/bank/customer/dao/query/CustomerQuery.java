package com.synergy.bank.customer.dao.query;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface CustomerQuery {
 public static final String INSERT_CUSTOMER="insert into customer_details_tbl(userId,password,salutation,gender,firstName,middleName,lastName,maritalStatus,dob,category,motherMaidenName,fatherName,email,mobile,ssn,occupation,occupationType,education,grossAnualIncome,sourceOfFunds,role,photo,doe,dom,description) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
 public static final String FIND_CUTOMER ="select * from customer_details_tbl";

}
