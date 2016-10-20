package learn.biscute;

public class OverLoadingTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		OverLoadingTest overLoadingTest = new OverLoadingTest();
		//overLoadingTest.doUselessWork(null);
		overLoadingTest.doUselessWork(new Object());
		overLoadingTest.doUselessWork(new String());
	}
	
	public void doUselessWork(Object obj){
		System.out.println("Object");
	}
	
	public void doUselessWork(String obj){
		System.out.println("String");
	}
	
	public void doUselessWork(StringBuffer obj){
		System.out.println("String");
	}
	
	/*public void doUselessWork(AkshayUseless obj){
		System.out.println("AkshayUseless");
	}
	
	public void doUselessWork(AkshayUseless2 obj){
		System.out.println("AkshayUseless2");
	}*/

}

class AkshayUseless {
	
}

class AkshayUseless2 extends AkshayUseless {
	
}
