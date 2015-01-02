package com.synergy.bank.customer.web.constant;

/**
 * 
 * @author nagendra.yadav
 * 
 * Enum constant to map the roles for
 * different users
 *
 */
public enum RoleContant {
	
  CUSTOMER("customer"),ADMIN("admin"),SUPERADMIN("sadmin"),GUEST("guest");
  
  private String role;
  
  private RoleContant(String role){
	  this.role=role;
  }
  
  public String getValue(){
	  return role;
  }
	

}
