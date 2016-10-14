package com.indix.parser;

/** Specifies AND Tokens.
 *
 * @author  Akshay BE
 */
class Conj extends Token {

    final int value() {
	return Token.CONJ;
    }

    public final String toString() {
	return "CONJ";
    }
}
