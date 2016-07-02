package com.hqs.dao;


import com.hqs.common.Page;
import com.hqs.model.Ad;

public interface AdDao {
	public void add(Ad ad);
	public boolean delete(int id);
	public boolean update(Ad ad);
	public Ad findById(int id);
	public Page<Ad> queryPage(Page<Ad> page);
}
