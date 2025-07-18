package com.jst;

public class LeapYear {
	public static void main(String[] args) {
		int year = 1998;
		boolean flag = false;
		if(year % 400 == 0) {
			flag = true;
		} else if (year % 100 == 0) {
			flag = false;
		} else if(year % 4 == 0) {
			flag = true;
		} else {
			flag = false;
		}
		if(flag) {
			System.out.println(year + " is Leap Year");
		} else {
			System.out.println(year + " is not Leap Year");
		}
	}
}
