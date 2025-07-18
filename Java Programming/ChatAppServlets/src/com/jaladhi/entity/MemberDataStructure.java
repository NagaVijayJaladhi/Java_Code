package com.jaladhi.entity;

import java.io.*;

public class MemberDataStructure implements Serializable {

	private static final long serialVersionUID = 1L;
	private String username;
	private int code;
	private boolean correct;

	public MemberDataStructure() {
		super();
	}
	
	public MemberDataStructure(String username, int code, boolean correct) {
		super();
		this.username = username;
		this.code = code;
		this.correct = correct;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getCode() {
		return this.code;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return this.username;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}
	
}