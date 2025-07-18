package com.jst;

public class MissingNo {
	public static void main(String[] args) {
		int i, total;
		int a[] = {1,2,3,5,6};
		int n = a.length;
		total = (n+1)*(n+2)/2;
		for(int k = 0; k < n; k++) {
			total = total - a[k];
		}
		System.out.println("Missing Number : " + total);
	}
}
