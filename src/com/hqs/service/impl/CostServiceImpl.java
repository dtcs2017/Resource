package com.hqs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqs.common.Page;
import com.hqs.dao.CostDao;
import com.hqs.model.Cost;
import com.hqs.service.CostService;

@Service
public class CostServiceImpl implements CostService {
	@Autowired
	private CostDao costDao;

	@Override
	public void add(Cost cost) {
		costDao.add(cost);
	}

	@Override
	public boolean delete(int id) {
		return costDao.delete(id);
	}

	@Override
	public boolean update(Cost cost) {
		return costDao.update(cost);
	}
	public Cost findById(int id){
		return costDao.findById(id);
	}

	@Override
	public Page<Cost> queryPage(Page<Cost> page) {
		return costDao.queryPage(page);
	}

}
