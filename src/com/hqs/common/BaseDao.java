package com.hqs.common;

import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseDao {

	@Autowired
	public PagedJdbcTemplate pagedJdbcTemplate;
	
}
