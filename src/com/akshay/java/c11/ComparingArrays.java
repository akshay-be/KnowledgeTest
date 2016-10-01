package com.akshay.java.c11;

import java.util.Arrays;

public class ComparingArrays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a1=new int[10];
		int[] a2=new int[10];
		Arrays.fill(a1, 47);
		Arrays.fill(a2,47);
		System.out.println(Arrays.equals(a1, a2));
		a1[3]=15;
		System.out.println(Arrays.equals(a1, a2));
		
		String[] s1= new String[5];
		Arrays.fill(s1, "hi");
		String[] s2 = {"hi","hi","hi","hi","hi"};
		System.out.println(Arrays.equals(s1, s2));

	}

}
