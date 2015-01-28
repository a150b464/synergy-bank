package com.synergy.bank.rest.web.parser;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


/**
 * 
 * @author nagendra.yadav This is call back pojo which will hold the data using
 *         call back methods.
 * 
 */
public class SaxParserPojo extends DefaultHandler {

	private List<CustomerTransactionsForm> transactionList;

	public List<CustomerTransactionsForm> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<CustomerTransactionsForm> transactionList) {
		this.transactionList = transactionList;
	}

	private String transactionValue;

	// to maintain context
	private CustomerTransactionsForm transactionForm;

	public SaxParserPojo() {
		transactionList = new ArrayList<CustomerTransactionsForm>();
	}

	// Event Handlers
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// reset
		transactionValue = "";
		if (qName.equalsIgnoreCase("customerTransactions")) {
			// create a new instance of transactionForm
			transactionForm = new CustomerTransactionsForm();
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		transactionValue = new String(ch, start, length);
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if (qName.equalsIgnoreCase("customerTransactions")) {
			// add it to the list
			transactionList.add(transactionForm);
		} else if (qName.equalsIgnoreCase("accountID")) {
			transactionForm.setAccountID(transactionValue);
		} else if (qName.equalsIgnoreCase("ammount")) {
			transactionForm.setAmmount(Integer.parseInt(transactionValue));
		} else if (qName.equalsIgnoreCase("creditDr")) {
			transactionForm.setCreditDr(transactionValue);
		} else if (qName.equalsIgnoreCase("description")) {
			transactionForm.setDescription(transactionValue);
		} else if (qName.equalsIgnoreCase("id")) {
			transactionForm.setId(Long.parseLong(transactionValue));
		} else if (qName.equalsIgnoreCase("transactionId")) {
			transactionForm.setTransactionId(Long.parseLong(transactionValue));
		}
	}

}
