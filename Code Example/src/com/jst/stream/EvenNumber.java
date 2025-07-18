package com.jst.stream;

public class EvenNumber {

	public static void main(String[] args) {
		int n = 100;
		System.out.print("Display Even Numbers : ");
		for(int i = 0; i <= n; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
	}
}
