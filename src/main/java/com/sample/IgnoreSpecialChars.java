package com.sample;

public class IgnoreSpecialChars {

	public static void validateTextContainsIgnoringSpecialChars(String textDesc,String inputValue,String expectedValue,String actualValue)
	{
		if(expectedValue != null && actualValue != null)
		{
			expectedValue = expectedValue.replaceAll("[^a-zA-Z0-9]", "");
			actualValue = actualValue.replaceAll("[^a-zA-Z0-9]", "");
			System.out.println(expectedValue);
			System.out.println(actualValue);
			if(expectedValue.trim().toLowerCase().contains(actualValue.trim().toLowerCase()) || actualValue.trim().toLowerCase().contains(expectedValue.trim().toLowerCase()))
				System.out.println("Passed");
			else
				System.out.println("Failed");
		}
		else if(actualValue == null && expectedValue == null)
			System.out.println("Passed");
		else
			System.out.println("Failed");
	}
	
	public static void main(String...arg)
	{
		validateTextContainsIgnoringSpecialChars("", "", "Tekion Cloud !@#$%^&*()_+{}|:<>?,./““““", "tekion");
	}
}
