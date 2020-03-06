package com.sample;

public class Sample {

	public static void main(String[] args) {
		
		String input = "bcDCBdb";
		StringBuffer sb = new StringBuffer(input);
		
		int i=0;
		while(i<sb.length() - 1) {
			int j = i+1;
			int k = j+1;
			char iChar = sb.charAt(i);
			char jChar = sb.charAt(j);
			
			if(Character.toUpperCase(iChar) == Character.toUpperCase(jChar)) {
				j++;
				k=j+1;
			}
			else {
				while(k<sb.length()) {
					char kChar = sb.charAt(k);					
					if(Character.toUpperCase(iChar) == Character.toUpperCase(kChar)) {
						sb.setCharAt(j, kChar);
						sb.setCharAt(k, jChar);
						j++;
						jChar = sb.charAt(j);
					}
					k++;
				}
			}
			i = j;
			
		}
		
		System.out.println("Modified String = " + sb.toString());
	}
}
