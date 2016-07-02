package com.hqs.common;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service("pagedJdbcTemplate")
public class PagedJdbcTemplate extends JdbcTemplate {

	/** MYSQL 分页查询SQL模版 */
	private static final String MYSQL_PAGESQL_TEMPLATE = "${sql} limit ${startNum},10";
	        
	public <T> Page<T> queryMysql(Page<T> pageInfo, String sql, Class<T> requiredType) {
		String orderBy = "";
		if (StringUtils.contains(sql, "order by")) {
			orderBy = sql.substring(sql.indexOf("order by"));
			sql = sql.substring(0, sql.indexOf("order by"));
		}
		String sqlFrom = sql.substring(sql.indexOf("from"));
		String sqlCount = "select count(*) " + sqlFrom;
		// 总记录数
		long totalCount = super.queryForLong(sqlCount);
		int startNum = pageInfo.getPageSize() * (pageInfo.getPageNo() - 1);
		int endNum = pageInfo.getPageSize() * (pageInfo.getPageNo());
		if (endNum > totalCount) {
			endNum = (int) totalCount;
		}
		/*long totalPage = (totalCount % pageInfo.getPageSize() == 0 ? totalCount / pageInfo.getPageSize() : totalCount
				/ pageInfo.getPageSize() + 1);
*/
		String pageSql = MYSQL_PAGESQL_TEMPLATE;
		pageSql = StringUtils.replace(pageSql, "${sql}", sql +" "+orderBy);
		pageSql = StringUtils.replace(pageSql, "${startNum}", String.valueOf(startNum));
		pageSql = StringUtils.replace(pageSql, "${endNum}", String.valueOf(endNum));

		List<T> result = query(pageSql, BeanPropertyRowMapper.newInstance(requiredType));
		pageInfo.setResult(result);
		pageInfo.setTotalCount(totalCount);
		return pageInfo;
		
	}


	/**
	 * list 查询
	 */
	@Override
	public <T> List<T> queryForList(String sql, Class<T> elementType) throws DataAccessException {
		return query(sql, BeanPropertyRowMapper.newInstance(elementType));
	}
	
}
