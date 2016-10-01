package plus;

public class IntegetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer integer =34;
		int i = 34;
		
		if(integer.equals(i)){
			System.out.println(true);
		}else{
			System.out.println(false);
		}
		
		String s = "1";
		
		if(s.equals(1)){
			System.out.println("String equal");
		}
		
		TestStudent testStudent = new TestStudent();
		if(testStudent.equals(1)){
			System.out.println("Test student true");
		}else{
			System.out.println("Test student false");
		}
		
		testStudent.doSomethingNonSence(2);
		
	}

}

class TestStudent {
	@Override
	public boolean equals(Object obj) {
		System.out.println("inside equal"+obj);
		if(obj instanceof Object){
			System.out.println("intance of object");
		}
		
		if(obj instanceof TestStudent){
			System.out.println("instance of test student");
		}
		
		return super.equals(obj);
	}
	
	public void doSomethingNonSence(Object obj){
		System.out.println(""+obj);
	}
}
