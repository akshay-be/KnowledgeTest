package plus;

public class Constractors {
	
	
	
	public Constractors(float f){
		System.out.println("float");
	}
	
	public Constractors(double d){
		System.out.println("double");
	}

	public Constractors(long d){
		System.out.println("long");
	}
	
	public Constractors(int d){
		System.out.println("int");
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Constractors c1 = new Constractors(10);

	}

}
