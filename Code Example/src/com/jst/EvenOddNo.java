package com.jst;

public class EvenOddNo {

	public static void main(String[] args) {

		
		String str = "My name is Vijay";
		
		// Output : ya jiVs ie manyM
		String reverse = "";
		for(int i = str.length(); i > 0; i--) {
			reverse = reverse + str.charAt(i);
		}
		
		String [] app = reverse.split(" ");
		StringBuffer sb = new StringBuffer();
		for(int j = 0; j < app.length; j++) {
			sb.append(app[j] + app[j].substring(0,3));
		}
	}
}
