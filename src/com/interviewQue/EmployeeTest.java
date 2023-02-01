package com.interviewQue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class EmployeeTest {
	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();

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
		employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
		employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
		employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
		employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
		employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
		employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
		employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

		List<Employee> nameOfEmp = employeeList.stream().filter(e -> e.getName().equals("Ali Baig"))
				.collect(Collectors.toList());
		List<Employee> nameOfEmp1 = employeeList.stream().filter(e -> e.getName().equalsIgnoreCase("anuj CHettiar"))
				.collect(Collectors.toList());
		System.out.println(nameOfEmp);
		System.out.println(nameOfEmp1);
		System.out.println("==================================");
		

		System.out.println("Query 3.1 : How many male and female employees are there in the organization?\r\n" + "");
		Map<String, Long> noOfMaleAndFemaleEmp = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
		System.out.println(noOfMaleAndFemaleEmp);

		System.out.println("Query 3.2 : Print the name of all departments in the organization?\r\n" + "");

		List<String> name = employeeList.stream().map(Employee::getDepartment).distinct().collect(Collectors.toList());
		System.out.println();
		// or
		employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

		System.out.println("Query 3.3 : What is the average age of male and female employees?\r\n" + "");
		Map<String, Double> avgAge = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(avgAge);

		System.out.println("Query 3.6 : Count the number of employees in each department?\r\n" + "");
		Map<String, Long> countEmpInEachDept = employeeList.stream()
				.collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
//		Set<Entry<String, Long>>entrySet=countEmpInEachDept.entrySet();
//		for(Entry<String, Long>entry:entrySet) {
//			System.out.println(entry.getKey()+":"+entry.getValue());
//		}
		countEmpInEachDept.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println("Query 3.7 : What is the average salary of each department?\r\n" + "");
		Map<String, Double> avgSal = employeeList.stream().collect(
				Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
//        System.out.println(avgSal);
		avgSal.forEach((k, v) -> System.out.println(k + " " + v));

		System.out.println("Max sal of emp");
		Optional<Employee> maxSalOfEmp = employeeList.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
		System.out.println(maxSalOfEmp);

		/*
		 * //2. WAP to find the city with high pollution_index and high city area.
		 * List<CityName> list = cs.stream()
		 * .sorted(Comparator.comparing(CityName::getPollutionIndex)
		 * .thenComparing(CityName::getArea_of_city).reversed()) .limit(1)
		 * .collect(Collectors.toList());
		 */
		System.out.println("Print sal in asc order");
		List<Employee> salInAsc = employeeList.stream().sorted(Comparator.comparing(Employee::getSalary))
				.collect(Collectors.toList());
		salInAsc.forEach(sal -> System.out.println(sal.getName() + ": " + sal.getSalary()));

		System.out.println("Print age in desc order");

		List<Employee> ageInDesc = employeeList.stream().sorted(Comparator.comparing(Employee::getAge).reversed())
				.collect(Collectors.toList());
		ageInDesc.forEach(age -> System.out.println(age.getName() + ": " + age.getAge()));
		
		
		System.out.println("Print name of emp having max age ");

		List<Employee> list = employeeList.stream().sorted(Comparator.comparing(Employee::getAge).reversed()).limit(1).collect(Collectors.toList());
        list.forEach(age->System.out.println(age.getName()+"::"+age.getAge()));
	}

}
