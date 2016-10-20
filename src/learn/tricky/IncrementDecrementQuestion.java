package learn.tricky;


public class IncrementDecrementQuestion {
	public static void main(String[] args) {
		IncrementB b = new IncrementB();

		System.out.println(b.i);

	}
}

class IncrementA
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
 
class IncrementB extends IncrementA
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
 

