package learn.others;

import java.math.BigDecimal;
import java.math.MathContext;


public class BigDecimalTest {

	public static void main(String[] args) {
		String cashBackAmount = "10.23";
		BigDecimal d1 = new BigDecimal(cashBackAmount);
		BigDecimal d2 = new BigDecimal(20.23);
		System.out.println(d2);
	}

}
