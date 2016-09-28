package com.indix.parser;

/** Specifies ( Tokens.
 *
 * @author  Akshay BE
 * @version 1.0
 */
class LParen extends Token {

    final int value() {
	return Token.LPAREN;
    }

    public final String toString() {
	return "(";
    }
}
