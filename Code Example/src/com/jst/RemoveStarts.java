package com.jst;

public class RemoveStarts {

	public static void main(String[] args) {

		String input = "leet**code*e";
		String result = removeStart(input);
		System.out.println("Remove Starts From String : " + result);
		
		String input1 = "earse*****";
		String result1 = removeStart(input1);
		System.out.println("Remove Starts from String : " + result1);
	}

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
}
