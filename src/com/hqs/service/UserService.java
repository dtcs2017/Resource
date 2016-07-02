package com.hqs.service;

import java.util.List;

import com.hqs.common.Page;
import com.hqs.model.User;

public interface UserService {

	public void register(User user);
	
	public List<User> findAllUser();
	public boolean delete(int id);
	public boolean update(User user);
	public User findById(int id);
	public Page<User> queryPage(Page<User> page);
}
