package com.synergy.bank.customer.web.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx = 
				   new AnnotationConfigApplicationContext(Test.class,Test.class);
		// TODO Auto-generated method stub
		 try {
         double x=-1 / 0.0;
         System.out.println(x);
		 }catch(Exception e){
			 e.printStackTrace();
		 }
	}

}
