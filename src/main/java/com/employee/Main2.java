package com.employee;

import java.util.ArrayList;
import java.util.Collections;

public class Main2 {

	public static void main(String...arg)
	{
		ArrayList<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(1,"Ahamed",80000));
		list.add(new Employee(2,"Abdul",70000));
		list.add(new Employee(3,"Rahman",60000));
		
		sort(list);
		
	}
	
	public static void sort(ArrayList<Employee> list)
	{
		ArrayList<Employee> list2 = new ArrayList<Employee>(list);
		for(int i=0;i<list.size()-1;i++)
		{
			for(int j=i+1;j<list.size();j++)
			{
				if(list2.get(i).name.compareTo(list2.get(j).name) > 0)
				{
					Collections.swap(list2, i, j);
				}
			}
		}
		System.out.println(list2);
	}
}
