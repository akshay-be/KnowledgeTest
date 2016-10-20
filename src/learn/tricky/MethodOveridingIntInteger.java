package learn.tricky;


class A
{
    void method(int i)
    {
        //method(int)
    }
    
    void method(float i)
    {
        //method(Integer)
    	System.out.println("A--Primtive float");
    }
    /** we can have method for wrapper and primitive arguments. */
    void method(Float i)
    {
        //method(Integer)
    	System.out.println("A--Warraper float");
    }
}
 
class B extends A
{
    @Override
    void method(Integer i)
    {
        //method(Integer)
    }
    
	void method(Float i)
    {
        //method(Integer)
    	System.out.println("B--Warraper float");
    }
}

public class MethodOveridingIntInteger {

	public static void main(String[] args) {
		B b = new B();
		b.method(3.2f);
		b.method(new Float(3.2f));
	}
}
