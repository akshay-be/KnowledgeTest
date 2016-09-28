
public class TryCatchFinally {

	int x=0;
	public static void main(String[] args) {
		
		TryCatchFinally try1 = new TryCatchFinally();
		int value = try1.testReturnValue();
		System.out.println("Value : "+value);
		System.out.println("X : "+try1.x);
		System.out.println("Static : "+TryCatchFinally.testReturnValue1());
	}

	public int testReturnValue(){
		
		try{
			x=2;
			return 2;
		}catch(Exception e){
			x=3;
			return 3;
			
		}finally{
			x=4;
			return 4;
		}
	}
	
	public  static int testReturnValue1(){
		try{
			
			return 2;
		}catch(Exception e){
			return 3;
			
		}finally{
			return 4;
		}
	}
}
