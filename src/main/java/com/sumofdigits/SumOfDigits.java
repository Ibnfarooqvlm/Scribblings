package com.sumofdigits;

import java.util.Scanner;

public class SumOfDigits {

	public static void main(String[] args) {
		System.out.println("Enter n:");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();

		int nCopy = n;
		int sum = 0;
		while(true) {
			sum = 0;
			while(nCopy > 0) {
				sum += nCopy % 10;
				nCopy /= 10;
			}
			System.out.println(sum);
			if(sum > 9)
				nCopy = sum;
			else
				break;
		}
		System.out.println("The sum of digits of " + n + " is " + sum);
		scanner.close();
	}
}
