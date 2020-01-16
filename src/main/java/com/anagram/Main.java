package com.anagram;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			System.out.println("Enter n : ");
			int n = scanner.nextInt();
			scanner.nextLine();
			ArrayList<String> input = new ArrayList<String>();
			ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();

			//Get the input
			for(int i=0; i<n; i++) {
				System.out.println("Enter value " + (i+1)+ ":");
				String str = scanner.nextLine();
				input.add(str.toLowerCase());
			}
			
			//Process
			for(int i=0; i<n-1; i++) {
				Set<String> set = new HashSet<String>();
				for(int j=i+1; j<n; j++) {					
					if(compare(input.get(i),input.get(j))) {
						set.add(input.get(i));
						set.add(input.get(j));
						input.set(j, null);
					}
				}
				if(set.size() > 0) {
					ArrayList<String> al = new ArrayList<String>(set);
					output.add(al);
				}
				input.set(i, null);
			}
			
			//output
			for(int i=0; i<output.size(); i++) {
				System.out.println("Match "+ (i+1) +":");
				for(int j = 0; j < output.get(i).size(); j++) {					
					System.out.println(output.get(i).get(j));
				}
				System.out.println();
			}

		}catch(Throwable t) {
			t.printStackTrace();
		}finally {
			scanner.close();
		}
	}

	public static boolean compare(String str1, String str2) {
		if(str1 == null || str2 == null)
			return false;
		HashMap<String,Integer> map1 = convertStrToMap(str1);
		HashMap<String,Integer> map2 = convertStrToMap(str2);

		int size1 = map1.keySet().size();
		int size2 = map2.keySet().size();		
		if(size1 != size2)
			return false;

		Iterator<String> iterator = map1.keySet().iterator();
		while(iterator.hasNext()) {
			String key = iterator.next();
			Integer int1 = map1.get(key);
			Integer int2 = map2.get(key);

			if(int1 == null || int2 == null)
				return false;
			if(int1 != int2)
				return false;
		}
		return true;
	}

	public static HashMap<String, Integer> convertStrToMap(String str1) {
		HashMap<String,Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<str1.length(); i++) {
			String strKey = str1.charAt(i)+"";
			Integer value = map.get(strKey);
			if(value == null)
				value = 0;
			map.put(str1.charAt(i)+"",value+1);
		}
		return map;
	}
}
