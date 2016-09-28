package hackerrank.test;

import java.util.Scanner;

public class Stringlexicographically {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        String line = "welcometojava";
	        
	        
	        int size = 3;
	
	        String minString = line.substring(0,size);
	        String maxString = line.substring(0,size);
	        
	        for(int i=1; i < line.length()-size+1; i++){
	            String subString = line.substring(i,i+size);
	            System.out.println("Sub : "+subString);
	            
	            if(subString.compareTo(minString) < 0){
	            	minString = subString;
	            }
	            
	            if(subString.compareTo(maxString) > 0){
	            	maxString = subString;
	            }
	            
	            
	        }
	        System.out.println(minString);
	        System.out.println(maxString);
	        

	}

}
