package com.synergy.bank.rest.web.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;

public class MiniStatementSAXParser {
	
	public static  List<CustomerTransactionsForm> parseXMLData(String xmlData){
		//List<Customer> customers=new ArrayList<Customer>();
		//////////////////////////////////////////////////
		SaxParserPojo saxParserPojo = new SaxParserPojo();
		try {
			StringReader inStream = new StringReader(xmlData);
			InputSource source = new InputSource(inStream);
			// get a factory
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			//hey parser , please parse my data which is in source and populate it into  saxParserPojo
			sp.parse(source, saxParserPojo);
		}catch(Exception xe){
			xe.printStackTrace();
		}
		/////////////////////////////////////////////////
		return saxParserPojo.getTransactionList();
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
