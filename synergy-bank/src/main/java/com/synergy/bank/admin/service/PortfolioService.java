package com.synergy.bank.admin.service;

import java.util.List;

import com.synergy.bank.admin.web.controller.form.PortfolioForm;

public interface PortfolioService {
	  public List<PortfolioForm> findAllPortfolios();
}
