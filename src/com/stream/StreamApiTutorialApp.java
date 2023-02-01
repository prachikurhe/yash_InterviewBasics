package com.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class StreamApiTutorialApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> employees = new ArrayList<>();
		employees.add(new Employee("Prachi", "Kurhe", 50000.0, List.of("Project1", "Project2")));
		employees.add(new Employee("Pradnya", "Kurhe", 51000.0, List.of("Project2", "Project3")));
		employees.add(new Employee("Rahul", "Kurhe", 52000.0, List.of("Project4", "Project2")));
		employees.add(new Employee("Aniket", "Kurhe", 53000.0, List.of("Project3", "Project5")));
		employees.add(new Employee("Aniket", "bdsfksb", 54000.0, List.of("Project3", "Project5")));


        //for each
		employees.stream().forEach(emp -> System.out.println(emp));

		// Map: take one object and gives another object
		List<Employee> increasedSal = employees.stream().map(
				emp -> new Employee(emp.getFirstName(), emp.getLastName(), emp.getSalary() * 1.10, emp.getProject()))
				.collect(Collectors.toList());
		System.out.println(increasedSal);

		// Filter
		System.out.println("************************");
		Employee firstEmp = employees.stream().filter(e -> e.getSalary() > 50000.0).map(
				emp -> new Employee(emp.getFirstName(), emp.getLastName(), emp.getSalary() * 1.10, emp.getProject()))
				.findFirst().orElse(null);
		System.out.println(firstEmp);

		/*
		 * flatMap: flatMap() is used for both transformation and flattening.By using
		 * the flattening mechanism, it merges all streams into a single resultant
		 * stream. 
		 * flatMap() V/s map() : 
		 * 1) map() takes a Stream and transform it to
		 * another Stream. It applies a function on each element of Stream and store
		 * return value into new Stream. It does not flatten the stream. But flatMap()
		 * is the combination of a map and a flat operation i.e, it applies a function
		 * to elements as well as flatten them.
		 *  2) map() is used for transformation
		 * only, but flatMap() is used for both transformation and flattening.
		 * 
		 */
		
	 	String projects = employees.stream().map(emp->emp.getProject()).flatMap(strings->strings.stream()).
		collect(Collectors.joining(","));
		System.out.println(projects);
		
		//ShortCircuit Operation
		List<Employee> shortCircuit = employees.stream().skip(1).limit(1).collect(Collectors.toList());
		System.out.println(shortCircuit);
		
		//Sorting
		List<Employee> sortDta = employees.stream().sorted((o1,o2)->o1.getFirstName().compareToIgnoreCase(o2.getFirstName())).
		collect(Collectors.toList());
		System.out.println(sortDta);
		System.out.println("******************");
		//max or min
		Employee maxSal = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
		System.out.println("Max"+maxSal);
		
		
		//min
		Employee minSal = employees.stream().min(Comparator.comparing(Employee::getSalary)).orElseThrow(NoSuchElementException::new);
		System.out.println(minSal);
		
		
		//reduce
		//average of salary
		double avgSalDouble = employees.stream().filter(emp->emp.getFirstName().equalsIgnoreCase("Aniket")).map(emp->emp.getSalary())
		.mapToDouble(i->i).average().getAsDouble();
		System.out.println(avgSalDouble);
		
		double sum = employees.stream().filter(emp->emp.getFirstName().equalsIgnoreCase("Aniket")).
		map(emp->emp.getSalary()).mapToDouble(i->i).sum();
		System.out.println(sum);
		
	}

}
