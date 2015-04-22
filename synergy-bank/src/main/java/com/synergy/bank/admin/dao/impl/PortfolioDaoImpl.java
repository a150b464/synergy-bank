package com.synergy.bank.admin.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.synergy.bank.admin.dao.PortfolioDao;
import com.synergy.bank.admin.dao.entity.PortfolioEntity;
import com.synergy.bank.admin.dao.query.AdminQuery;

@Repository("PortfolioDaoImpl")
@Scope("singleton")
public class PortfolioDaoImpl extends JdbcDaoSupport implements PortfolioDao {
	
	@Autowired
	@Qualifier("bankDataSource")
	// here we are injecting bankDataSource inside JdbcDaoSupport super class
	public void setDataSourceInBank(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	public List<PortfolioEntity> findAllPortfolios() {
		List<PortfolioEntity>  portfolioEntitiesList = super.getJdbcTemplate().query(AdminQuery.FIND_ALL_PORTFOLIOS,
				new BeanPropertyRowMapper<PortfolioEntity>(PortfolioEntity.class));
		return portfolioEntitiesList;
	}

}
