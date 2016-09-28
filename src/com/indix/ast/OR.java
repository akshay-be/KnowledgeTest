package com.indix.ast;

import java.util.Vector;

/** Specifies OR connectives.
 *
 * @author  Akshay BE
 * @author  Your Name
 * @version 1.0
 */
public final class OR extends Formula {

    /** The left hand side of this disjunction. */
    private final Formula left;

    /** The right hand side of this disjunction. */
    private final Formula right;


    /** Constructs a new disjunction, with Formulas at its
     * left and right hand side.
     *
     * Specifies the left and right hand sides of this conjunction.
     *
     * @param left  the left hand Formula.
     * @param right the right hand Formula.
     */
    public OR(Formula left, Formula right) {
	this.left = left;
	this.right = right;
    }

    /** Returns the left hand side of this disjunction.
     * 
     * @return the left hand side of this disjunction.
     */
    protected Formula getLeft() {
	return this.left;
    }

    /** Returns the right hand side of this disjunction.
     * 
     * @return the right hand side of this disjunction.
     */
    protected Formula getRight() {
	return this.right;
    }

    
    public Formula toNnf() {
	return new OR(this.left.toNnf(), this.right.toNnf());
    }

    public Formula nnfToCnf() {
    	 Formula left = this.left.nnfToCnf();
         Formula right = this.right.nnfToCnf();

         if (left instanceof AND) {
             AND conj = (AND)left;
             return new AND(new OR(conj.getLeft(), right).nnfToCnf(),
                             new OR(conj.getRight(), right).nnfToCnf());
         }
         else if (right instanceof AND) {
             AND conj = (AND)right;
             return new AND(new OR(left, conj.getLeft()).nnfToCnf(),
                             new OR(left, conj.getRight()).nnfToCnf());
         }
         return new OR(left, right);
    }

	protected Vector toClause() {
		Vector clause = new Vector();
		Vector c_left = this.left.toClause();
		Vector c_right = this.right.toClause();

		for (int i = 0; i < c_left.size(); i++) {
			clause.addElement(c_left.elementAt(i));
		}

		for (int i = 0; i < c_right.size(); i++) {
			clause.addElement(c_right.elementAt(i));
		}

		return clause;
	}

    protected Formula neg() {
    	return new AND(this.left.neg(), this.right.neg());
    }

    public String toString() {
	return ("(" + this.left.toString() + " |  "+ this.right.toString() + ")");
    }
}
