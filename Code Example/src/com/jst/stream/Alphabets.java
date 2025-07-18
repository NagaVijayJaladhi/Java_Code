package com.jst.stream;

public class Alphabets {

	public static void main(String[] args) {
		char sa;
		char ca;
		System.out.print("Display Small Alphabets (a - z) : ");
		for(sa = 'a'; sa <= 'z'; sa++) {
			System.out.print(sa + " ");
		}
		
		System.out.print("\nDisplay Capital Alphabets (A - Z) : ");
		for(ca = 'A'; ca <= 'Z'; ca++) {
			System.out.print(ca + " ");
		}
	}
}
