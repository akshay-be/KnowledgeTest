package com.akshay.java.c11;

public class Mouse {
	private int mouseNumber;
	
	public Mouse(int i){
		mouseNumber=i;
	}
	
	public String toString(){
		return "This is Mouse #"+mouseNumber;
	}

	public int getNumber(){
		return mouseNumber;
	}
}
