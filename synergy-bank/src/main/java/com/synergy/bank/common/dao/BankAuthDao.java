package com.synergy.bank.common.dao;

import com.synergy.bank.common.dao.entity.LoginEntity;
import com.synergy.bank.common.web.controller.form.LoginForm;
import com.synergy.bank.customer.dao.entity.CustomerEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface BankAuthDao {

  public LoginEntity authUser(String userid,String password);
  public LoginEntity findLoginDetailByUserName(String userid);
  public String addCustomerDetails(LoginEntity entity);
  
  

}
