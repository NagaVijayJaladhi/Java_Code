package com.jst.stream;

public class OddNumber {

	public static void main(String[] args) {
		int n = 100;
		System.out.print("Display Odd Numbers : ");
		for(int k = 0; k <= n; k++) {
			if(k%2 != 0) {
				System.out.print(k + " ");
			}
		}
	}
}
