/**
 * 
 * @author Swapnil
 */

package com.synergy.bank.soap.web.provider;

import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

@WebService
public class BankSoapServiceProviderForCustomerDetails {

/*	@Autowired
	@Qualifier("BankCustomerHibernateDaoImpl")
	private BankCustomerHibernateDao bankCustomerDao;
*/
	/*@Autowired
	@Qualifier("BankJdbcDaoImpl")
	private BankJdbcDao bankJdbcDao;
*/
	
	
	/*@Autowired
	@Qualifier("BankCustomerServiceImpl")
	private BankCustomerService bankCustomerService;*/
	
	
	//public List<CustomerForm> cDetails;

	public List<CustomerForm> displayCustomers() {

		System.out.println("-------Entered in the webService class------");
		
		

/*		List<CustomerForm> customerEntityList = bankCustomerService.findCustomers();
*/
		
	//    BankCustomerService bankCustomerService=new BankCustomerService();

		//List<CustomerForm> customerDetailList = bankCustomerService.getCustomerListForRowNumbers(0,5);

		
		/*
		 * List<CustomerForm> customerFormList = new
		 * ArrayList<CustomerForm>(customerEntityList.size());
		 * 
		 * CustomerForm customerForm = new CustomerForm(); for(int
		 * i=0;i<customerEntityList.size();i++) {
		 * 
		 * BeanUtils.copyProperties(customerEntityList.get(i),customerForm);
		 * customerFormList.add(customerForm);
		 * 
		 * }
		 */

	/*	System.out.println("Printing from WebService Class "
				+ customerDetailList);
	*/	return null;
	}
}
