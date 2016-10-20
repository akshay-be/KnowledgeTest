package learn.others;
public class OddEven {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int i=0;i<1000000000;i++){
			if(i%2==0){
				System.out.println("Even : "+i);
			}
			else{
				System.out.println("Odd : "+i);
			}
		}

	}

}
