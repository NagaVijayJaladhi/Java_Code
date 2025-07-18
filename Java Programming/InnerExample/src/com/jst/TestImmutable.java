package com.jst;

public class TestImmutable {

	public static void main(String[] args) {
		ImmutableClass imm = new ImmutableClass("Kumar", "Bangalore");
		System.out.println("Name : " + imm.getName());
		System.out.println("City : " + imm.getCity());
	}
}
