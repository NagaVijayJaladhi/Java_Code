package com.jst;

import java.util.Arrays;

public class CheckSum {
	
	public static void main(String[] args) {
		int [] arr = {21,13,8,19,7,4,6};
		int sum = 37;
		boolean result = checkTwoSum(arr, sum);
		System.out.println("Result : " + result);
	}
	
	public static boolean checkTwoSum(int [] arr, int sum) {
		return Arrays.stream(arr).anyMatch(x -> Arrays.stream(arr).filter(y -> y != x).anyMatch(y -> x + y == sum));
	}

}
