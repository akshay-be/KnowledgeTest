package com.akshay.java.c11;

import java.util.List;
import java.util.ArrayList;
public class WorksAnyway {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	List mice = new ArrayList();
	for(int i=0;i<3;i++)
		mice.add(new Mouse(i));
	
	for(int i=0;i<mice.size();i++){
		System.out.println("Free Mouse "+mice.get(i));
		MouseTrap.caughtYa(mice.get(i));
	}
		

	}

}
