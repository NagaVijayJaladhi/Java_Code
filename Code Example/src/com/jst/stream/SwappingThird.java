package com.jst.stream;

public class SwappingThird {

	public static void main(String[] args) {
		int a = 20;
		int b = 10;
		int temp = 0;
		System.out.println("Before Swapping with Third Variable : a = " + a + " b = " + b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("After Swapping with Third Variables : a = " + a + " b = " + b);
	}
}
