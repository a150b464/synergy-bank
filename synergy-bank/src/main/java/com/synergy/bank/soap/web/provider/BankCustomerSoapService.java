package com.synergy.bank.soap.web.provider;

import com.synergy.bank.customer.web.controller.form.CustomerForm;
import com.synergy.bank.soap.web.provider.wrapper.CustomerDetails;

/**
 * 
 * @author nagendra.yadav
 *
 */
public interface BankCustomerSoapService {
   public CustomerDetails findBankCustomers();
   public CustomerForm findBankCustomerByUserId(String customerUserId);
}
