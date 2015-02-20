package com.synergy.bank.customer.web.controller;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.synergy.bank.common.service.BankEmailService;
import com.synergy.bank.customer.service.BankCustomerService;
import com.synergy.bank.customer.service.BankPayeeService;
import com.synergy.bank.customer.web.controller.form.PayeeDetailsForm;

@RunWith(SpringJUnit4ClassRunner.class)
//This should scan only controller package
@ContextConfiguration({ "classpath*:test-ganesha-web-app-context.xml" })
public class BankPayeeCustomerControllerTest {

	@Mock
	private BankPayeeService bankPayeeService;

	@Mock
	private BankCustomerService bankCustomerService;

	@Mock
	private BankEmailService bankEmailService;

	@InjectMocks
	private BankPayeeCustomerController bankPayeeCustomerController;
	
	private MockMvc mockMvc;
	
	@Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(bankPayeeCustomerController).build();
    }
	

	@Test
	public void testFindPayeeByEmail() {
		/*model.addAttribute("EditPayeeForm", bankPayeeService.findAllPayeesByEmail(email));
		return NavigationConstant.CUSTOMER_PAGE + NavigationConstant.EDIT_PAYEE_TABLE;*/
		PayeeDetailsForm detailsForm=new PayeeDetailsForm();
		detailsForm.setDoe(new Date());
		detailsForm.setEmail("nk@gmail.com");
		detailsForm.setMobile("030303");
		detailsForm.setPayeeAccountNo("304040404");
		detailsForm.setPayeeName("Nagendra Yadav");
		detailsForm.setPayeeNickName("Nagen");
		detailsForm.setSno(100);
		detailsForm.setStatus("approved");
		detailsForm.setUserid("8889999");
		
		//here we are stubbing for bankPayeeService for method findAllPayeesByEmail
		when(bankPayeeService.findAllPayeesByEmail("nk@gmail.com")).thenReturn(detailsForm);
		
        try {
			mockMvc.perform(get("/editPayeeByEmail").contentType(MediaType.APPLICATION_FORM_URLENCODED).
			param("email", "nk@gmail.com")).
			andExpect(status().isOk())
			/*.andExpect(view().name("/WEB-INF/jsp/customer/editPayeeTable.jsp"))
			.andExpect(forwardedUrl("/WEB-INF/jsp/customer/editPayeeTable.jsp"))*/
			.andExpect(model().attribute("EditPayeeForm", hasProperty("email", is("nk@gmail.com"))))
			.andExpect(model().attribute("EditPayeeForm", hasProperty("mobile", is("030303"))))
			.andExpect(model().attribute("EditPayeeForm", hasProperty("payeeName", is("Nagendra Yadav"))))
			.andExpect(model().attribute("EditPayeeForm", hasProperty("payeeNickName", is("Nagen"))))
			.andExpect(model().attribute("EditPayeeForm", hasProperty("status", is("approved"))))
			.andExpect(model().attribute("EditPayeeForm", hasProperty("userid", is("8889999"))))
			.andExpect(model().attribute("EditPayeeForm", hasProperty("payeeAccountNo", is("304040404"))));
		} catch (Exception e) {
			e.printStackTrace();
		}
        
	}

	@Ignore
	public void testCheckPayeeAccountNo() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testAddpayeeModelHttpSession() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testFindAllPayees() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testFindPhotoByEmail() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testFindPhotoByUsedId() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testEditPayeeByEmail() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testUpdatePayee() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testAddpayeePayeeDetailsFormModelHttpSession() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testConfirmpayee() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testIsPayeeExists() {
		fail("Not yet implemented");
	}

	@Ignore
	public void testSelectPayee() {
		fail("Not yet implemented");
	}

}
