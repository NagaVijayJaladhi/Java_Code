package com.demo;

public class ClassA extends ClassB {

	public static String sing() {
		return "fa";
	}

	public static void main(String[] args) {
		ClassA a = new ClassA();
		//ClassA b = new ClassB();
		System.out.println(a.sing() + " " + b.sing());
	}

}
