package com.synergy.bank.common.dao;

import com.synergy.bank.common.dao.entity.LoginEntity;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface BankAuthDao {

  public LoginEntity authUser(String userid,String password);

}
