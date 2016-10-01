package com.akshay.java.c11;

import java.util.LinkedList;
public class StackL {

	private LinkedList list = new LinkedList();
	
	public void push(Object obj){
		list.addFirst(obj);
	}
	public Object pop(){
		return list.removeFirst();
	}
	public Object top(){
		return list.getFirst();
	}
	public String toString(){
		return list.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StackL st = new StackL();
		/*//java.util.NoSuchElementException
		System.out.println(st.pop());
		System.out.println(st.top());*/
		for(int i=0;i<5;i++)
			st.push(Integer.toString(i));
		System.out.println(st);
		System.out.println(st.top());
		System.out.println(st.pop());
		System.out.println(st.top());

	}

}
