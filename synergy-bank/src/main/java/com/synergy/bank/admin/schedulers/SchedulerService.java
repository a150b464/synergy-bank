package com.synergy.bank.admin.schedulers;


import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.customer.service.BankJdbcService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;

/**
 * Scheduler for handling jobs
 */
@Service
public class SchedulerService {

	protected static Logger logger = Logger.getLogger("SchedulerService");

	
	 @Autowired
     @Qualifier("BankJdbcServiceImpl")
     private BankJdbcService bankJdbcService;
	 
	 @Autowired
     @Qualifier("BankEmailServiceImpl")
     private BankEmailService bankEmailService;
	
	
	/**
	 * You can opt for cron expression or fixedRate or fixedDelay
	 * <p>
	 * See Spring Framework 3 Reference:
	 * Chapter 25.5 Annotation Support for Scheduling and Asynchronous Execution
	 */
	//@Scheduled(fixedDelay=5000)
	//@Scheduled(fixedRate=5000)
	@Scheduled(cron="*/120 * * * * ?")
	public void doSchedule() {
		List<CustomerForm> customerForms=bankJdbcService.findCustomersByBirthDay();
        for(CustomerForm customerForm:customerForms) {
             bankEmailService.sendBirthdayEmails("nagen@synergisticit.com",customerForm.getEmail(),"Happy Birthday!","",customerForm.getFirstName());
           
        }
		
		System.out.println("Start date  = "+new Date());
		System.out.println("@Scheduled(cron=\"*60 * * * * ?\")");
		System.out.println("@Scheduled(cron=\"*60 * * * * ?\")");
		System.out.println("Ahahahahha welcome the spring scheduler");
		System.out.println("@Scheduled(cron=\"*60 * * * * ?\")");
		System.out.println("@Scheduled(cron=\"*60 * * * * ?\")");
	}
	
	
}
