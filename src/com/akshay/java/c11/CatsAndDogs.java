package com.akshay.java.c11;

import java.util.ArrayList;
import java.util.List;

public class CatsAndDogs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List cats = new ArrayList();
		
		for(int i=0;i<7;i++)
			cats.add(new Cat(i));
		//cats.add(new Dog(1));
		
		for(int i=0;i<cats.size();i++)
			((Cat)cats.get(i)).id();

		List<Cat> cats1 = new ArrayList();
		for(int i=0;i<7;i++)
			cats1.add(new Cat(i));
		
		//cats1.add(new Dog(1));
		
		for(int i=0;i<cats.size();i++)
			cats1.get(i).id();
		
		
		List cats2 = new ArrayList<Cat>();
		for(int i=0;i<7;i++)
			cats2.add(new Cat(i));
		
		cats2.add(new Dog(1));
		
		for(int i=0;i<cats.size();i++){
		//	cats2.get(i).id();
		}
	}

}
