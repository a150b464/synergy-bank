/**
 * 
 * @author Swapnil
 */

package com.synergy.bank.soap.web.provider;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

@WebService
@Component("BankSoapCustomerDetails")
public class BankSoapServiceProviderForCustomerDetails {

/*	@Autowired
	@Qualifier("BankCustomerHibernateDaoImpl")
	private BankCustomerHibernateDao bankCustomerDao;
*/
	/*@Autowired
	@Qualifier("BankJdbcDaoImpl")
	private BankJdbcDao bankJdbcDao;
*/
	
	
	@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;
	
	
	//public List<CustomerForm> cDetails;

	public List<CustomerForm> displayCustomers() {

		System.out.println("-------Entered in the webService class------");
		List<CustomerForm> customerEntityList = bankCustomerService.findCustomers();
		System.out.println("Printing from WebService Class "
				+ customerEntityList);
		return customerEntityList;
	}
}
