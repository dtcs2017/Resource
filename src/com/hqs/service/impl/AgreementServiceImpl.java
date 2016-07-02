package com.hqs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqs.common.Page;
import com.hqs.dao.AgreementDao;
import com.hqs.model.Agreement;
import com.hqs.service.AgreementService;

@Service
public class AgreementServiceImpl implements AgreementService {
	@Autowired
	AgreementDao agreementDao;

	@Override
	public void add(Agreement agreement) {
		agreementDao.add(agreement);
	}

	@Override
	public boolean delete(int id) {
		return agreementDao.delete(id);
	}

	@Override
	public boolean update(Agreement agreement) {
		return agreementDao.update(agreement);
	}
	
	public Agreement findById(int id){
		return agreementDao.findById(id);
	}

	@Override
	public Page<Agreement> queryPage(Page<Agreement> page) {
		return agreementDao.queryPage(page);
	}

}
