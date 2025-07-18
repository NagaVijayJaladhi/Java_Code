package com.jst.stream;

public class FaherToCel {

	public static void main(String[] args) {
		float temperatue = 120F;
		temperatue = ((temperatue-32)*5)/9;
		System.out.println("Temperatue in Celsius : " + temperatue);
	}
}
