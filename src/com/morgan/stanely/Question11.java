package com.morgan.stanely;


class A {
	void doIt(){
		System.out.println(" Inside A");
	}
}

class B extends A{
	void doIt(){
		System.out.println(" Inside B");
	}
}

class C extends B {
	void doIt(){
		System.out.println(" Inside C");
		//doIt();
		//super.doIt();
		//A.this.doIt();
		//super.super.doIt();
		//this.super.doIt();
		//((A) this).doIt();
	}
}

public class Question11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		C c = new C();
		c.doIt();

	}

}
