package com.indix.ast;

import java.util.Vector;

/** Superclass for <i>literal</i> Formulas - those that are not 
 * connectives.
 *
 * @author  Akshay BE
 * @version 1.0
 *
 * @see     Atom
 * @see     True
 * @see     False
 */ 
public abstract class Literal extends Formula {
	public Formula toNnf() {
        return this;
    }

    public Formula nnfToCnf() {
        return this;
    }

    public Formula simplifyCnf() {
        return this;
    }

    protected Vector toClause() {
        Vector V = new Vector();
        V.addElement(this);
        return V;
    }

	abstract protected boolean isNeg(Formula formula);
}
