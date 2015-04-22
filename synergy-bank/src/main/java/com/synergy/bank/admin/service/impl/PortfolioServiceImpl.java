package com.synergy.bank.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.synergy.bank.admin.dao.PortfolioDao;
import com.synergy.bank.admin.dao.entity.PortfolioEntity;
import com.synergy.bank.admin.service.PortfolioService;
import com.synergy.bank.admin.web.controller.form.PortfolioForm;

/**
 * 
 * @author nagendra.yadav
 *
 */
@Service("PortfolioServiceImpl")
@Scope("singleton")
public class PortfolioServiceImpl implements PortfolioService {

	@Autowired
	@Qualifier("PortfolioDaoImpl")
	private PortfolioDao portfolioDao;

	@Override
	public List<PortfolioForm> findAllPortfolios() {
		List<PortfolioEntity> portfolioEntitiesList = portfolioDao
				.findAllPortfolios();
		List<PortfolioForm> portfolioFormsList = new ArrayList<PortfolioForm>();
		for (PortfolioEntity portfolioEntity : portfolioEntitiesList) {
			PortfolioForm portfolioForm = new PortfolioForm();
			BeanUtils.copyProperties(portfolioEntity, portfolioForm);
			portfolioFormsList.add(portfolioForm);
		}
		return portfolioFormsList;
	}

}
