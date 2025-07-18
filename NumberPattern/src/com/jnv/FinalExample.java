package com.jnv;

public final class FinalExample {

	public static final int a = 10;
	
	public static void main(String [] args) {
		add();
		System.out.println("Final Variable : " + a);
	}
	
	public static final void add() {
		System.out.println("Addition of Two Values : " + (10 + 20));
	}
	
	public static final void add(int a) {
		System.out.println("Addition of Two Values : " + (10 + 20));
	}
}
