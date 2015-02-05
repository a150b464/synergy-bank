package com.synergy.bank.loan.dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

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

}
