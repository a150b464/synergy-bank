package com.synergy.bank.credit.dao.impl;

import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.core.support.SqlLobValue;
import org.springframework.jdbc.support.lob.DefaultLobHandler;
import org.springframework.jdbc.support.lob.LobHandler;
import org.springframework.stereotype.Repository;

import com.synergy.bank.credit.dao.BankCreditDao;
import com.synergy.bank.customer.dao.entity.CreditEntity;
import com.synergy.bank.customer.dao.query.CustomerQuery;

@Repository("BankCreditDaoImpl")
@Scope("singleton")
public class BankCreditDaoImpl extends JdbcDaoSupport implements BankCreditDao{

	@Autowired
	@Qualifier("bankDataSource")
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
	@Override
	public String addCreditForm(CreditEntity creditEntity) {
		
			LobHandler lobHandler = new DefaultLobHandler();
			SqlLobValue dphtoto = new SqlLobValue(creditEntity.getPhoto(), lobHandler);
			Object[] data = new Object[] { creditEntity.getUserId(),
					creditEntity.getOccupation(), creditEntity.getSalutation(),
					creditEntity.getGender(), creditEntity.getFirstName(),
					creditEntity.getMiddleName(), creditEntity.getLastName(),
					creditEntity.getMaritalStatus(), creditEntity.getDob(),
					creditEntity.getCategory(), creditEntity.getMotherMaidenName(),
					creditEntity.getFatherName(), creditEntity.getEmail(), creditEntity.getMobile(),
					creditEntity.getSsn(),
					creditEntity.getCompany(), creditEntity.getEducation(),
					creditEntity.getGrossAnualIncome(), creditEntity.getSourceOfFunds(), dphtoto,
					};

			int dataArra[] = new int[] { Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
					Types.VARCHAR,Types.BLOB
					 };
			super.getJdbcTemplate().update(CustomerQuery.INSERT_CREDITFORM, data,
					dataArra);
			//addCustomerLoginDetails(creditEntity);
			/*System.out.println("____AHAHAHA____");*/
			return "success";
		}

	
	
	
	
	
	
}
