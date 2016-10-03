package hackerrank.java;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputMismatchExceptionTest {
	public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		
		
		Scanner sc = new Scanner(System.in);
       try{
            int numer =  sc.nextInt();
            int denomr =  sc.nextInt();
    	  // sc.nextInt();
            
           
           //System.out.println(""+numer);
           //System.out.println(""+denomr);
           
           int result = numer/denomr;
           
           System.out.println(""+result);
            
        }catch(InputMismatchException e){
        	String str = e.toString();
        	if(str.contains(":")){
        		System.out.println(""+str.substring(0,str.indexOf(":"))); 
        	}else {
        		System.out.println(""+str);
        	}
        }catch(ArithmeticException e){
           System.out.println(""+e); 
       }
    }
	
	public static void power(int n , int p) {
		System.out.println(Math.pow(2, 3));
		
	}
	
}
