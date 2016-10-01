package com.akshay.java.c11;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class PrintingContainers {
	
	

	/**
	 *  Dummay API to fill to the geniric collection 
	 * @param c 
	 * @return
	 */
	static Collection fill(Collection c){
		c.add("dog");
		c.add("dog");
		c.add("cat");
		return c;
	}
	
	/**
	 * Dummay API to fill to map a dummy objects.
	 * @param m
	 * @return
	 */
	static Map fill(Map m){
		m.put("dog","Basco");
		m.put("dog","Spot");
		m.put("cat","Rags");
		return m;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(fill(new ArrayList()));
		System.out.println(fill(new HashSet()));
		System.out.println(fill(new HashMap()));

	}
	
	
	
	

}
