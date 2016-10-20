package learn.others;

import java.util.regex.Pattern;


public class StringSplit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String abc ="FepName.DealerId";
		String[] abcArr = abc.split(Pattern.quote("."));
		
		for(String temp:abcArr){
			System.out.println("HHHHH : "+temp);
		}

	}

}
