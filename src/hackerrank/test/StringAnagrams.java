package hackerrank.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StringAnagrams {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
	}
	
	
	static boolean isAnagram(String a, String b) {
        char[] arrA = a.toLowerCase().toCharArray();
        ArrayList<Character> aList = new ArrayList<Character>();
        for(char c :arrA ){
           aList.add((Character)c); 
        }
        Collections.sort(aList);
        
        char[] arrB = b.toLowerCase().toCharArray();
        ArrayList<Character> bList = new ArrayList<Character>();
        for(char c :arrB ){
           bList.add((Character)c); 
        }
        Collections.sort(bList);
        
        if(aList.equals(bList)){
            return true;
        }else{
            return false;
        }
    }
}
