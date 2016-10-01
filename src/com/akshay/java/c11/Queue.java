package com.akshay.java.c11;

import java.util.LinkedList;
public class Queue {

	private LinkedList list = new LinkedList();

	public void put(Object obj){
		list.addFirst(obj);
	}
	public Object get(){
		return list.removeLast();
	}
	public boolean isEmpty(){
		return list.isEmpty();
	}
	public String toString(){
		return list.toString();
	}
	
	public static void main(String[] args) {
		Queue queue= new Queue();
		
		for(int i=0;i<5;i++){
			queue.put(Integer.toString(i));
		}
		System.out.println("Queue : "+queue);
		
		while(!queue.isEmpty()){
			System.out.println(queue.get());
		}
	}

}
