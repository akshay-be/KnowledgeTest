package com.indix.parser;

/** Specifies ( Tokens.
 *
 * @author  Akshay BE
 */
class LParen extends Token {

    final int value() {
	return Token.LPAREN;
    }

    public final String toString() {
	return "(";
    }
}
