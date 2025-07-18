package com.jst;

public class RemoveStarts {

	public static String removeStart(String s) {
		StringBuffer sb = new StringBuffer();
		for(final char c : s.toCharArray()) {
			if(c == '*') {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String input = "leet**cod*e";
		
		String result = removeStart(input);
		System.out.println("Output : " + result);
		
		String input1 = "erase*****";
		String result1 = removeStart(input1);
		System.out.println("Output 1 : " + result1);
	}
}
