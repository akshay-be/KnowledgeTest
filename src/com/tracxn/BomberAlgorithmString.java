package com.tracxn;

public class BomberAlgorithmString {

	public static void main(String[] args) {
		String str1 = "aaabbcdefgggh";
		System.out.println(str1+" : "+convertString(str1));

	}

	
	static String convertString(String input){
		String output = "";
		int length = 1;
		char ch1 = input.charAt(0);
		char ch2 = ' ';
		int start = 0;
		for(int i=1;i<input.length();i++){
			ch2 = input.charAt(i);
			System.out.println(ch2+" : "+length);
			if(ch1 == ch2){
				length++;
			}else{
				if(length>1){
					System.out.println(i+" : "+length);
					output = output.substring(0,start) + "" +output.substring(start+length);
					i--;
				}
				ch1 = ch2;
				length = 1;
				start = i;
			}
		}
		
		//System.out.println(output);
		
		return output;
	}
}
