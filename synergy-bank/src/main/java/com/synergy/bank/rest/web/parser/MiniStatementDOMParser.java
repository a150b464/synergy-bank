package com.synergy.bank.rest.web.parser;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class MiniStatementDOMParser {
	
	public static  List<CustomerTransactionsForm> parseXMLData(String xmlData){
		List<CustomerTransactionsForm> customerTransactionsWrapper=new ArrayList<CustomerTransactionsForm>();
		////////////////////////////////////////////////////
		try {
			StringReader inStream = new StringReader(xmlData);
			//because XML DOM parser understand InputSource
			InputSource isource = new InputSource(inStream);
			//alll these java api is from xml api which help us to parse XML data
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			Document doc = null;
			//Factory Design Pattern
			DocumentBuilder builder = factory.newDocumentBuilder();
			//Parsing the xml file
			doc = builder.parse(isource); //whole XML is loaded in memory as a document object tree
			
			//let us fetch data from doc object which is representation of XML Tree 
			XPathFactory xFactory = XPathFactory.newInstance();
			XPath xpath = xFactory.newXPath();
			String expression = "/customerTransactionsWrapper";
				// System.out.println("input = "+input);
			XPathExpression xPathExpression = xpath.compile(expression);
			
			//customerData as a Node
			//Node =customers
			Node obj = (Node) xPathExpression.evaluate(doc,
						XPathConstants.NODE);
			
			//obj is pointing to /customer starting root tag
			//Node -customer
			NodeList children = obj.getChildNodes();
			for (int index = 0; index < children.getLength(); index++) {
				//Getting a customer node
				Node userNode = children.item(index);
				
				//Iterating all the children of customer
				NodeList userNodeChild = userNode.getChildNodes();
				CustomerTransactionsForm customerTransactionsForm = new CustomerTransactionsForm();
				for (int p = 0; p < userNodeChild.getLength(); p++) {
					Node aNode = userNodeChild.item(p);
					if (aNode.getNodeType() == Node.ELEMENT_NODE) {
						 if (aNode.getNodeName().equals("accountID")) {
							 customerTransactionsForm.setAccountID(aNode.getTextContent());
						 }else  if (aNode.getNodeName().equals("ammount")) {
							 customerTransactionsForm.setAmmount(Integer.parseInt(aNode.getTextContent()));
						 }else  if (aNode.getNodeName().equals("creditDr")) {
							 customerTransactionsForm.setCreditDr(aNode.getTextContent());
						 }else  if (aNode.getNodeName().equals("description")) {
							 customerTransactionsForm.setDescription(aNode.getTextContent());
						 }else  if (aNode.getNodeName().equals("id")) {
							 customerTransactionsForm.setId(Long.parseLong(aNode.getTextContent()));
						 }else  if (aNode.getNodeName().equals("transactionId")) {
							 customerTransactionsForm.setTransactionId(Long.parseLong(aNode.getTextContent()));
						 }
					}
					
				}
			
				customerTransactionsWrapper.add(customerTransactionsForm);
			}	
		
		}catch(Exception ex){
			
		}
		//////////////////////////////////////////////////
		return customerTransactionsWrapper;
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

