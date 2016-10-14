package com.indix.parser;

/**
 * Specifies true Tokens.
 * 
 * @author Akshay BE
 */
class True extends Val {

	final int value() {
		return Token.TRUE;
	}

	public final String toString() {
		return "TRUE";
	}
}
