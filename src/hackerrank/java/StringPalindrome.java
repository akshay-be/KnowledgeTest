package hackerrank.java;

import java.util.Scanner;
public class StringPalindrome {

	public static void main(String[] args) {
		
		System.out.println("Please enter String :");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		
		int length = input.length();
		System.out.println("L : "+length);
		boolean palindrome = true;
		for(int i=0;i<length/2;i++){
			System.out.println(i);
			if(input.charAt(i) != input.charAt(length-i-1)){
				palindrome = false;
				break;
			}
		}
		
		if(palindrome){
			System.out.println("Yes");
		}else{
			System.out.println("No");
		}
		
		
		System.out.println("done");
	}
}
