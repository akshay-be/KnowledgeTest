package com.akshay.spring.learn;

/**
 * 
 * @author akshay
 *
 */
public class Guitar implements Instrument {

	
	public Guitar() {
		System.out.println("Guitar no argument sconstructor....!");
	}

	@Override
	public void play() {
		System.out.println("Playing guiter..... Strum strum strum...");

	}

	@Override
	public String toString() {
		return "Guiter";
	}

	
	
}
