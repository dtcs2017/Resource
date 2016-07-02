package com.hqs.service;

import com.hqs.common.Page;
import com.hqs.model.Ad;

public interface AdService {
	public void add(Ad ad);
	public boolean delete(int id);
	public boolean update(Ad ad);
	public Ad findById(int id);
	public Page<Ad> queryPage(Page<Ad> page);
}
