package com.akshay.spring.learn;

public class Piaon implements Instrument {

	
	public Piaon() {
		System.out.println("Piaon no argument sconstructor....!");
	}
	@Override
	public void play() {
		System.out.println("Playing piano....! Plink plan pong");

	}

	@Override
	public String toString() {
		return "Piaon";
	}
}
