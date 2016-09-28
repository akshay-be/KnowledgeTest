package hackerrank.algorithm.warmup;

import java.util.Arrays;
import java.util.Scanner;

public class TimeConversionProblem {

	public static void main(String[] args) {
		 	Scanner scan = new Scanner(System.in);
	        String input = scan.nextLine();
			//String input = "12:00:00PM";
	        if(input.contains("PM")){
	        	if(!input.startsWith("12")){
		        	int hour = Integer.parseInt(input.substring(0,input.indexOf(":")));
		            hour = hour+12;
		            String print = ""+hour;
		            if(hour>=24){
		            	hour-=24;
		            }
		            if(hour<10){
		            	print = "0"+print;
		            }else{
		            	print = ""+hour;
		            }
		            System.out.println(hour+""+input.substring(input.indexOf(":"),input.indexOf("PM")));
	        	}else{
	        		System.out.println(input.substring(0,input.indexOf("PM"))); 
	        	}
	        }else{
	        	if(input.startsWith("12")){
	        		input = "00"+input.substring(2);
	        	}
	           System.out.println(input.substring(0,input.indexOf("AM"))); 
	        }

	}

	public static void main1(String[] args) {
		Scanner sc = new Scanner(System.in);
	    String in = sc.next();
	   // String in = "12:00:00AM";
	    char[] inChar = in.toCharArray();
	    char[] out = Arrays.copyOfRange(inChar, 0, 8);
	    if(inChar[8] == 'A' && in.substring(0,2) == "12") {
	        out[0] = 0;
	        out[1] = 0;
	    }
	    else if(inChar[8] =='P' && in.substring(0,2) != "12") {
	        String s = "" + (Integer.parseInt(in.substring(0,2)) + 12);
	        char[] f = s.toCharArray();
	        out[0] = f[0];
	        out[1] = f[1];
	    }
	    System.out.println(out);
	}
}
