package com.indix.parser;

import java.io.IOException;
import java.io.StringReader;

/**
 * Converts freeform text into Tokens, which represent keywords of the input
 * language or Atoms.
 * 
 * Keywords:
 * <ul>
 * <li>TT
 * <li>FF
 * <li>(
 * <li>)
 * <li>NOT
 * <li>AND
 * <li>OR
 * </ul>
 * 
 * @author Akshay BE
 * @version 1.0
 * 
 * @see Token
 * @see Parser
 * @see checker.error.LexicalException
 */
class Lexer {
	
	/**
	 * Input reader.
	 * 
	 * @see #Lexer(StringReader input)
	 */
	public  StringReader reader;

	/**
	 * Current character grabbed from the reader.
	 * 
	 * @see #advance()
	 */
	private char lex_char;

	/**
	 * Text of the current token.
	 * 
	 * Will be converted into a checker.parser.Token. by textToToken.
	 * 
	 * @see #lex()
	 * @see #textToToken()
	 */
	private String lex_text = null;

	/**
	 * true if reader is at the beginning of it's input, false otherwise.
	 * 
	 * Set by lex().
	 * 
	 * @see #lex()
	 */
	private boolean lex_start = true;

	/**
	 * true if reader has reached the end of it's input, false otherwise.
	 * 
	 * Set by advance().
	 * 
	 * @see #advance()
	 */
	private boolean isEol = false;

	/**
	 * Constructs a new Lexer with StringReader containing characters to be lexed
	 * into Tokens.
	 * 
	 * @param input
	 *            the InputStream to be lexed.
	 * 
	 * @see java.io.StringReader
	 */
	Lexer(StringReader str) {
		reader = str;
		lex_start = true;
		isEol = false;
	}

	/**
	 * Gets the next character from reader.
	 * 
	 * There is no easy way to detect whether the reader has reached the end of
	 * its input, so we test whether the next int that's read can be converted
	 * to a char and use that to set the isEof attribute.
	 * 
	 * @exception IOException
	 *                if there's a problem with the reader.
	 * 
	 * @see #isEof
	 * @see #lex_char
	 * @see #lex()
	 */
	private final void advance() throws IOException {
		int next_char = reader.read();
		if (next_char == -1) {
			isEol = true;
            		return;
 		}
		lex_char = (char)next_char;
		return;
	}

	/**
	 * Lexes the next token from the reader.
	 * 
	 */
	Token lex() throws IOException {
		lex_text = null;

		// If we're at the start of the input stream,
		// advance and reset lex_start.
		if (lex_start) {
			advance();
			lex_start = false;
		}

		// If we're at the end of the input stream, return
		// the Eol Token.
		if (isEol) {
			return new Dollar();
		}

		// Skip whitespace.
		while (Character.isWhitespace(lex_char) && !isEol) {
			advance();
		}

		// Build lex_text.
		if (lex_char == '(') {
			lex_text = "(";
			advance();
		} else if (lex_char == ')') {
			lex_text = ")";
			advance();
		} else if (lex_char == '|') {
			lex_text = "OR";
			advance();
		} else if (lex_char == '&') {
			lex_text = "AND";
			advance();
		} else if (lex_char == '!') {
			lex_text = "NOT";
			advance();
		} else if (Character.isLetter(lex_char)) {
			lex_text = (new Character(lex_char)).toString();
			advance();
		} else if (isEol) { // Catches whitespace immediately before an Eof.
			if (lex_text == null) {
				return new Dollar();
			}
		} else {
			System.out.println("not machting");
		}

		return textToToken();
	}

	/**
	 * Converts lex_text into the corresponding Token.
	 * 
	 * @return Token corresponding to the contents of lex_text.
	 * 
	 * @see #lex_text
	 * @see #lex()
	 * @see Token
	 */
	private final Token textToToken() {

        
		if (lex_text.equals("(")) {
	            return new LParen();
	        } else if (lex_text.equals(")")) {
	            return new RParen();
	        } else if (lex_text.equals("NOT")) {
	            return new Neg();
	        } else if (lex_text.equals("AND")) {
	            return new Conj();
	        } else if (lex_text.equals("OR")) {
	            return new Disj();
	        } else {
	            return new Atom(lex_text);
	        }

	}

}
