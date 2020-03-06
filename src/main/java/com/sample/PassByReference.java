package com.sample;

public class PassByReference {

	static PassByRef passByRef = null;
	public static void main(String[] args) {
		passByRef = new PassByRef();
		passByRef.name = "Ahamed";
		
		change(passByRef);
		System.out.println(passByRef.name);
	}
	
	public static void change(PassByRef passByRef) {
		passByRef = new PassByRef();
		passByRef.name = "Abdul";
	}
}
