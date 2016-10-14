package com.indix.parser;

/** Specifies False Tokens.
 *
 * @author  Akshay BE
 */
class False extends Val {

    final int value() {
	return Token.FALSE;
    }

    public final String toString() {
	return "FALSE";
    }
}
