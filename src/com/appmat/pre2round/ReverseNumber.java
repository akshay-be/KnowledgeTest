package com.appmat.pre2round;

public class ReverseNumber {

	public static void main(String[] args) {
		long number = 123456789l;
		long reverse = 0;
		
		while(number!=0){
			reverse = reverse*10;
			reverse = reverse + number%10;
			number= number/10;
		}
		System.out.println("Number : "+number+", Reverse : "+reverse);
	}

}
