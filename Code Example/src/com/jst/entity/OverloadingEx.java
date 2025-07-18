package com.jst.entity;

public class OverloadingEx {

	public static void main(String[] args) {
		
	}
	
	public void addition(int a, int b) {
		System.out.println("Addition : " + a + b);
	}
	
	public void addition(int a, int b, int c) {
		System.out.println("Addition : " + a + b + c);
	}
}


class OverrideEx {
	
	public void addition(int a, int b) {
		System.out.println("Addition : " + a + b);
	}
}