package com.sample;

public class IntermediateString {

	public static void main(String[] args) 
	{
		//getIntermediateString("Cart(676) $287.05", "(", ")");
		String s = ": -$45,789.80";
		System.out.println(s.replaceAll("[^\\d,.$-]", ""));
	}

	public static String getIntermediateString(String strText, String startChar, String endChar)
	{
		try
		{
			int startIndex = strText.indexOf(startChar);
			int endIndex = strText.indexOf(endChar);
			String intermediateString = strText.substring(startIndex+1, endIndex);
			return intermediateString;
		}catch(Throwable t)
		{}
		return null;
	}
}
