package com.jst;

public class CountObjects {
	
	public static int count = 0;
	
	public CountObjects() {
		count++;
	}

	public static void main(String[] args) {
		CountObjects cb1 = new CountObjects();
		CountObjects cb2 = new CountObjects();
		CountObjects cb3 = new CountObjects();
		CountObjects cb4 = new CountObjects();
		System.out.println("Count No of Object : " + count);
	}
}
