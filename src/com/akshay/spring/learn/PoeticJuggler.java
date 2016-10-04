package com.akshay.spring.learn;

public class PoeticJuggler extends Juggler {

	Poem poem;

	public PoeticJuggler(int n) {
		super(n);
		System.out.println("PoeticJuggler int argument constructer...");
	}
	public PoeticJuggler(int n, Poem p) {
		super(n);
		this.poem = p;
		System.out.println("PoeticJuggler int, poem argument constructer...");
	}
	
	public void perform(){
		System.out.println("i am poetic juggler...");
		super.perform();
		poem.recite();
	}

	public Poem getPoem() {
		return poem;
	}

	public void setPoem(Poem poem) {
		this.poem = poem;
	}

	@Override
	public String toString() {
		return "PoeticJuggler [poem=" + poem + "]";
	}
	
	

}
