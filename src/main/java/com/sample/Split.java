package com.sample;

import java.util.regex.Pattern;

public class Split {

	public static void main(String...ar)
	{
		//String s = "Michelin | 215/40R18 85Y";
		/*String s = "CF | Customer Pay";
		String[] arr = s.split("\\|");
		for (String string : arr) {
			System.out.println(string);
		}*/
		
		String all = "All(10)";
		System.out.println(all.replaceAll("[^0-9]", ""));
	}
}
