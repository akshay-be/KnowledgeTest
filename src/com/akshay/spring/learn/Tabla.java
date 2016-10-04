package com.akshay.spring.learn;

public class Tabla implements Instrument {

	public Tabla() {
		System.out.println("Tabla no argument sconstructor....!");
	}
	
	@Override
	public void play() {
		System.out.println("Tabala dhu duk  tab tab....!");

	}

	@Override
	public String toString() {
		return "Tabla";
	}

	
}
