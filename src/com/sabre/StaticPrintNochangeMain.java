package com.sabre;

public class StaticPrintNochangeMain {

	static {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			
			@Override
			public void run() {
				System.out.println("bye..");
				
			}
		});
		
		 
	}
	public static void main(String[] args) {
		System.out.println("Akshay");
	}

}
