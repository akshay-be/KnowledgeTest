package test1;

public class ObjectTest {
	Object obj = new Object();
	public static void main(String[] args) throws InterruptedException {
		ObjectTest ob = new ObjectTest();
		ob.myMethod();

	}
	
	void myMethod() throws InterruptedException{
		obj.wait();
		obj.wait();
	}

}
