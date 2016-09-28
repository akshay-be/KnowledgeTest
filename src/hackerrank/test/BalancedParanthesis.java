package hackerrank.test;

public class BalancedParanthesis {

	public static void main(String[] args) {
		String input = "";
		while(input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
		    System.out.println(input.isEmpty());
	}
}
