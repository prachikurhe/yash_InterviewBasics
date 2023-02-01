package com.interviewQue;
/*
 * 1]count occurrance of string s="java"
also write by using  java8
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test2 {
	public static void main(String[] args) {
        System.out.println("Hello world!");

        String str="hrushikeshWaghmare";

        Map<String,Integer>map = new HashMap<String,Integer>();
        Arrays.asList(str.split("")).stream().forEach(s-> map.put(s,map.getOrDefault(s,0)+1));

        map.forEach((k,v) -> System.out.println(k+" "+v));
        
        String s="Pracsihcfkhsf";
        Map<String,Integer>map1=new HashMap<>();
        Arrays.asList(s.split("")).stream().forEach(s1->map.put(s, map.getOrDefault(s1,0)+1));
        map.forEach((k1,v1)->System.out.println(k1+""+v1));
        
        

    }

}
