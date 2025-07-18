package com.jst.stream;

public class Swapping {

	public static void main(String[] args) {
		int a = 30;
		int b = 20;
		System.out.println("Before Swapping without Third Variable : a = " + a + " b = " + b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("After Swapping without Third Varibale : a = " + a + " b = " + b);
	}
}
