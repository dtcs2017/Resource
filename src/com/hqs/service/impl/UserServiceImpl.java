package com.hqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqs.common.Page;
import com.hqs.dao.UserDao;
import com.hqs.model.User;
import com.hqs.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void register(User user) {
		userDao.register(user);
	}

	@Override
	public List<User> findAllUser() {
		return userDao.findAllUser();
	}

	@Override
	public boolean delete(int id) {
		return userDao.delete(id);
	}

	@Override
	public boolean update(User user) {
		return userDao.update(user);
	}
	
	public User findById(int id){
		return userDao.findById(id);
	}

	@Override
	public Page<User> queryPage(Page<User> page) {
		return userDao.queryPage(page);
	}

}
