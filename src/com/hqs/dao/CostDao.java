package com.hqs.dao;

import com.hqs.common.Page;
import com.hqs.model.Cost;


public interface CostDao {
	public void add(Cost cost);
	public boolean delete(int id);
	public boolean update(Cost cost);
	public Cost findById(int id);
	public Page<Cost> queryPage(Page<Cost> page);
}
