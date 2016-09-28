package com.indix.parser;

/** Superclass for Tokens, which are returned by the
 * Lexer and parsed into Formulas by the 
 * Parser.
 *
 * @author  Akshay BE
 * @version 1.0
 *
 */
abstract public class Token {

	static final int DOLLAR = 8;
	static final int ATOM   = 7;
	static final int FALSE  = 6;
	static final int TRUE   = 5;
	static final int RPAREN = 4;
	static final int LPAREN = 3;
	static final int NEG    = 2;
	static final int CONJ   = 1;
	static final int DISJ   = 0;
    
    /** Return a non-negative integer, unique to each subtype of 
     * Token.
     *
     * This is used in the Parser to switch between 
     * tokens of different type and to lookup the appropriate shift / 
     * reduce action in the operator-precedence table.
     *
     * The return value should be one of the static
     * final attributes of Token.
     * 
     * @return a non-negative integer, unique to each subtype of 
     *         Token.
     *
     */
    abstract int value();

    /** Return a String representing the object type, so that
     * the Lexer and Parser can print meaningful 
     * debugging information.
     *
     * @return a string representing the object type.
     *
     * @see    checker.Checker#PARSE_DEBUG
     * @see    checker.parser.Lexer
     * @see    checker.parser.Parser
     */
    abstract public String toString();
}
