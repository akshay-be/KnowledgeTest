package hackerrank.test;

import java.util.StringTokenizer;

public class StringSplit {

	public static void main(String[] args) {
		
		String readData = "He is a very very good boy, isn't he?";
		usingStringTokenizer(readData);
	}
	

	public static void mySolution(String readData) 
	{
		String[] arrData = readData.split("[!,?._'@ ]");

		int count = 0;
		for (String string : arrData) {
			if (!string.trim().isEmpty()) {
				count++;
			}
		}
		System.out.println(count);
		for (String string : arrData) {
			if (!string.trim().isEmpty()) {
				System.out.println(string);
			}
		}
	}

	public static void usingStringTokenizer(String str) {
		StringTokenizer st = new StringTokenizer(str, "' '!,?._'@");
		System.out.println(st.countTokens());
		while (st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}
}
