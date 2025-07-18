package com.jst;

public class SumEvenOdd {
	public static void main(String[] args) {
		int a[] = {1,2,3,4,5,6,7,8,9,10};
		int sume = 0, sumo = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i]%2 == 0) {
				sume = sume + a[i];
			} else {
				sumo = sumo + a[i];
			}
		}
		System.out.println("Sum of Even Number : " + sume);
		System.out.println("Sum of Odd Number : " + sumo);
	}
}
