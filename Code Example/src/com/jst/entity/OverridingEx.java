package com.jst.entity;

public class OverridingEx {

	public static void main(String[] args) {
		int a = 123;
		int fina = 0, b;
		
		while(a != 0) {
			b = a % 10;
			fina = fina + b;
			a = a /10;
		}
		System.out.println(fina);
	}
}
