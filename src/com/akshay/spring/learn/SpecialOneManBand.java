package com.akshay.spring.learn;

import java.util.Set;

/**
 * 
 * @author AkshayB1
 *
 */
public class SpecialOneManBand extends Instrumentalist {

	Set<Instrument> instruments;
	
	public SpecialOneManBand(String name){
		super(name);
		System.out.println("SpecialOneManBand with one arument constructor..");
	}

	public Set<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(Set<Instrument> instruments) {
		this.instruments = instruments;
		System.out.println("SpecialOneManBad setInstruments "+instruments);
	}
	
	
	@Override
	public void perform() {
		super.perform();
		for (Instrument instrument : instruments) {
			instrument.play();
		}
		
	}
}
