package test;

class StaticTest {

	public static void main(String[] args) {
		System.out.println("B  : ");

	}

}

class B{
	public final int i=9;
	
	static{
		
		System.out.println("static ");
	}
	
	{
		System.out.println("instance");
	}
}
