package com.wissen;

import java.util.ArrayList;
import java.util.Vector;

public class Q18ArrayListTest {

	public static void main1(String[] args) {
		ArrayList obj = new ArrayList(4);
		obj.addElement(new Integer(0));
		obj.addElement(new Integer(40));
		obj.addElement(new Integer(0));
		obj.removeAll(obj);
		System.out.println(obj.isEmpty());
	}

	public static void main(String[] args) {
		Vector obj = new Vector(4);
		obj.addElement(new Integer(0));
		obj.addElement(new Integer(40));
		obj.addElement(new Integer(0));
		obj.removeAll(obj);
		System.out.println(obj.isEmpty());

	}
}
