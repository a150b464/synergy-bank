package com.synergy.bank.admin.dao;

import java.util.List;

import com.synergy.bank.admin.dao.entity.PortfolioEntity;

public interface PortfolioDao {
  public List<PortfolioEntity> findAllPortfolios();
}
