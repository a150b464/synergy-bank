package com.synergy.bank.customer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.common.dao.BankJdbcDao;
import com.synergy.bank.customer.dao.entity.CustomerEntity;
import com.synergy.bank.customer.service.BankJdbcService;
import com.synergy.bank.customer.web.controller.form.CustomerForm;


@Service("BankJdbcServiceImpl")
@Scope("singleton")
public class BankJdbcServiceImpl implements BankJdbcService{

	 @Autowired
     @Qualifier("BankJdbcDaoImpl")
     private BankJdbcDao bankJdbcDao;
 
     @Override
     public List<CustomerForm> findCustomersByBirthDay() {
          List<CustomerEntity> customerEntities=bankJdbcDao.findCustomersByBirthDay();
          List<CustomerForm> customerForms=new ArrayList<CustomerForm>();
          for(CustomerEntity customerEntity:customerEntities){
              CustomerForm customerForm=new CustomerForm();
              BeanUtils.copyProperties(customerEntity, customerForm);
              customerForms.add(customerForm);
          }
          return customerForms;
     }
}
