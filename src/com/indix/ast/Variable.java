package com.indix.ast;

public class Variable  extends Literal {
	private final String name;

    public Variable(String name) {
        this.name = name;
    }

    protected String getName() {
        return name; 
    }     
         
    protected boolean isNeg(Formula formula) {
    	if (formula instanceof NOT) {
            Formula term = ((NOT)formula).getTerm();
            if (term instanceof Variable) {
                return ((Variable)term).getName().equals(this.name);
            }
        }
        return false;
    }

    protected Formula neg() {
        return new NOT(this);
    }
    
    public String toString() {
        return this.name;
    }
}
