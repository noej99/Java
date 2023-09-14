package com.noej.may091jl.restaurant;

import java.util.Date;

public class Restaurant {
	private String name;
	private Date since;
	private String addr;
	
	private String since2;
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(String name, Date since, String addr, String since2) {
		super();
		this.name = name;
		this.since = since;
		this.addr = addr;
		this.since2 = since2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getSince() {
		return since;
	}

	public void setSince(Date since) {
		this.since = since;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getSince2() {
		return since2;
	}

	public void setSince2(String since2) {
		this.since2 = since2;
	}
}
