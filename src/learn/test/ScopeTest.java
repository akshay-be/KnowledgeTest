package learn.test;

public class ScopeTest extends AB{

	public static void main(String args[]){
		ABC abc = new ABC();
		abc.showABC();
		System.out.println(""+abc.i);
	}
	
	void showABC(){
		System.out.println(""+i);
	}
}


class A {
	protected int i=10;
}

class AB extends A{
	
	void show(){
		System.out.println(""+i);
	}
}

class ABC extends AB{
	void showABC(){
		System.out.println(""+i);
	}
}

