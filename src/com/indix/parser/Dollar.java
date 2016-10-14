package com.indix.parser;

/** 
 *
 * End of Line. or Statement.
 * @author  Akshay BE
 */
class Dollar extends Token {

    final int value() {
	return Token.DOLLAR;
    }

    public final String toString() {
	return "$";
    }
}
