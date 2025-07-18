package com.jaladhi.model;

import java.util.Date;

public class Todo {

	private int id;
	private String user;
	private String desc;
	private Date targetDate;
	private boolean isDone;

	public Todo(int id, String user, String desc, Date date, boolean b) {
		super();
		this.id = id;
		this.user = user;
		this.desc = desc;
		this.targetDate = date;
		this.isDone = b;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public boolean getIsDone() {
		return isDone;
	}

	public void setIsDone(boolean isDone) {
		this.isDone = isDone;
	}

}
