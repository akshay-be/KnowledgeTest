package com.indix.ast;

import java.util.Vector;

/**
 * Superclass of all the types in abstract syntax trees.
 * 
 * Abstract syntax trees - Formulas - are returned by the parser.
 * The private check() method in
 * checker.Checker calls the relevant methods in
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
 *  Impl(Formula, Formula) 
 *  Iff(Formula, Formula)
 * 
 * 
 * @author Akshay BE
 * @version 1.0
 * 
 */
public abstract class Formula {

    
    /** Converts this Formula to Negative Normal Form. 
     *
     * @return    this Formula in Negative Normal Form.
     * @exception CheckerException If this formula still contains any
     *            implications.
     */
    abstract public Formula toNnf() ;

    /** Converts this Formula from Negative Normal Form to 
     * Conjunctive Normal Form.
     *
     * @return    this Formula in Conjunctive Normal Form.
     * @exception CheckerException If this formula is not in NNF or if it
     *            still contains any implications.
     */
    abstract public Formula nnfToCnf();

    /** Simplifies this CNF Formula. 
     *
     * @return    this Formula in its simplist Conjunctive Normal 
     *            Form.
     * @exception CheckerException If this formula is not in CNF or if it
     *            still contains any implications.
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
     * @exception CheckerException If this formula is not in CNF or if it
     *            still contains any implications.
     *
     * @see       Conj#simplifyCnf()
     * @see       java.util.Vector
     */
    abstract protected Vector toClause();

    /** Returns a textual description of this Formula.
     *
     * This is used for pretty printing, when either of the 
     * checker.Checker.DEBUG or 
     * checker.Checker.PARSE_DEBUG switches are turned on.
     *
     * @return the textual representation.
     *
     * @see    checker.Checker#DEBUG
     * @see    checker.Checker#PARSE_DEBUG
     */
    abstract public String toString();

}
