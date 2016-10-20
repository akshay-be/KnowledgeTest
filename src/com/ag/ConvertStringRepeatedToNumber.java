package com.ag;

/**
 * Convert aaabbcdefgggh to a3b2cdefg3h
 * @author AkshayB1
 *
 */
public class ConvertStringRepeatedToNumber {

	public static void main(String[] args) {
		String str1 = "aaabbcdefgggh";
		System.out.println(str1+" : "+convertString(str1));
		
		str1 = "abcdefgh";
		System.out.println(str1 + " : " + convertString(str1));

		str1 = "abcdefghhhhhh";
		System.out.println(str1 + " : " + convertString(str1));

		str1 = "abcdefghhhhhhii";
		System.out.println(str1 + " : " + convertString(str1));

		str1 = "aaaaaaaaaaaabbbbbbbbcccccccccccd";
		System.out.println(str1 + " : " + convertString(str1));

	}
	
	static String convertString(String input){
		String output = "";
		int length = 1;
		char ch1 = input.charAt(0);
		char ch2 = ' ';
		for(int i=1;i<input.length();i++){
			ch2 = input.charAt(i);
			System.out.println(ch2);
			if(ch1 == ch2){
				length++;
			}else{
				if(length>1){
					output = output + "" +ch1+length;
				}else{
					output = output + "" +ch1;
				}
				ch1 = ch2;
				length = 1;
			}
		}
		
		if(length>1){
			output = output + "" +ch1+length;
		}else{
			output = output + "" +ch1;
		}
		
		return output;
	}

}
