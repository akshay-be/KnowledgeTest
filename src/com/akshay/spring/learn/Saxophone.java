package com.akshay.spring.learn;

public class Saxophone implements Instrument {

	public Saxophone() {
		System.out.println("Saxophone no argument sconstructor....!");
	}

	@Override
	public void play() {
		System.out.println("Playing Saxophone..... bbbbbbbbbbbbbbbbbbbb..");
		
	}

	@Override
	public String toString() {
		return "Saxophone ";
	}
}
