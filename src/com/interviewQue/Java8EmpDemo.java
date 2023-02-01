package com.interviewQue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Java8EmpDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
		employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
		employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
		employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
		employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
		employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
		employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
		employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
		employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
		employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
		// Sort Employee based on their salary in asc order
		List<Employee> collect = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		collect.forEach(sal -> System.out.println(sal.getName() + ": " + sal.getSalary()));

		// Or
		List<Employee> collect2 = employeeList.stream().sorted((a, b) -> (int) (a.getSalary() - b.getSalary()))
				.collect(Collectors.toList());
		System.out.println(collect2);

		
		
		
		System.out.println("**********");
		// Sort Employee based on their salary in desc order
		List<Employee> collect1 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.collect(Collectors.toList());
		collect1.forEach(sal -> System.out.println(sal.getName() + ": " + sal.getSalary()));

		//
		List<Employee> collect22 = employeeList.stream().sorted((a, b) -> (int) (b.getSalary() - a.getSalary()))
				.collect(Collectors.toList());
		System.out.println(collect22);

		System.out.println("**********");
		// Fetch top 3 salary

		List<Employee> collect3 = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.limit(3).collect(Collectors.toList());
		collect3.forEach(sal -> System.out.println(sal.getName() + ": " + sal.getSalary()));
       
		
		System.out.println("*******");
		//Fetch all employees having salary less than 3 rd highest salary

		List<Employee> collect4= employeeList.stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
				.skip(3).collect(Collectors.toList());
		collect4.forEach(sal -> System.out.println(sal.getName() + ": " + sal.getSalary()));
		
		
		
	}

}
