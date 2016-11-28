package learn;

import java.security.SecureRandom;

public class TestSecureRandom {

	public static void main(String[] args) {
		SecureRandom secure = new SecureRandom();
				
		for(int i=0;i<10000000;i++ ){
			int num = Math.abs(secure.nextInt());
			if(num<9999)
				System.out.println(num);
		}
		
		System.out.println("Done");
	}

}
