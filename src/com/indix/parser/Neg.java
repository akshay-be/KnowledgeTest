package com.indix.parser;

/** Specifies NOT Tokens.
 *
 * @author  Akshay BE
 */
class Neg extends Token {

    final int value() {
	return Token.NEG;
    }

    public final String toString() {
	return "NEG";
    }
}
