package com.akshay.spring.learn;

public class BassDrum implements Instrument {

	public BassDrum() {
		System.out.println("BassDrum no argument sconstructor....!");
	}

	@Override
	public void play() {
		System.out.println("Playing BassDrum..... bbbbbbbbbbbbbbbbbbbb..");
		
	}

	@Override
	public String toString() {
		return "BassDrum ";
	}
}
