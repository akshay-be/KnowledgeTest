package geeksforgeeks.amazon;

import java.util.Stack;

public class BalancedParentheses {

	public static void main(String[] args) {

		String[] expression1 = {"[()]{}{[()()]()}","[(])"};;
		for (String string : expression1) {
			System.out.println(string+" : "+validateExpression(string));
		}
		
	}

	private static boolean validateExpression(String expression) {
		int openBracket = 0, closeBracket=0, openParanthesis = 0,closeParanthesis=0, openSquare=0,closeSquare=0;
		Stack stack = new Stack(); 
		boolean vlaid = true;
		if(expression.contains("(") || expression.contains(")")
				|| expression.contains("{") || expression.contains("}")
				|| expression.contains("[") || expression.contains("]")){
			char[] expressionArray = expression.toCharArray();
			//char[] filteredExpressionArray = new char[expressionArray.length];
			for (char c : expressionArray) {
				if(c=='(') openBracket++;
				else if(c==')') closeBracket++;
				else if(c=='{') openParanthesis++;
				else if(c=='}') closeParanthesis++;
				else if(c=='[') openSquare++;
				else if(c==']') closeSquare++;
			}
			
			
			if(openBracket==closeBracket
					&& openParanthesis==closeParanthesis
					&& openSquare== closeSquare){
				for (char c : expressionArray) {
					if(c=='(' || c=='{' || c=='['){
						stack.push(c);
					}
					else if(c==')' || c=='}' || c==']') {
						char fromStack = (Character) stack.pop();
						if(c==')' && fromStack=='(') continue;
						else if(c=='}' && fromStack=='{') continue;
						else if(c==']' && fromStack=='[') continue;
						else if (c==')' || c=='}' || c==']' ){
							System.out.println("Invalid expression.....");
							vlaid = false;
							
						}
					}
				}
				
			}else{
				System.out.println("Invalid expression No matching");
			}
		}
		return vlaid;
		
	}

	
}
