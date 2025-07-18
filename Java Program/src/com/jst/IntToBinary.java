package com.jst;

public class IntToBinary {
	public static void main(String[] args) {
		int n = 5;
		int m;
		String x = "";
		while(n > 0) {
			int a = n%2;
			x = a + x;
			n = n/2;
		}
		System.out.println("Convert Integer to Binary : " + x);
	}
}
