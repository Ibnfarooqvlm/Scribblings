package bnym;

import java.util.HashSet;

public class HashSetRemoveDuplicates {

	public static void main(String[] args) {
		
		HashSet<Employee> set = new HashSet<Employee>();
		int n[] = {10,10,10};
		
		for(int i:n) {
			Employee employee = new Employee(i);
			System.out.println("Added employee - " + employee.hashCode());
			set.add(employee);			
		}
		
		System.out.println(set.size());
	}
	
}

class Employee {
	
	int id = 0;
	
	public Employee(int id) {
		this.setId(id);
	}
	
	public int hashCode() {		
		return id;
	}
	
	public boolean equals(Object e2) {
		return this.hashCode() == e2.hashCode();
		
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
}
