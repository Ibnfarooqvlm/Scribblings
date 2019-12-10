package com.important;

import java.util.ArrayList;
import java.util.Arrays;

public class AmazonInterview 
{
	static String str = "cTrRtcC";
	public static void main(String...arg)
	{
		ArrayList<String> arr = new ArrayList<String>();
		ArrayList<String> res = new ArrayList<String>();
		
		for(int i=0;i<str.length();i++)
		{
			arr.add(str.charAt(i)+"");
		}
		
		for(int i=0;i<arr.size();i++)
		{
			String s = arr.get(i);
			if(s==null)
				continue;
			
			res.add(s);
			
			/*for(int j=i+1;j<arr.size();j++)
			{
				if(arr.get(j) == null)
					continue;
				if(s.equalsIgnoreCase(arr.get(j)))
				{
						res.add(arr.get(j));
						arr.set(j, null);
				}
			}*/
			
			int j=i+1;
			while(j<arr.size())
			{
				if(s.equalsIgnoreCase(arr.get(j)))
				{
					res.add(arr.get(j));
					arr.remove(j);
				}
				else
					j++;
			}
		}
		
		for(String s : res)
			System.out.print(s);
		
	}
}
