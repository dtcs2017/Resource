package com.hqs.model;

import java.io.Serializable;

public class Agreementcate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6122284485424758909L;
	private int id;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
}
