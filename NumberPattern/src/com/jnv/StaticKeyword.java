package com.jnv;

public class StaticKeyword {
	
	public static int a = 10;
	public static int b = 20;
	
	static {
		System.out.println("Static Block");
	}
	
	public static void main(String[] args) {
		add();
		System.out.println("A : " + a);
	}
	
	public static void add() {
		System.out.println("Addition : " + (a+b));
	}
	
	public static class Demo {
		int c = 100;
	}
}
