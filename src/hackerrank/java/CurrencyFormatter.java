package hackerrank.java;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrencyFormatter {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        double payment = scanner.nextDouble();
	        scanner.close();
	        
	        NumberFormat usd = NumberFormat.getCurrencyInstance(Locale.US);
	        System.out.println("US format = "+usd.format(payment));
	        
	        NumberFormat inr = NumberFormat.getCurrencyInstance(new Locale("en", "in"));
	        System.out.println("India format = "+inr.format(payment));
	    }
}
