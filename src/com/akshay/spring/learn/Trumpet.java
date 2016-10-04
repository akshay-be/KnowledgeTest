package com.akshay.spring.learn;

public class Trumpet implements Instrument {

	
	public Trumpet() {
		System.out.println("Trumpet no argument sconstructor....!");
	}

	@Override
	public void play() {
		System.out.println("Playing Trumpet..... Ttrum trum trum...");
		
	}

	@Override
	public String toString() {
		return "Trumpet ";
	}

	
}
