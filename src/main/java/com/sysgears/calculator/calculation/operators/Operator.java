package com.sysgears.calculator.calculation.operators;

import static com.sysgears.calculator.calculation.operators.TypeOperator.*;

/**
 * Parse and detect basics operators, which are indicated in the Enum TypeOperators
 */
public class Operator {

    /**
     * Type of operator
     */
    private final TypeOperator typeOperator;

    /**
     * Set the operator
     *
     * @param c symbol of working operator
     */
    public Operator(char c) {
        typeOperator = getTypeByChar(c);
    }

    /**
     * Specifies the type of operator by the entered character
     *
     * @param c character of operator
     * @return type of operator
     */
    private TypeOperator getTypeByChar(char c) {
        for (TypeOperator t : values())
            for (String s : t.getOperator())
                if (c == s.charAt(0)) return t;
        return NON;
    }

    /**
     * Get Type of Operator
     *
     * @return TypeOperator
     */
    public TypeOperator getTypeOperator() {
        return typeOperator;
    }

    /**
     * Checks the type of the operator
     *
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
     * Calls the required costing over the operands according to the specified type of operator
     *
     * @param firstOperand  first operand
     * @param secondOperand second operand
     * @return double result of operations
     * @throws IllegalArgumentException if take non specified result or an error in the calculation
     */
    public double produce(double firstOperand, double secondOperand) throws IllegalArgumentException {
        return typeOperator.produce(firstOperand, secondOperand);
    }
}
