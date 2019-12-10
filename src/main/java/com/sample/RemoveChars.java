package com.sample;

public class RemoveChars {

	public static void main(String[] args) {
		String s = "Cart(69)";
		s = s.replaceAll("[^\\d]", "");
		System.out.println(s);
	}
}
