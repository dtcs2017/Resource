package com.hqs.model;

import java.io.Serializable;
import java.util.Date;

public class Agreement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -786855597400307224L;
	private int id;
	private String name;
	private int cateid;
	private String projectname;
	private String projectintro;
	private String projectbudget;
	private int state;
	private String creator;
	private Date createtime;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCateid() {
		return cateid;
	}
	public void setCateid(int cateid) {
		this.cateid = cateid;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getProjectintro() {
		return projectintro;
	}
	public void setProjectintro(String projectintro) {
		this.projectintro = projectintro;
	}
	public String getProjectbudget() {
		return projectbudget;
	}
	public void setProjectbudget(String projectbudget) {
		this.projectbudget = projectbudget;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
