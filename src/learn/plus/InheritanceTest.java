package learn.plus;

class SuperInheritance {
	public void display(){
		System.out.println("SuperInheritance-->display");
		display2();
	}
	protected void display2(){
		System.out.println("SuperInheritance-->display2");
	}
}

class SubInheritance extends SuperInheritance {
	/*public void display(){
		System.out.println("SubInheritance-->display");
	}*/
	
	public void display2(){
		System.out.println("SubInheritance-->display2");
	}
}


public class InheritanceTest {
	public static void main(String[] args) {
		String _name;
		String $$$$;
		System.out.println("Hello //Test hi");
		SuperInheritance superInheritance = new SubInheritance();
		superInheritance.display();
		
		
		/*SubInheritance subInheritance = new SubInheritance();
		subInheritance.display();
		subInheritance.display2();*/
	}
}
