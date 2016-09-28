package com.indix.parser;

/** Specifies ) Tokens.
 *
 * @author  Akshay BE
 * @version 1.0
 */
class RParen extends Token {

    final int value() {
	return Token.RPAREN;
    }

    public final String toString() {
	return ")";
    }
}
