package com.indix.ast;


import java.util.Vector;

/** Specifies NOT connectives.
 *
 * @author  Akshay BE
 * @author  Your Name
 * @version 1.0
 */
public final class NOT extends Formula {

    /** The term this object negates. */
    private final Formula term;

    /** Constructs a new negation, with a Formula as its
     * subject.
     *
     * Specifies the left and right hand sides of this conjunction.
     *
     * @param term  the Formula being negated.
     */
    public NOT(Formula term) {
    	this.term = term;
    }

    /** Returns the subject of this negation.
     *
     * @return the subject of this negation.
     */
    protected Formula getTerm() {
    	return this.term;
    }

   
	public Formula toNnf() {
		if (this.term instanceof AND || this.term instanceof OR
				|| this.term instanceof NOT) {

			return this.term.neg().toNnf();

		} else if (this.term instanceof Literal) {
			return this;
		}
		return null;
	}

    public Formula nnfToCnf() {
    	 if (this.term instanceof Literal) {
             return this;
         }
    	 return null;
    }

    public Formula simplifyCnf()  {
        if (this.term instanceof Literal) {
            return this;
        }
	return null;
    }

    protected Vector toClause() {
        Vector V = new Vector();
        V.addElement(this);
        return V;
    }

    protected Formula neg() {
        return this.term;
    }

    public String toString() {
        return "!" + term.toString();
    }
}
