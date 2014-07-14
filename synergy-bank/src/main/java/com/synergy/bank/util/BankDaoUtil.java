package com.synergy.bank.util;

/**
 * 
 * @author naim
 *
 */

public class BankDaoUtil {
	
	
	/**
	 * 
	 * @param args
	 * @return String
	 * 
	 * Sample Input: String[] name = {"amit", "rahul", "surya"};
	 * Sample Output: 'amit','rahul','surya'
	 *  
	 */
	
	public String stringArrayToCommaSeperatedString(String[] args){
		
		StringBuilder sb = new StringBuilder();
		for (String n : args) { 
		    if (sb.length() > 0) sb.append(',');
		    sb.append("'").append(n).append("'");
		}
		
		return sb.toString();
	}

}
