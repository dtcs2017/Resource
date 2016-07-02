package com.hqs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqs.common.Page;
import com.hqs.dao.AdDao;
import com.hqs.model.Ad;
import com.hqs.service.AdService;

@Service
public class AdServiceImpl implements AdService {
	@Autowired
	private AdDao adDao;

	@Override
	public void add(Ad ad) {
		adDao.add(ad);
	}

	@Override
	public boolean delete(int id) {
		return adDao.delete(id);
	}

	@Override
	public boolean update(Ad ad) {
		return adDao.update(ad);
	}
	
	public Ad findById(int id){
		return adDao.findById(id);
	}

	@Override
	public Page<Ad> queryPage(Page<Ad> page) {
		return adDao.queryPage(page);
	}

}
