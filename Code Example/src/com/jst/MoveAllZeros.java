// Move All Zeros to end of Array

package com.jst;

public class MoveAllZeros {

	public static void main(String[] args) {
		
		int [] arr = {1, 2, 0, 4, 3, 0, 5, 0};
		pushZeros(arr);
		for(int num : arr) {
			System.out.println(num + " ");
		}
		
	}
	
	public static void pushZeros(int [] arr) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				int temp = arr[i];
				arr[i] = arr[count];
				arr[count] = temp;
				count++;
			}
		}
	}
}
