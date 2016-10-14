package com.indix.parser;

import java.io.IOException;
import java.io.StringReader;
import java.util.Stack;

import com.indix.ast.AND;
import com.indix.ast.Formula;
import com.indix.ast.NOT;
import com.indix.ast.OR;
import com.indix.ast.Variable;

/**
 * Parses Tokens, representing keywords and values in the input language into an
 * abstract syntax tree, or Formula.
 * 
 */
public class Parser {
	private static Lexer lexer;
	private static Token token = new Dollar();

	private static Formula absyn = null;

	private static Stack<Object> op_stack = new Stack<Object>();
	private static Stack<Object> val_stack = new Stack<Object>();

	private static final int S = 0;
	private static final int R = 1;

	private static final int E1 = 2;

	private static final int E2 = 3;

	private static final int E3 = 4;

	private static final int E4 = 5;

	/**
	 * Operator-precedence table.
	 * 
	 * S stands for shift, R for reduce and E for errors. in parse()
	 */
	private static final int[][] o_p_table = {
	/* ----------------------input token--------------------- */
	/* -op_stk-    |, &, !, (, ), Val Val Val $ */
	/* ----------------------input token--------------------- */
	/* OR */	 { R, S, S, S, R, S, S, S, R },
	/* AND */	 { R, R, S, S, R, S, S, S, R },
	/* NOT */	 { R, R, S, S, R, S, S, S, R },
	/* ( */		 { S, S, S, S, S, S, S, S, E1 },
	/* ) */		 { R, R, R, E4, R, S, S, S, R },
	/*         */{ /* Vals aren't held on the op_stack but */},
	/*         */{ /* blank lines here mean we can look up */},
	/*         */{ /* Token.DOLLAR tokens correctly. */},
	/* $ */{ S, S, S, S, E2, S, S, S, E3 }, };

	public Parser(StringReader input) throws IOException {
		lexer = new Lexer(input);
		op_stack.push(new Dollar());
		absyn = parse();
	}

	public Formula getAST() {
		return absyn;
	}

	public Formula parse() throws IOException {

		token = lexer.lex();

		while (true) {
			// Check if we should accept the sentence.
			if (token.value() == Token.DOLLAR
					&& ((Token) op_stack.peek()).value() == Token.DOLLAR) {

				return (Formula) val_stack.pop();

			}

			switch (o_p_table[((Token) op_stack.peek()).value()][token.value()]) {
			case S:
				shift();
				token = lexer.lex();
				break;
			case R:
				reduce();
				break;
			default:
				break;
			}

		}

	}

	public void shift() {

		// Input token is a value (True, False or Atom).
		if (token instanceof Val) {
			if (token.value() == Token.ATOM) {
				val_stack.push(new Variable(((Atom) token).literal));
			}
		} else {
			// Input token is an operator (Conj, Disj, Not, (, ), $).
			op_stack.push(token);
		}

		return;
	}

	public void reduce() {

		switch (((Token) op_stack.pop()).value()) {
		case Token.NEG:
			val_stack.push(new NOT((Formula) val_stack.pop()));
			break;
		case Token.RPAREN:
			op_stack.pop(); // Pop an LParen
			break;
		case Token.CONJ: {
			Formula temp = (Formula) val_stack.pop();
			val_stack.push(new AND((Formula) val_stack.pop(), temp));
		}
			break;
		case Token.DISJ: {
			Formula temp = (Formula) val_stack.pop();
			val_stack.push(new OR((Formula) val_stack.pop(), temp));

		}
		default:
			break;
		}

		return;
	}
}
