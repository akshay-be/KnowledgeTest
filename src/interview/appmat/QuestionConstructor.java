package interview.appmat;

class A {
	public A(){}
	public A(int i){ this(); }
}

class B extends A {
	public boolean B(String msg) { return false; }
}

class C extends B {
	private C() { super(); }
	private C(String msg) { this(); }
	public C(int i) {}
} 

/**
 * Which statements are true about the above code
 1. The code will fail to compile.
 2. The constructor in A that takes an int as an argument will 
 	never be called as a result of constructing an object or class B or C.
 3. Class C defines three constructors.
 4. Objects of class B cannot be constructed.
 5. At most one of the constructors of each class is called as a result
  	of constructing an object of C
 
 */
public class QuestionConstructor {

}
