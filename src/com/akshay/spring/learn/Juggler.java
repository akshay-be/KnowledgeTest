package com.akshay.spring.learn;

public class Juggler implements Performer {
	
	private int numOfRings = 3;

	@Override
	public void perform() {
		System.out.println("Juggler juggling "+numOfRings+" rings");
	}

	public Juggler() {
		System.out.println("Juggler no argument constructor...");
	}

	public Juggler(int numOfRings) {
		this.numOfRings = numOfRings;
		System.out.println("Juggler int argumented constructor...");
	}

	public void setNumOfRings(int numOfRings) {
		this.numOfRings = numOfRings;
		System.out.println("Juggler set number of rings method..");
	}
	
}
