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

import com.synergy.bank.customer.dao.entity.CustomerRegistrationQuestionsEntity;
import com.synergy.bank.customer.dao.impl.BankCustomerDaoImpl;
import com.synergy.bank.customer.dao.impl.CustomerRegistrationQuestionsDaoImpl;
import com.synergy.bank.customer.web.controller.form.CustomerRegistrationQuestionsForm;


/**
 * @author nagendra.yadav
 *  This is junit for service layer
 *  Here we have mocked DAO Layer using mockito mocking framework
 *  
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerRegistrationQuestionsServiceImplTest {
	
	@Mock
	private CustomerRegistrationQuestionsDaoImpl customerRegistrationQuestionsDao;
	
	@Mock
	private BankCustomerDaoImpl bankCustomerDao;
	
	private CustomerRegistrationQuestionsServiceImpl customerRegistrationQuestionsServiceImpl;
	
	@Before
	public void init() {
		customerRegistrationQuestionsServiceImpl=new CustomerRegistrationQuestionsServiceImpl();
		//Here in service layer we are setting mock  dao layer. means we call any method of service
		//layer here it will call dummy dao layer method.
		customerRegistrationQuestionsServiceImpl.setBankCustomerDao(bankCustomerDao);
		customerRegistrationQuestionsServiceImpl.setCustomerRegistrationQuestionsDao(customerRegistrationQuestionsDao);
		
		//stubing
		//mocking behavior
		//customerRegistrationQuestionsDao
		CustomerRegistrationQuestionsEntity custForm1=new CustomerRegistrationQuestionsEntity();
		
		custForm1.setCustomerId("E040404");
		custForm1.setAnswer("Cricket");
		custForm1.setDescription("What is your fevorite game?");
		custForm1.setQuestionId("Q001");
		custForm1.setSerialNumber(1);
		
		CustomerRegistrationQuestionsEntity custForm2=new CustomerRegistrationQuestionsEntity();
		custForm2.setCustomerId("E040404");
		custForm2.setAnswer("padera");
		custForm2.setDescription("What is your mother's maiden name?");
		custForm2.setQuestionId("Q002");
		custForm2.setSerialNumber(2);
		
		CustomerRegistrationQuestionsEntity custForm3=new CustomerRegistrationQuestionsEntity();
		custForm3.setCustomerId("E040404");
		custForm3.setAnswer("pizza");
		custForm3.setDescription("What is your fevorite food");
		custForm3.setQuestionId("Q003");
		custForm3.setSerialNumber(3);
		
		List<CustomerRegistrationQuestionsEntity> customerRegistrationQuestions=new ArrayList<CustomerRegistrationQuestionsEntity>();
		customerRegistrationQuestions.add(custForm1);
		customerRegistrationQuestions.add(custForm2);
		customerRegistrationQuestions.add(custForm3);
		
		//customerRegistrationQuestionsDao
		///Stubbing 
		when(customerRegistrationQuestionsDao.findCustomerQuestionsAndAnswerByCustomerId("E040404")).thenReturn(customerRegistrationQuestions);
	
	}	
	

	@Test
	public void testAddCustomerQuestionsAndAnswerByCustomerId() {
	}

	@Test
	public void testFindCustomerQuestionsAndAnswerByCustomerId() {
		List<CustomerRegistrationQuestionsForm> customerRegistrationQuestionsForms=customerRegistrationQuestionsServiceImpl.findCustomerQuestionsAndAnswerByCustomerId("E040404");
		assertNotNull(customerRegistrationQuestionsForms);
		assertEquals(3, customerRegistrationQuestionsForms.size());
		CustomerRegistrationQuestionsForm custForm=customerRegistrationQuestionsForms.get(0);
		assertEquals("Cricket",custForm.getAnswer());
		assertEquals("Q001",custForm.getQuestionId());
		
	}

}
