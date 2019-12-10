package com.important;

import java.util.Scanner;

public class StarProgram {

	public static void main(String...arg)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n : ");
		int n = scan.nextInt();

		upsideDownTirangle(n);
		triangle(n);
		scan.close();
	}
	
	public static void upsideDownTirangle(int n)
	{
		for(int a=0;a<n/2+1;a++)
		{
			for(int i=0;i<a;i++)
				System.out.print(" ");
			int m=n-(a*2);
			for(int i=0;i<m;i++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
	
	public static void triangle(int n)
	{
		for(int a=n/2;a>=0;a--)
		{
			for(int i=a-1;i>=0;i--)
				System.out.print(" ");
			int m=n-(a*2);
			for(int i=0;i<m;i++)
			{
				System.out.print("*");
			}
			System.out.println("");
		}
		
	}
}
