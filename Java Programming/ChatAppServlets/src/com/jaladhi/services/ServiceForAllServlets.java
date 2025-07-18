package com.jaladhi.services;

import com.jaladhi.entity.MemberDataStructure;

public interface ServiceForAllServlets {

	public boolean checkUserNameInMember(String toUsername, String fromUsername);
	
	public void insertMessage(String toUsername, String fromUsername, String message);
	
	public void insertNotification(int toCode, String fromUsername, long messageCode);
	
	public int getCodeFromMemberByUserName(String toUsername, String fromUsername);
	
	public MemberDataStructure getMemberByUserName(String toUsername, String fromUsername);
	
}
