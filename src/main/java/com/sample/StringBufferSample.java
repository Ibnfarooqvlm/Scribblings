package com.sample;

public class StringBufferSample {

	public static void main(String[] args) {
		String s = "Ahamed Rahman";
		int lastIndex = s.lastIndexOf("Rahman");
		s = new StringBuffer(s).insert(lastIndex, "Abdul ").toString();
		System.out.println(s);

	}

}
