package interview.am;

public class QuestionException {

	public void m1() throws Exception {
		try{
			m2();
		}finally {
			m3();
		}
	}

	private void m3()  throws RuntimeException{
		throw new RuntimeException();
		
	}

	private void m2() throws Exception{
		throw new Exception();
		
	}
	
	public static void main(String[] args) {
		QuestionException q1 = new QuestionException();
		try{
			q1.m1();
		}catch(RuntimeException re){
			System.out.println("RuntimeException......");
		}catch(Exception e){
			System.out.println("Exception.....");
		}
	}
}
