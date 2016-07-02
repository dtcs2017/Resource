package com.hqs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqs.common.BaseDao;
import com.hqs.common.Page;
import com.hqs.dao.CostDao;
import com.hqs.model.Cost;

@Repository
public class CostDaoImpl extends BaseDao implements CostDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Cost cost) {
		String sql = "insert into cost(agreementid,title,description,cost,creator,createtime,state) values(?,?,?,?,?,?,?)";
		Object[] params = new Object[]{cost.getAgreementid(), cost.getTitle(), cost.getDescription(), 
				cost.getCost(), cost.getCreator(), cost.getCreatetime(), cost.getState()};
		jdbcTemplate.update(sql, params);
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from cost where id=?";
		int result = jdbcTemplate.update(sql, id);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Cost cost) {
		String sql = "update cost set title=?,description=?,cost=?,creator=?,createtime=?,state=? where id=?";
		int result = jdbcTemplate.update(sql, cost.getTitle(), cost.getDescription(), cost.getCost(),
				cost.getCreator(), cost.getCreatetime(), cost.getState(), cost.getId());
		
		if(result>0){
			return true;
		}
		return false;
	}
	
	public Cost findById(int id){
		String sql = "select a.*,b.name from cost a left join agreement b on a.agreementid=b.id where a.id="+id;
		List<Cost> list =this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Cost>(Cost.class));
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public Page<Cost> queryPage(Page<Cost> page){
		String sql = "select a.*,b.name from cost a left join agreement b on a.agreementid=b.id where 1=1";
		if(page.getParams().get("title")!=null){
			sql +=" and a.title="+page.getParams().get("title");
		}
		if(page.getParams().get("agreementid")!=null){
			sql +=" and a.agreementid="+page.getParams().get("agreementid");
		}
		sql+=" order by a.id asc ";
		page = pagedJdbcTemplate.queryMysql(page, sql, Cost.class);
		return page;
	}

}
