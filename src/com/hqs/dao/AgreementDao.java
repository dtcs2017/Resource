package com.hqs.dao;

import com.hqs.common.Page;
import com.hqs.model.Agreement;


public interface AgreementDao {
	public void add(Agreement agreement);
	public boolean delete(int id);
	public boolean update(Agreement agreement);
	public Agreement findById(int id);
	public Page<Agreement> queryPage(Page<Agreement> page);
}
