package com.hqs.model;

import java.io.Serializable;
import java.util.Date;

public class Ad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4928448318866450903L;
	private int id;
	private String title;
	private String content;
	private Date createtime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

}
