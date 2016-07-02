package com.hqs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqs.dao.RoleDao;
import com.hqs.model.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Role> findAll() {
		String sql = "select * from role";
		List<Role> list = this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Role.class));
		return list;
	}

}
