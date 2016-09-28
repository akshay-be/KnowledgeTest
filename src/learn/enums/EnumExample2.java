package learn.enums;

public class EnumExample2 {
	
	enum Season {
		WINTER(5),SPRING(12);
		
		//int value;
		//String str;
		Season(int i){
			
		}
		Season(int i,String str){
			
		}
		
		abstract void myMethod();
	}
	
	enum Season1 implements Season{
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
