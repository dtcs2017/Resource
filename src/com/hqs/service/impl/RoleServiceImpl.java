package com.hqs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hqs.dao.RoleDao;
import com.hqs.model.Role;
import com.hqs.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> findAll() {
		return roleDao.findAll();
	}

}
