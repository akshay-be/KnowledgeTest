package com.akshay.spring.learn;

public class Violin implements Instrument {

	public Violin() {
		System.out.println("Violin no argument sconstructor....!");
	}

	@Override
	public void play() {
		System.out.println("Playing Violin..... vvvvvvvvvvvvvvvv..");
		
	}

	@Override
	public String toString() {
		return "Violin ";
	}
}
