package com.sysgears.calculator.calculations.operators;

import static com.sysgears.calculator.calculations.operators.TypeOperator.*;

/**
 * class for work with basic operators
 */
public class Operator {

    /**
     * Type of operator
     */
    private final TypeOperator typeOperator;

    /**
     * set the basic operator
     * @param cOperator symbol of working operator
     */
    public Operator(char cOperator) {
        typeOperator = getTypeByString(cOperator);
    }

    /**
     * Specifies the type of operator by the entered character
     * @param cInput character of operator
     * @return TypeOperator
     */
    private TypeOperator getTypeByString(char cInput) {
        for (TypeOperator t : values())
            for (String s : t.getOperator())
                if (cInput == s.charAt(0)) return t;
        return NON;
    }

    /**
     * get Type of Operator
     * @return TypeOperator
     */
    public TypeOperator getTypeOperator() {
        return typeOperator;
    }

    /**
     * checks the type of the operator
     * @return returns true if the operator is specified
     */
    public boolean isOperator() {
        switch (typeOperator) {
            case NON:
            case OPENBRACKETS:
            case CLOSEBRACKETS:
            case DELIMETER:
                return false;
        }
        return true;

    }

    /**
     * Make the necessary actions on the specified operands
     * @param firstOperand first operand
     * @param secondOperand second operand
     * @return result of operations
     * @throws IllegalArgumentException if take non specified result
     */
    public double calculate(double firstOperand, double secondOperand) throws IllegalArgumentException {
        return typeOperator.calculate(firstOperand, secondOperand);
    }


}
