package learn.others;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class BigDecimalDemo {

	public static void main(String[] args) {
		 // create 3 BigDecimal objects
		BigDecimal bg1, bg2, bg3;

		bg1 = new BigDecimal("9.75");
		bg2 = new BigDecimal("1.99");
		
		bg1 = bg1.add(bg2);
		bg3 = bg1.divide(new BigDecimal("6"),2,RoundingMode.CEILING);

		// divide bg1 with bg2 with 3 scale
		//bg3 = bg1.divide(bg2, 2, RoundingMode.CEILING);

		String str = "Division result is " + bg3;

		// print bg3 value
		System.out.println(str);

	}

}
