package com.akshay.spring.learn;

/**
 * 
 * @author akshay
 *
 */
public class Instrumentalist implements Performer {

	private String name;
	private Instrument instrument;

	public Instrumentalist(String name) {
		this.name = name;
		System.out.println("Instrumentalist parameterized constructor....!"+name);
	}

		
	public void perform() {
		System.out.println(" i am Instrumentalist with name "+name+" to perform "+instrument);
		instrument.play();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
		System.out.println("Instrumentalist setInstrument method....!"+instrument);
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((instrument == null) ? 0 : instrument.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrumentalist other = (Instrumentalist) obj;
		if (instrument == null) {
			if (other.instrument != null)
				return false;
		} else if (!instrument.equals(other.instrument))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Instrumentalist [name=" + name + ", instrument=" + instrument
				+ "]";
	}

	
}
