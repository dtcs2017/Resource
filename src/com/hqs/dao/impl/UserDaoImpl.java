package com.hqs.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.hqs.common.BaseDao;
import com.hqs.common.Page;
import com.hqs.dao.UserDao;
import com.hqs.model.User;

@Repository
public class UserDaoImpl extends BaseDao implements UserDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void register(User user) {
		String sql = "insert into user(username,realname,password,roleid,createtime) values(?,?,?,?,?)";
		Object[] params = new Object[]{user.getUsername(), user.getRealname(), user.getPassword(),
				user.getRoleid(), user.getCreatetime()};
		jdbcTemplate.update(sql, params);
	}
	
	@Override
	public List<User> findAllUser() {
		String sqlStr = "select * from user";
		
		return jdbcTemplate.query(sqlStr, new BeanPropertyRowMapper<User>(User.class));
	}

	@Override
	public boolean delete(int userid) {
		String sql = "delete from user where id=?";
		int result = jdbcTemplate.update(sql, userid);
		
		if (result > 0){
			return true;
		}
		
		return false;
	}

	@Override
	public boolean update(User user) {
		String sql = "update user set username=?,realname=?,password=?,roleid=?,createtime=? where id=?";
		int result = jdbcTemplate.update(sql, user.getUsername(), user.getRealname(), user.getPassword(),
				user.getRoleid(), user.getCreatetime(),user.getId());
		if (result > 0){
			return true;
		}
		
		return false;
	}
	
	public User findById(int id){
		String sql = "select a.*,b.role from user a left join role b on a.roleid=b.id where a.id="+id;
		List<User> list =this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		if(list!=null && list.size()>0){
			return list.get(0);
		}
		return null;
	}
	
	/**分页信息*/
	public Page<User> queryPage(Page<User> page){
		String sql = "select a.*,b.role from user a left join role b on a.roleid=b.id where 1=1";
		if(page.getParams().get("username")!=null){
			sql +=" and username like '%"+page.getParams().get("username")+"%'";
		}
		if(page.getParams().get("realname")!=null){
			sql +=" and realname like '%"+page.getParams().get("realname")+"%'";
		}
		sql+=" order by id asc ";
		page = pagedJdbcTemplate.queryMysql(page, sql, User.class);
		return page;
	}
	
}