package com.akshay.java.c11;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FindDate {

	public static void main(String[] args) {
		String str = "aaaa435adddd12132017kfkfk4343fkf21152017kf";
		String format = "ddMMyyyy";
		String tempStr = "";
		int len = str.length();
		int flen = format.length();
		for(int i = 0; i<len-flen;i++){
			tempStr = str.substring(i,i+flen);
			if(checkNumber(tempStr)){
				if(checkDate(tempStr,format))
					System.out.println("date : "+tempStr);
			}
		}
		//System.out.println(tempStr);
	}
	
	public static boolean checkNumber(String strNumber){
		try{
			long number = Long.parseLong(strNumber);
			//System.out.println("checkNumber "+strNumber);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
	public static boolean checkDate(String strDate, String format){
		try{
			DateFormat df = new SimpleDateFormat(format);
			df.setLenient(false);
			Date date;
			date =  df.parse(strDate);
			return true;
		}
		catch(Exception e){
			return false;
		}
		
	}
}
