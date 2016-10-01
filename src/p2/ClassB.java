package p2;

import p1.ClassA;

public class ClassB extends ClassA {

	public static void main(String[] args) {
		ClassB classA = new ClassB();
		classA.doNothing();
	}

	public void doNothing(){
		disp();
	}
}
