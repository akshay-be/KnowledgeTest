package com.indix.tictaco.game;

/**
 * 
 * @author Akshay
 *
 */
public class Block {

	private boolean state;
	final private int i;
	final private int j;
	private String name;

	public Block(int i, int j) {
		this.state = false;
		this.i = i;
		this.j = j;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getI() {
		return i;
	}

	public int getJ() {
		return j;
	}

}
