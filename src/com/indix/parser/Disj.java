package com.indix.parser;

/** Specifies OR Tokens.
 *
 * @author  Akshay BE
 */
class Disj extends Token {

    final int value() {
	return Token.DISJ;
    }

    public final String toString() {
	return "DISJ";
    }
}
