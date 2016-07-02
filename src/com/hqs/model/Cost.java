package com.hqs.model;

import java.io.Serializable;
import java.util.Date;

public class Cost implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5235350445769957382L;
	private int id;
	private Integer agreementid;
	private String title;
	private String description;
	private Double cost;
	private String creator;
	private Date createtime;
	private int state;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Integer getAgreementid() {
		return agreementid;
	}
	public void setAgreementid(Integer agreementid) {
		this.agreementid = agreementid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getCost() {
		return cost;
	}
	public void setCost(Double cost) {
		this.cost = cost;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}

}
