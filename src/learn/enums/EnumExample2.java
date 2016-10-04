package learn.enums;

public class EnumExample2 {
	
	enum Season {
		WINTER(5),SPRING(12);
		int value;
		//String str;
		private Season(int i){
			this.value=i;
		}
		Season(int i,String str){
			
		}
		

	}
	
	/*enum Season1 implements Season {

	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
