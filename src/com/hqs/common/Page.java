package com.hqs.common;


import java.io.Serializable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final List<String> ORDERS = Arrays.asList(new String[] {
			"asc", "desc" });
	private int pageNo;
	private int pageSize;
	private String orderBy;
	private String order;
	private boolean autoCount;
	private long totalCount;
	private List<T> result;
	private long totalPages;
	private Map<String, Object> params;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Page() {
		this.pageNo = 1;
		this.pageSize = 10;

		this.autoCount = true;
		this.totalCount = -1L;

		this.result = Collections.emptyList();
		this.params = new HashMap();
	}

	public int getPageNo() {
		return this.pageNo;
	}

	public Page<T> setPageNo(int pageNo) {
		this.pageNo = pageNo;
		if (this.pageNo < 1) {
			this.pageNo = 1;
		}
		return this;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public Page<T> setPageSize(int pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public String getOrderBy() {
		return this.orderBy;
	}

	public Page<T> setOrderBy(String orderBy) {
		this.orderBy = orderBy;
		return this;
	}

	public String getOrder() {
		return this.order;
	}

	public Page<T> setOrder(String order) {
		String[] orders = StringUtils.split(StringUtils.lowerCase(order), ',');
		for (String orderStr : orders) {
			if (!(ORDERS.contains(orderStr.toLowerCase()))) {
				throw new IllegalArgumentException(
						"page's order must be asc or desc");
			}
		}

		this.order = StringUtils.lowerCase(order);
		return this;
	}

	public boolean isOrderBySetted() {
		return ((StringUtils.isNotBlank(this.orderBy)) && (StringUtils
				.isNotBlank(this.order)));
	}

	public boolean isAutoCount() {
		return this.autoCount;
	}

	public Page<T> setAutoCount(boolean autoCount) {
		this.autoCount = autoCount;
		return this;
	}

	public long getTotalCount() {
		return this.totalCount;
	}

	public Page<T> setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		return this;
	}

	public List<T> getResult() {
		return this.result;
	}

	public Page<T> setResult(List<T> result) {
		this.result = result;
		return this;
	}

	public Map<String, Object> getParams() {
		return this.params;
	}

	public void setParams(Map<String, Object> params) {
		this.params = params;
	}

	public void appendParams(String key,Object value){
		this.params.put(key, value);
	}
	
	
	public long getTotalPages() {
		if (this.totalCount < 0L) {
			return -1L;
		}

		long count = this.totalCount / this.pageSize;
		if (this.totalCount % this.pageSize > 0L) {
			count += 1L;
		}
		return count;
	}

	public int getFirst() {
		return ((this.pageNo - 1) * this.pageSize + 1);
	}

	public boolean getIsHasNext() {
		return (this.pageNo + 1 <= getTotalPages());
	}

	public int getNextPage() {
		if (getIsHasNext()) {
			return (this.pageNo + 1);
		}
		return this.pageNo;
	}

	public boolean getIsHasPre() {
		return (this.pageNo - 1 >= 1);
	}

	public int getPrePage() {
		if (getIsHasPre()) {
			return (this.pageNo - 1);
		}
		return this.pageNo;
	}
}
