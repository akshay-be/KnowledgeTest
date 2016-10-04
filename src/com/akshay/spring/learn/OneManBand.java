package com.akshay.spring.learn;

import java.util.List;

/**
 * 
 * @author akshay
 *
 */
public class OneManBand extends Instrumentalist {
	
	private List<Instrument> instruments;
	
	public OneManBand(String name){
		super(name);
		System.out.println("OneManBand parameter constructor with name : "+name);
	}

	public List<Instrument> getInstruments() {
		return instruments;
	}

	public void setInstruments(List<Instrument> instruments) {
		this.instruments = instruments;
		System.out.println("OneManBand setInstrumentse with instruments "+instruments);
	}
	
	@Override
	public void perform() {
		super.perform();
		for (Instrument instrument : instruments) {
			instrument.play();
		}
		
	}

	@Override
	public String toString() {
		return "OneManBand [instruments=" + instruments + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((instruments == null) ? 0 : instruments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		OneManBand other = (OneManBand) obj;
		if (instruments == null) {
			if (other.instruments != null)
				return false;
		} else if (!instruments.equals(other.instruments))
			return false;
		return true;
	}
	

}
