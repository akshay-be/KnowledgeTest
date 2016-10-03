package hackerrank.java;

import java.util.Stack;

public class BalancedParanthesis {

	public static void main(String[] args) {
		String input = "";
		while(input.length() != (input = input.replaceAll("\\(\\)|\\[\\]|\\{\\}", "")).length());
		    System.out.println(input.isEmpty());
	}
	
	/**
	 * Using stack implementation.
	 * @param expression
	 * @return
	 */
	public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<Character>();
        for(int i=0;i<expression.length();i++){
            char ch = expression.charAt(i);
            if(ch=='(' || ch=='{' || ch=='['){
                stack.push(ch);
            }else {
                if(stack.size()==0){
                    return false;
                }else{
                    
                    char ch2 = stack.pop();
                     if(ch==')'){
                        if(ch2!='(') 
                            return false;
                     }else if(ch=='}'){
                         if(ch2!='{') 
                             return false;
                     }else if(ch==']'){
                        if(ch2!='[') 
                            return false;
                     }
            }
        
        }
        
     }
        if(stack.size()==0) 
            return true;
        else return false;
    }
}
