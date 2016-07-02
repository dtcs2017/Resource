package com.hqs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqs.common.BaseDao;
import com.hqs.common.Page;
import com.hqs.dao.AgreementDao;
import com.hqs.model.Agreement;

@Repository
public class AgreementDaoImpl extends BaseDao implements AgreementDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public void add(Agreement agreement) {
		String sql = "insert into agreement(name,cateid,projectname,projectintro,projectbudget,state,creator,createtime)"
				+ " values(?,?,?,?,?,?,?,?)";
		Object[] params = new Object[]{agreement.getName(), agreement.getCateid(), agreement.getProjectname(),
				agreement.getProjectintro(), agreement.getProjectbudget(), agreement.getState(),
				 agreement.getCreator(), agreement.getCreatetime()};
		jdbcTemplate.update(sql, params);
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from agreement where id=?";
		int result = jdbcTemplate.update(sql, id);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Agreement agreement) {
		String sql = "update agreement set name=?,cateid=?,projectname=?,"
				+ "projectintro=?,projectbudget=?,state=?,creator=?,createtime=? where id=?";
		int result = jdbcTemplate.update(sql, agreement.getName(), agreement.getCateid(), agreement.getProjectname(),
				agreement.getProjectintro(), agreement.getProjectbudget(), agreement.getState(),
				agreement.getCreator(), agreement.getCreatetime(), agreement.getId());
		if(result>0){
			return true;
		}
		return false;

	}
	
	public Agreement findById(int id){
		String sql = "select a.*,b.category from agreement a left join agreementcate b on"
				+ " a.cateid=b.id where a.id="+id;
		List<Agreement> list =this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Agreement>(Agreement.class));
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	public Page<Agreement> queryPage(Page<Agreement> page){
		String sql = "select a.*,b.category from agreement a left join agreementcate b on"
				+ " a.cateid=b.id where 1=1";
		if(page.getParams().get("cateid")!=null){
			sql +=" and a.cateid="+page.getParams().get("cateid");
		}
		if(page.getParams().get("name")!=null){
			sql +=" and a.name like "+page.getParams().get("name");
		}
		if(page.getParams().get("projectname")!=null){
			sql +=" and a.projectname like "+page.getParams().get("projectname");
		}
		sql+=" order by a.id asc ";
		page = pagedJdbcTemplate.queryMysql(page, sql, Agreement.class);
		return page;
	}

}
