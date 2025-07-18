package com.jst;

public class StringDemo {
	public static void main(String[] args) {
		System.out.println("Try programiz.pro");
		String firstString = "HelloWorld";
		String secondString = "HelloWorld";
		secondString.toUpperCase();
		String thirdString = new String("HelloWorld");
		System.out.println(firstString == secondString);
		System.out.println(firstString == thirdString);
		System.out.println(firstString.equals(secondString));
		System.out.println(firstString.equals(thirdString));
	}
}
