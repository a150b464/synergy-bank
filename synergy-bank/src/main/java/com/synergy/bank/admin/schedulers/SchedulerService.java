package com.synergy.bank.admin.schedulers;


import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * Scheduler for handling jobs
 */
@Service
public class SchedulerService {

	protected static Logger logger = Logger.getLogger("SchedulerService");

	/**
	 * You can opt for cron expression or fixedRate or fixedDelay
	 * <p>
	 * See Spring Framework 3 Reference:
	 * Chapter 25.5 Annotation Support for Scheduling and Asynchronous Execution
	 */
	//@Scheduled(fixedDelay=5000)
	//@Scheduled(fixedRate=5000)
	@Scheduled(cron="*/60 * * * * ?")
	public void doSchedule() {
		System.out.println("Start date  = "+new Date());
		System.out.println("@Scheduled(cron=\"*60 * * * * ?\")");
		System.out.println("@Scheduled(cron=\"*60 * * * * ?\")");
		System.out.println("Ahahahahha welcome the spring scheduler");
		System.out.println("@Scheduled(cron=\"*60 * * * * ?\")");
		System.out.println("@Scheduled(cron=\"*60 * * * * ?\")");
	}
	
	
}
