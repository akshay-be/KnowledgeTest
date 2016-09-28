package com.indix.ast;

/** Specifies the TT Literal.
 *
 * @author  Akshay BE
 * @version 1.0
 */
public final class True extends Literal {

    /** The only instantiation of this class.
     *
     * VALUE enables us to test a Formula for
     * truth using the double-equals operator. For example:
     *
     * if(myFormula == True.VALUE) { // do_whatever; }
     */
    public static final True VALUE = new True();

    /** Constructs a new True.
     *
     * Making this constructor private ensures that 
     * True can never be instantiated outside this class.
     */
    private True() {}

    protected boolean isNeg(Formula formula) {
	return formula == False.VALUE;
    }

    protected Formula neg() {
	return False.VALUE;
    }

    public String toString() {
	return "TRUE";
    }
}
