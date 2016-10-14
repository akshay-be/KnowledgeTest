package com.indix.parser;

/** Specifies ) Tokens.
 *
 * @author  Akshay BE
 */
class RParen extends Token {

    final int value() {
	return Token.RPAREN;
    }

    public final String toString() {
	return ")";
    }
}
