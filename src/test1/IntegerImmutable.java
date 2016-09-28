package test1;

import java.math.BigDecimal;

public class IntegerImmutable {

	public static void main(String[] args) {
		/*Integer in = new Integer(50);
		in.reverse(in);
		System.out.println(in);*/
		
		BigDecimal bd = new BigDecimal(100);
		bd.add(new BigDecimal(20));
		System.out.println(bd);

	}

}
