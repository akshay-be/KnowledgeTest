package com.wissen;

import java.util.ArrayList;

public class Q14ArrayListTest {

	public static void main(String[] args) {
		ArrayList obj = new ArrayList();
		obj.add("A");
		obj.add("D");
		obj.ensureCapacity(3);
		obj.trimToSize();
		
		System.out.println(obj.size());

	}

}
