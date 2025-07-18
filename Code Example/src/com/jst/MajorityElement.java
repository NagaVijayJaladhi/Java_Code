package com.jst;

public class MajorityElement {

	static int majorityElement(int[] arr) {
        int n = arr.length;
        int candidate = -1;
        int count = 0;

        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) {
                count++;
            }
        }
	
        if (count > n / 2) {
            return candidate;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 2};
        System.out.println(majorityElement(arr));
    }
}
