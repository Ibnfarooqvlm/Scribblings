package com.sample;

import java.util.HashMap;
import java.util.Map.Entry;

public class MinDiff {

	public static void main(String[] args) {
		int[] numList = {5,10,100,500,1000};
		int num = 4;
		
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		int minDiff = Math.abs(numList[0] - num);
		for(int i=0;i<numList.length;i++)
		{
			map.put(numList[i], Math.abs(numList[i]-num));
			if(minDiff > Math.abs(numList[i]-num))
				minDiff = Math.abs(numList[i]-num);
		}
		
		for(Entry<Integer, Integer> entry : map.entrySet())
		{
			if(entry.getValue().equals(minDiff))
				System.out.println(entry.getKey());
		}
	}
}
