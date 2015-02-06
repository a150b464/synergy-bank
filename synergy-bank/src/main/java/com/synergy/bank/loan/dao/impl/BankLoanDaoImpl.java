package com.synergy.bank.loan.dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.customer.dao.entity.LoanApplicationInfoEntity;
import com.synergy.bank.customer.dao.entity.LoanEntity;
import com.synergy.bank.customer.dao.entity.LoanInfoEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;
import com.synergy.bank.loan.dao.BankLoanDao;

@Repository("BankLoanDaoImpl")
@Scope("singleton")
public class BankLoanDaoImpl extends JdbcDaoSupport implements BankLoanDao{

	@Autowired
	@Qualifier("bankDataSource")
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public String addLoanForm(LoanEntity loanEntity) {
		Object[] data = new Object[] { loanEntity.getZipCode(), loanEntity.getPurpose(), loanEntity.getPurchase(),
										loanEntity.getJointCredit(), loanEntity.getPermission(), loanEntity.getRelation(),
										loanEntity.getPreApprovedNo()};
		int dataArray[] = new int[] { Types.INTEGER, Types.VARCHAR,
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
				Types.INTEGER };
		super.getJdbcTemplate().update(CustomerQuery.INSERT_LOAN_FORM, data, dataArray);
		return "success";
	}

	@Override
	public String addLoanInfoForm(LoanInfoEntity loanInfoEntity) {
		Object[] data = new Object[] { loanInfoEntity.getCheckAmount(), loanInfoEntity.getRepaymentTerm(), loanInfoEntity.getTrading()};
		int dataArray[] = new int[] { Types.INTEGER, Types.INTEGER, Types.VARCHAR};
		super.getJdbcTemplate().update(CustomerQuery.INSERT_LOAN_INFO_FORM, data, dataArray);
		return "success";
	}

	@Override
	public String addApplicationInfoForm(LoanApplicationInfoEntity loanApplicationInfoEntity) {
		Object[] data = new Object[] {loanApplicationInfoEntity.getFirstName(), loanApplicationInfoEntity.getMiddleName(),
				loanApplicationInfoEntity.getLastName(), loanApplicationInfoEntity.getSsn(), loanApplicationInfoEntity.getDob(),
				loanApplicationInfoEntity.getMaritalStatus(), loanApplicationInfoEntity.getType(), loanApplicationInfoEntity.getState(),
				loanApplicationInfoEntity.getNumber(), loanApplicationInfoEntity.getExpiration(), loanApplicationInfoEntity.getAddress(),
				loanApplicationInfoEntity.getCity(), loanApplicationInfoEntity.getResState(), loanApplicationInfoEntity.getZipCode(), 
				loanApplicationInfoEntity.getCounty(), loanApplicationInfoEntity.getOwnOrRent(), loanApplicationInfoEntity.getRent(),
				loanApplicationInfoEntity.getOccupation(), loanApplicationInfoEntity.getEmployer(), loanApplicationInfoEntity.getSalary(),
				loanApplicationInfoEntity.getAmount(), loanApplicationInfoEntity.getFrequency(), loanApplicationInfoEntity.getSource(),
				loanApplicationInfoEntity.getEmail(), loanApplicationInfoEntity.getRepeatEmail(), loanApplicationInfoEntity.getHomePhone(),
				loanApplicationInfoEntity.getWorkPhone(), loanApplicationInfoEntity.getCellPhone(), loanApplicationInfoEntity.getContactTime()};
		int dataArray[] = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.VARCHAR, Types.VARCHAR,
				Types.DOUBLE, Types.VARCHAR, Types.VARCHAR,Types.DOUBLE, Types.DOUBLE, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
		super.getJdbcTemplate().update(CustomerQuery.INSERT_LOAN_APPLICATION_INFO_FORM, data, dataArray);
		return "success";
	}

}
