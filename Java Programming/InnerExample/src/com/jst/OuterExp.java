package com.jst;

public class OuterExp {

	int x = 10;

	class InnerExp {
		int y = 5;
	}
	
	public static void main(String[] args) {
		
		OuterExp myOuter = new OuterExp();
		OuterExp.InnerExp myInner = myOuter.new InnerExp();
	    System.out.println(myInner.y + myOuter.x);
	}
}
