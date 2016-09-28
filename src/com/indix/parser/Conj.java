package com.indix.parser;

/** Specifies AND Tokens.
 *
 * @author  Akshay BE
 * @version 1.0
 */
class Conj extends Token {

    final int value() {
	return Token.CONJ;
    }

    public final String toString() {
	return "CONJ";
    }
}
