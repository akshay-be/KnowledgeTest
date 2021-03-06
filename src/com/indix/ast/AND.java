package com.indix.ast;

import java.util.Vector;

/**
 * Specifies AND connectives.
 * 
 * The bulk of the simplifyCnf() algorithm resides here, since all CNF Formulas
 * contain a Conj at their root.
 * 
 * 
 */
public final class AND extends Formula {

	/** The left hand side of this conjunction. */
	private final Formula left;
	/** The right hand side of this conjunction. */
	private final Formula right;

	/**
	 * Constructs a new conjunction, with Formulas at its left and right hand
	 * side.
	 * 
	 * Specifies the left and right hand sides of this conjunction.
	 * 
	 * @param left
	 *            the left hand Formula.
	 * @param right
	 *            the right hand Formula.
	 */
	public AND(Formula left, Formula right) {
		this.left = left;
		this.right = right;
	}

	/**
	 * Returns the left hand side of this conjunction.
	 * 
	 * @return the left hand side of this conjunction.
	 */
	protected Formula getLeft() {
		return this.left;
	}

	/**
	 * Returns the right hand side of this conjunction.
	 * 
	 * @return the right hand side of this conjunction.
	 */
	protected Formula getRight() {
		return this.right;
	}

	public Formula toNnf() {
		return new AND(this.left.toNnf(), this.right.toNnf());
	}

	public Formula nnfToCnf() {
		return new AND(this.left.nnfToCnf(), this.right.nnfToCnf());
	}

	/**
	 * Simplifies this CNF Formula.
	 * 
	 */
	public Formula simplifyCnf() {
		Vector clausal = this.toClause();

		// Remove any clause containing a Literal and its negation.
		for (int i = 0; i < clausal.size(); i++) {
			Vector curr_disj = (Vector) clausal.elementAt(i);
			loop: for (int j = 0; j < curr_disj.size(); j++) {
				if (curr_disj.elementAt(j) instanceof Literal) {
					Literal at_j = (Literal) curr_disj.elementAt(j);
					for (int k = 0; k < curr_disj.size(); k++) {
						Formula at_k = (Formula) curr_disj.elementAt(k);
						if (at_j.isNeg(at_k)) {
							clausal.removeElementAt(i--);
							break loop;
						}
					}
				}
			}
		}

		// Remove any clause that is a superset of another clause.
		for (int i = 0; i < clausal.size() - 1; i++) {
			for (int j = i + 1; j < clausal.size(); j++) {
				if (isSubset((Vector) clausal.elementAt(i),
						(Vector) clausal.elementAt(j))) {
					clausal.removeElementAt(j);
				} else if (isSubset((Vector) clausal.elementAt(j),
						(Vector) clausal.elementAt(i))) {
					clausal.removeElementAt(i);
				}
			}
		}

		// Return a Formula.
		return fromClause(clausal);
	}

	/**
	 * Returns true if v1 is a subset of v2.
	 * 
	 * Only called by Conj.simplifyCnf().
	 * 
	 * @param v1
	 *            a possible subset of v2
	 * @param v2
	 *            a possible superset of v1
	 * @return true if v1 is a subset of v2.
	 * 
	 */
	private static boolean isSubset(Vector v1, Vector v2) {
		for (int i = 0; i < v1.size(); i++) {
			if (!v2.contains(v1.elementAt(i))) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Converts clausal from clausal form to a Formula.
	 * 
	 * Only called by Conj.simplifyCnf().
	 * 
	 * @param clausal
	 *            a Formula in its clausal form.
	 * @return the abstract syntax tree representation of clausal.
	 * 
	 */
	private static Formula fromClause(Vector clausal) {
		Formula conj = True.VALUE;

		for (int i = clausal.size(); i > 0; i--) {
			Formula disj = False.VALUE;
			Vector curr_disj = (Vector) clausal.elementAt(i - 1);

			for (int j = curr_disj.size(); j > 0; j--) {
				Formula curr_lit = (Formula) curr_disj.elementAt(j - 1);
				if (disj == False.VALUE) {
					disj = curr_lit;
				} else {
					disj = new OR(disj, curr_lit);
				}
			}

			if (conj == True.VALUE) {
				conj = disj;
			} else {
				conj = new AND(disj, conj);
			}
		}

		return conj;
	}

	protected Vector toClause() {
		Vector clause = new Vector();
		Vector c_left;
		Vector c_right;

		if (this.left instanceof AND) {
			c_left = this.left.toClause();
			for (int i = 0; i < c_left.size(); i++) {
				clause.addElement(c_left.elementAt(i));
			}
		} else {
			c_left = this.left.toClause();
			clause.addElement(c_left);
		}

		if (this.right instanceof AND) {
			c_right = this.right.toClause();
			for (int i = 0; i < c_right.size(); i++) {
				clause.addElement(c_right.elementAt(i));
			}
		} else {
			c_right = this.right.toClause();
			clause.addElement(c_right);
		}

		return clause;
	}

	protected Formula neg() {
		return new OR(this.left.neg(), this.right.neg());
	}

	public String toString() {
		return ("(" + this.left.toString() + " /\\ " + this.right.toString() + ")");
	}
}
