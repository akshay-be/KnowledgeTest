package hackerrank.test;

import java.math.BigInteger;
import java.util.Scanner;

public class BigIntegerTest {

	
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        
        BigInteger  b1 = new BigInteger(str1);
        BigInteger  b2 = new BigInteger(str2);
        
        System.out.println(""+b1.add(b2));
        System.out.println(""+b1.multiply(b2));
    }
}
