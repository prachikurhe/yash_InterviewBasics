package com.java8feature;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

class Employee1 {
	private Integer id;
	private String name;
	private String address;
	private Double salary;

	public Employee1(Integer id, String name, String address, Double salary) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public Employee1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee1 [id=" + id + ", name=" + name + ", address=" + address + ", salary=" + salary + "]";
	}

}

public class EmployeeListOperation {
	public static void main(String[] args) {
		List<Employee1> list = new ArrayList<>();
		list.add(new Employee1(1, "Ashish", "Dighi", 50000d));
		list.add(new Employee1(2, "Ajit", "Salabatpure", 60000d));
		list.add(new Employee1(3, "Ram", "Nevasa", 13d));
		list.add(new Employee1(4, "Sahin", "Pune", 500000d));
		list.add(new Employee1(5, "Ashish", "Dighi", 50000d));
		list.add(new Employee1(6, "Shubham", "salabatpure", 90000d));
		// print list normally
		System.out.println(list);

		// print list by using forEch
		System.out.println("******************By using ForEch Loop*******************************");
		list.forEach((l) -> {
			System.out.println(l);
		});
		System.out.println("******************By using For Loop*******************************");
		for (Employee1 emp : list) {
			System.out.println(emp);
		}
		System.out.println("******************By using Iteretor*******************************");
		/*
		 * methods 1)hasNext() 2)next() 3)remove()
		 */
		Iterator<Employee1> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println("******************By using ListItertor*******************************");
		/*
		 * methods 1)hasNext() 2)next() 3)nextIndex() 4)hasPrevious() 5)previous()
		 * 6)previousIndex() 7)remove() 8)add() 9)set()
		 */
		ListIterator<Employee1> listItr = list.listIterator();
		while (listItr.hasNext()) {
			System.out.println(listItr.next());
		}
		System.out.println("***********************************************************************************");
		System.out.println("***************************filter List***********************");

		List<Employee1> evenSalaryEmployee = list.stream().filter(emp -> emp.getSalary() % 2 == 0)
				.collect(Collectors.toList());
		System.out.println(evenSalaryEmployee);
		System.out.println("***********************************************************************************");
		System.out.println("******************map*************************************");
		List<Double> hikeOfSalary = list.stream().map(emp -> emp.getSalary() + 10000).collect(Collectors.toList());
		System.out.println(hikeOfSalary);
		System.out.println("***********************************************************************************");

		System.out.println("*****************posible ways of sort list*******************************");
		System.out.println("************1)\t Sort list By Using Comparatotor By Id*******************************");
		List<Employee1> sortListById = list.stream().sorted(Comparator.comparing(Employee1::getId))
				.collect(Collectors.toList());
		System.out.println(sortListById);
		System.out.println(
				"************1)\t Sort list By Using Comparatotor By Id And Name*******************************");
		List<Employee1> sortListByIdAndName = list.stream()
				.sorted(Comparator.comparing(Employee1::getId).thenComparing(emp -> emp.getName()))
				.collect(Collectors.toList());
		System.out.println(sortListByIdAndName);
		System.out.println("***********************************************************************************");
		System.out.println("*****************Get Min And Max Salary of Employee*******************************");
		Double maxSalary = list.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getMax();
		System.out.println("Max Salary:" + maxSalary);
		Double minSalary = list.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getMin();
		System.out.println("Min Salary:" + minSalary);
		Double avgSalary = list.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getAverage();
		System.out.println("Avg Salary:" + avgSalary);
		Double sumSalary = list.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getSum();
		System.out.println("Sum of Salary:" + sumSalary);
		Double count = (double) list.stream().mapToDouble(emp -> emp.getSalary()).summaryStatistics().getCount();
		System.out.println("Count of Salary:" + count);
		System.out.println("***********************************************************************************");
		System.out.println("*****************Collect All Employee Name in single String************************");
		String allEmployeeNames = list.stream().map(emp -> emp.getName()).collect(Collectors.joining(", "));
		System.out.println(allEmployeeNames);
		System.out.println("***********************************************************************************");
		System.out.println("***********************Group By Close***************************");

		Map<Double, List<Employee1>> map = list.stream().collect(Collectors.groupingBy(emp -> emp.getSalary()));
		System.out.println("salary wise employees" + map);

		System.out.println("********************Sort Salary wise employee***********************");
		Map<Double, Set<Employee1>> sortedMap = list.stream()
				.collect(Collectors.groupingBy(emp -> emp.getSalary(), TreeMap::new, Collectors.toSet()));
		System.out.println("salary wise Sorted Employees" + sortedMap);

		System.out.println("***********************2nd Highest salary of employee**********************************");
		List<Employee1> secondAndThirdHighestSalary = list.stream()
				.sorted((emp1, emp2) -> emp2.getSalary().compareTo(emp1.getSalary())).skip(1).limit(2)
				.collect(Collectors.toList());
		System.out.println("Second And Third Highest salary of EMployee:" + secondAndThirdHighestSalary);

	}

}
