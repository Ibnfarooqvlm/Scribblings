package com.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class DatePickerValue {

	static String currentValue = "23 22 21 20 19 27 26 25 24 23 24 23 22 April March February January December August July June May April May April March 2003 2002 2001 2000 1999 2007 2006 2005 2004 2003 2004 2003 2002";

	public static <T> List<T> removeDuplicatesInList(List<T> list)
	{
		List<T> updatedList = new ArrayList<T>();
		try {
			Set<T> set = new LinkedHashSet<T>();
			set.addAll(list);
			updatedList.addAll(set);
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return updatedList;
	}

	public static void main(String...strings)
	{
		HashMap<String,String> datePickerWheelMap = new HashMap<String, String>();
		try {
			//WebElement valueText = createElement(byDatePickerWheelValue);
			//String currentValue = getAttribute(valueText,"label");
			String[] currentValues = currentValue.split("\\s+");
			List<String> currentValuesList = Arrays.asList(currentValues);
			List<String> currentValuesDistinctList = removeDuplicatesInList(currentValuesList);

			List<Integer> countList = new ArrayList<Integer>();
			List<String> resultList = new ArrayList<String>();
			for(int i=0;i<currentValuesDistinctList.size();i++)
			{
				int count = 0;
				String testData = currentValuesDistinctList.get(i);
				for(int j=0;j<currentValuesList.size();j++)
				{
					if(testData.equals(currentValuesList.get(j)))
						count++;
				}
				countList.add(count);
			}

			for(int i=0;i<currentValuesDistinctList.size();i++)
			{
				if(countList.get(i) == 3)
					resultList.add(currentValuesDistinctList.get(i));
			}

			datePickerWheelMap.put("date", resultList.get(0));
			datePickerWheelMap.put("month", resultList.get(1));
			datePickerWheelMap.put("year", resultList.get(2));
		}catch(Exception ex)
		{}
		System.out.println(datePickerWheelMap);
	}
}
