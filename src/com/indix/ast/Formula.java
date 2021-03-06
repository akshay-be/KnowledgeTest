package com.indix.ast;

import java.util.Vector;

/**
 * Superclass of all the types in abstract syntax trees.
 * 
 * Abstract syntax trees - Formulas - are returned by the parser.
 * The private check() method in Checker calls the relevant methods in
 * Formula to perform a correct tautology check.
 * 
 * 
 * The grammar of the AST is as follows: 
 * Formula ::= Atom(String) 
 *  True 
 *  False 
 *  Neg(Formula) 
 *  Conj(Formula, Formula) 
 *  Disj(Formula, Formula) 
 * 
 * @author Akshay BE
 * 
 */
public abstract class Formula {

    
    /** Converts this Formula to Negative Normal Form. 
     *
     * @return    this Formula in Negative Normal Form.
     */
    abstract public Formula toNnf() ;

    /** Converts this Formula from Negative Normal Form to 
     * Conjunctive Normal Form.
     *
     * @return    this Formula in Conjunctive Normal Form.
     */
    abstract public Formula nnfToCnf();

    /** Simplifies this CNF Formula. 
     *
     * @return    this Formula in its simplist Conjunctive Normal 
     *            Form.
     */
    public Formula simplifyCnf()  {
    	return (new AND(this, True.VALUE)).simplifyCnf();
    }

    /** Returns the negation of this Formula. 
     *
     * Subclasses should implement this method 'correctly' - that is
     * according to deMorgan's laws and the double-negative law.
     *
     * @return the negation of this Formula.
     */
    abstract protected Formula neg();
    
    /** Converts this formula to clausal form - only called by 
     * simplifyCnf() in the Conj class.
     * 
     * @return    this Formula in clausal form.
     *
     */
    abstract protected Vector toClause();

    /** Returns a textual description of this Formula.
     *
     * This is used for pretty printing, when either of the 
     *
     * @return the textual representation.
     *
     */
    abstract public String toString();

}
