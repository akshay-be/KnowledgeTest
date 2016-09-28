package tricky;


public class IncrementDecrementQuestion {
	public static void main(String[] args) {
		B b = new B();

		System.out.println(b.i);

	}
}

class A
{
    static int i = 1111;
 
    static
    {
        i = i-- - --i;
        System.out.println("static A : "+i);
    }
 
    {
        i = i++ + ++i;
        System.out.println("Non static A : "+i);
    }
}
 
class B extends A
{
    static
    {
        i = --i - i--;
        System.out.println("static B : "+i);
    }
 
    {
        i = ++i + i++;
        System.out.println("Non static B : "+i);
    }
}
 

