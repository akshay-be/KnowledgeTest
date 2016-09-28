package com.indix.ast;

/**
 * Specifies the FF Literal.
 * 
 * @author Akshay BE
 * @version 1.0
 */
public final class False extends Literal {

	/**
	 * The only instantiation of this class.
	 * 
	 * VALUE enables us to test a Formula for falsehood using the double-equals
	 * operator. For example:
	 * 
	 * if(myFormula == False.VALUE) { // do_whatever; }
	 */
	public static final False VALUE = new False();

	/**
	 * Constructs a new False.
	 * 
	 * Making this constructor private ensures that False can never be
	 * instantiated outside this class.
	 */
	private False() {
	}

	protected boolean isNeg(Formula formula) {
		return formula == True.VALUE;
	}

	protected Formula neg() {
		return True.VALUE;
	}

	public String toString() {
		return "FALSE";
	}
}
