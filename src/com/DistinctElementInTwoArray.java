package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class DistinctElementInTwoArray {
	
	public static void main(String[] args) {
		
List<Integer> a1= Arrays.asList(3,15,7,23,2,51,11,5);
List<Integer> a2= Arrays.asList(13,33,8,75,18,5,111);
a1.addAll(a2);

Object[] a=a1.stream().distinct().toArray();
System.out.println(a);
/*Set<Integer> s=new TreeSet<>();
s.addAll(a1);
for(Integer i:s)
	System.out.println(i);
*/

/*
List<Integer> list1=new ArrayList<>();
list1.add(11);
list1.add(33);
list1.add(33);

List<Integer> list2=new ArrayList<>();
list2.add(22);
list2.add(11);
list2.add(44);
list1.addAll(list2);

List<Integer> list=list1.stream().distinct().collect(Collectors.toList());

System.out.println(list);

*/

}
}
