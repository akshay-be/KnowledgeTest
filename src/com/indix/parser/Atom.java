package com.indix.parser;

/** Specifies atomic Tokens.
 *
 * @author  Akshay BE
 */
class Atom extends Val {

    final String literal;

    final int value() {
	return Token.ATOM;
    }

    Atom(final String literal) {
	this.literal = literal;
    }

    public final String toString() {
	return "Atom(" + this.literal +")";
    }
}
