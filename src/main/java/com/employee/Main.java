package com.employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {

	public static void main(String[] args) {
		ArrayList<Employee> list = new ArrayList<Employee>();
		
		list.add(new Employee(1,"Ahamed",89000));
		list.add(new Employee(2,"Abdul",80000));
		list.add(new Employee(3,"Rahman",70000));
		
		Comparator<Employee> compareById = (Employee o1, Employee o2) -> o1.id - o2.id;
		
		Comparator<Employee> compareByName = (Employee o1, Employee o2) -> o1.name.compareTo(o2.name);
		
		Comparator<Employee> compareByEmployee = (Employee o1, Employee o2)  -> (int) (o1.salary - o2.salary);
		
		Collections.sort(list, compareById.reversed());		
		System.out.println(list);
		
		Collections.sort(list, compareByName);		
		System.out.println(list);
		
		Collections.sort(list, compareByEmployee);		
		System.out.println(list);
	}
}
