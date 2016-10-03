package learn.thiskey;

public class TestThisKeyWord {

	public static void main(String[] args) {
		System.out.println("Main starts......");
		Parent p = new Child();
		p.myMethod(5);
		System.out.println("Main finish......");
	}

}

class BigBoss {
	void myMethod() {
		System.out.println("BigBoss - myMethod no arguemt");
	}
}

class Parent extends BigBoss {
	void myMethod(int i) {
		System.out.println("Parent - myMethod int");
		super.myMethod(); // Always Parent will be called..
		this.myMethod(); // If child class overridden method then that will be called.
	}

	void myMethod() {
		System.out.println("Parent - myMethod no arguemt");
	}
}

class Child extends Parent {
	void myMethod() {
		System.out.println("Child - myMethod no arguemt");
	}
}
