package com.synergy.bank.common.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.synergy.bank.common.dao.SecurityQuestionDao;
import com.synergy.bank.common.dao.entity.SecurityQuestionEntity;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(inheritLocations = true, locations = {"classpath*:test-synergy-bank-root-context.xml" })
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
public class SecurityQuestionDaoImplTest {
	
	@Autowired
	@Qualifier("SecurityQuestionDaoImpl")
	private SecurityQuestionDao securityQuestionDao;
	
	@BeforeClass
	static public void oneTime(){
		
	}
	
	@Before
	public void init(){
		System.out.println("_____________)))))))))))SSSSSSSSSSSS________");
	}

	@Test
	public void testSaveSecurityQuestions() {
		
		//assertEquals("ahahaha","ahahahass");
	}

	@Test
	public void testGetCustomerListForRowNumbers() {
		
	}

	@Test
	public void testGetRandomSecurityQuestionsNot() {
		List<SecurityQuestionEntity> questionEntities=securityQuestionDao.getRandomSecurityQuestions(4);
		assertNotNull(questionEntities);
	}
	
	@Test
	public void testGetRandomSecurityQuestionsSizeFour() {
		List<SecurityQuestionEntity> questionEntities=securityQuestionDao.getRandomSecurityQuestions(4);
		assertEquals(4, questionEntities.size());
	}

}
