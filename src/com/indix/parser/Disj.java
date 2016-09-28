package com.indix.parser;

/** Specifies OR Tokens.
 *
 * @author  Akshay BE
 * @version 1.0
 */
class Disj extends Token {

    final int value() {
	return Token.DISJ;
    }

    public final String toString() {
	return "DISJ";
    }
}
