package com.jst;

import java.util.Arrays;

public class SumTwoNo {

	public static void main(String[] args) {
		int [] arr = {2,6,3,9,11};
		int sum = 16;
		boolean result = sumTwoValues(arr, sum);
		System.out.println("Result : " + result);
	}
	
	public static boolean sumTwoValues(int arr[], int sum) {
		return Arrays.stream(arr).anyMatch(x -> Arrays.stream(arr).filter(y -> y != x).anyMatch(y -> x + y == sum));
	}
}
