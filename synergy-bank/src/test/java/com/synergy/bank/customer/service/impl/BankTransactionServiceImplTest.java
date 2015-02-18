package com.synergy.bank.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import com.synergy.bank.customer.dao.entity.CustomerTransactionsEntity;
import com.synergy.bank.customer.dao.impl.BankTransactionDaoImpl;
import com.synergy.bank.customer.web.controller.form.CustomerTransactionsForm;


@RunWith(MockitoJUnitRunner.class)
public class BankTransactionServiceImplTest {

	@Mock
	private BankTransactionDaoImpl bankTransactionDaoImpl;
	
	private BankTransactionServiceImpl bankTransactionServiceImpl;
	
	@Before
	public void init() {
		bankTransactionServiceImpl = new BankTransactionServiceImpl();
		
		bankTransactionServiceImpl.setBankTransactionDao(bankTransactionDaoImpl);
		
		CustomerTransactionsEntity form = new CustomerTransactionsEntity();
		form.setAccountID("1000000004");
		form.setAmmount(1000);
		form.setCreditDr("CR");
		form.setDescription("Hi!!!");
		form.setTransactionId(123);
		
		CustomerTransactionsEntity form1 = new CustomerTransactionsEntity();
		form1.setAccountID("1000000005");
		form1.setAmmount(1234);
		form1.setCreditDr("DR");
		form1.setDescription("Hello!!!");
		form1.setTransactionId(456);
		
		List<CustomerTransactionsEntity> transaction = new ArrayList<CustomerTransactionsEntity>();
		transaction.add(form);
		transaction.add(form1);
		
		when(bankTransactionDaoImpl.findTransactionsByIDTest("1000000004")).thenReturn(transaction);
	}
	
	@Test
	public void testFindTransactions(){
		List<CustomerTransactionsForm> customerTransactionsForm = bankTransactionServiceImpl.findTransactionsByIDTest("1000000004");
		assertNotNull(customerTransactionsForm);
		assertEquals(2, customerTransactionsForm.size());
		CustomerTransactionsForm form = customerTransactionsForm.get(0);
		assertEquals("Hi!!!", form.getDescription());
		assertEquals(123, form.getTransactionId());
		
	}

}
