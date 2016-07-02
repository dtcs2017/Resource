package com.hqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqs.dao.AgreementcateDao;
import com.hqs.model.Agreementcate;
import com.hqs.service.AgreementcateService;

@Service
public class AgreementcateServiceImpl implements AgreementcateService {
	@Autowired
	private AgreementcateDao agreementcateDao;

	@Override
	public List<Agreementcate> findAll() {
		return agreementcateDao.findAll();
	}

}
