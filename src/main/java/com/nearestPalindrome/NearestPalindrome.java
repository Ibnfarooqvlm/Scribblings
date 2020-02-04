package com.nearestPalindrome;

import java.util.Scanner;

public class NearestPalindrome {

	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter n : ");
			int n = scanner.nextInt();
						
			int result = -1;
			for(int counter = 0; counter < n; counter++){
				int plusValue = n + counter;
				boolean plusCheck = checkPalindrome(plusValue);				
				if(plusCheck) {
					result = plusValue;
				}
				
				int minusValue = n - counter;
				boolean minusCheck = checkPalindrome(minusValue);
				if(minusCheck) {
					result = minusValue;
				}
				
				if(result != -1)
					break;
			}
			
			if(result == -1) {
				System.out.println("Unable to get the result");
			}
			else {
				System.out.println("Nearest Palindrome of " + n + " is " + result);
			}
		}catch(Throwable t) {
			t.printStackTrace();
		}finally {
			scanner.close();
		}
	}
	
	public static boolean checkPalindrome(int value) {		
		String valueReverse = new StringBuffer(value+"").reverse().toString();
		if((value+"").equals(valueReverse))
			return true;
		return false;
	}
}
