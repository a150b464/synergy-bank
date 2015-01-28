package com.synergy.bank.rest.web.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.xml.sax.InputSource;


public class MiniStatementJAXBParser {
	
	public static  List<CustomerTransactionsForm> parseXMLData(String xmlData){
		//I am going to use JAXB = Java API for XML Binding
		////////////////////////////JAXB = JDK 1.6
		StringReader inStream = new StringReader(xmlData);
		InputSource source = new InputSource(inStream);
		CustomerTransactionsWrapper customerTransactionsWrapper=null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(CustomerTransactionsWrapper.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			customerTransactionsWrapper = (CustomerTransactionsWrapper) jaxbUnmarshaller.unmarshal(source);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		/////////////////////////////////////////////////
		return customerTransactionsWrapper.getCustomerTransactions();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// This is url-pattern for servlet which will generate XML as a response
		String turl = "http://localhost:8080/synergy-bank/rest/ministatement?accountNumber=1000000002";
		try {
			URL url = new URL(turl);
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(url.openStream()));
			
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line);
			}
			System.out.println(stringBuilder.toString()); //XML data by reading from response and converted into String as XML
			List<CustomerTransactionsForm> customerTransactionsWrapper=parseXMLData(stringBuilder.toString());
			for(CustomerTransactionsForm customerTransactionsForm:customerTransactionsWrapper){
				System.out.println(customerTransactionsForm);
			}
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}

