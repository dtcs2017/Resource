package com.hqs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqs.common.BaseDao;
import com.hqs.common.Page;
import com.hqs.dao.AdDao;
import com.hqs.model.Ad;
@Repository
public class AdDaoImpl extends BaseDao implements AdDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Ad ad) {
		String sql = "insert into ad(title,content,createtime) values(?,?,?)";
		Object[] params = new Object[]{ad.getTitle(), ad.getContent(),ad.getCreatetime()};
		jdbcTemplate.update(sql, params);
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from ad where id=?";
		int result = jdbcTemplate.update(sql, id);
		if(result>0){
			return true;
		}
		return false;
	}

	@Override
	public boolean update(Ad ad) {
		String sql = "update ad set title=?,content=?,createtime=?";
		int result = jdbcTemplate.update(sql, ad.getTitle(), ad.getContent(), ad.getCreatetime());
		
		if(result>0){
			return true;
		}
		return false;
	}
	public Ad findById(int id){
		String sql = "select * from ad where id="+id;
		List<Ad> list =this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<Ad>(Ad.class));
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	/**分页信息*/
	public Page<Ad> queryPage(Page<Ad> page){
		String sql = "select * from ad where 1=1";
		if(page.getParams().get("title")!=null){
			sql +=" and title like '%"+page.getParams().get("title")+"%'";
		}
		sql+=" order by id asc ";
		page = pagedJdbcTemplate.queryMysql(page, sql, Ad.class);
		return page;
	}

}
