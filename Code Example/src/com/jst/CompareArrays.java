package com.jst;

public class CompareArrays {

	public static void main(String[] args) {
		
		int [] a = {1, 2, 3};
		int [] b = {3, 4, 5};
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < b.length; j++) {
				if(a[i] == b[j]) {
					System.out.println("Common of Two Arrays : " + a[i]);
				}
			}
		}
	}
}
