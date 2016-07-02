package com.hqs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqs.dao.AgreementcateDao;
import com.hqs.model.Agreementcate;

@Repository
public class AgreementcateDaoImpl implements AgreementcateDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Agreementcate> findAll() {
		String sql = "select * from agreementcate";
		List<Agreementcate> list = this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Agreementcate.class));
		return list;
	}

}
