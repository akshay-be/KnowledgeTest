package com.indix;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;
import java.util.Stack;

import com.indix.ast.Formula;
import com.indix.ast.True;
import com.indix.parser.Parser;

/**
 * The main class for Tautology Checker, For reading and verify the expression
 * for tautology.
 * 
 * @author Akshay BE
 * 
 */
public class TautologyChecker {

	public static void main(String ar[]) throws IOException {

		System.out.println("A Tautology Checker ");
		System.out.println("--------------------");
		System.out.println("Please enter number of expression : ");

		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		String[] data = new String[number];

		System.out.println(number);
		sc.nextLine();
		for (int i = 0; i < number; i++) {
			System.out.print("Pleae enter String : ");
			data[i] = sc.nextLine();
		}
		
		// String data[] = { "(!a | (a & a))", "(!a | (b & !a))",
		// "(!a | a)","( a & ( !b | b)) | ( !a & ( !b |b ))" };

		for (String input : data) {
			if (isBalancedExpression(input)) {
				StringReader reader = new StringReader(input);
				Parser myParser = new Parser(reader);
				Formula formula = myParser.getAST();

				// System.out.println("Formula = " + formula.toString());

				formula = formula.toNnf();
				// System.out.println("toNnf Formula = " + formula.toString());

				// Convert to CNF
				formula = formula.nnfToCnf();
				// System.out.println("to nntoCNF =" + formula.toString());

				// Simplify
				formula = formula.simplifyCnf();
				// System.out.println("simplified =" + formula.toString());

				if (True.VALUE == formula)
					System.out.println(input + " Tautology");
				else
					System.out.println(input + " not Tautology");
			} else {
				System.out.println(input + " invalid Expression.");
			}

			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		}
		sc.nextLine();
		String done = sc.nextLine();
		sc.close();
	}

	private static boolean isBalancedExpression(String input) {
		if(input.contains("{") || input.contains("}") || input.contains("[") || input.contains("]")){
			return false;
		}else if(input.contains("(") || input.contains(")")){
			Stack<Character> stack = new Stack<Character>();
			for (int i = 0; i < input.length(); i++) {
				Character ch = input.charAt(i);
				if(ch=='('){
					stack.push(ch);
				}else if(ch==')'){
					if(stack.isEmpty()){
						return false;
					}else{
						stack.pop();
					}
				}
			}
			return stack.isEmpty();
		}else{
			return true;
		}
	}
}
