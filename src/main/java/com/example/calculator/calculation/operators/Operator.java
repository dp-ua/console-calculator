package com.example.calculator.calculation.operators;

import com.example.calculator.calculation.parse.exception.CallculationExceptions;

/**
 * Parse and detect basics operators, which are indicated in the Enum TypeOperators
 */
public class Operator {

    /**
     * Type of operator
     */
    private final OperatorTypes operatorTypes;

    /**
     * Set the operator
     *
     * @param c symbol of working operator
     */
    public Operator(char c) {
        operatorTypes = getTypeByChar(c);
    }

    /**
     * Specifies the type of operator by the entered character
     *
     * @param c character of operator
     * @return type of operator
     */
    private OperatorTypes getTypeByChar(char c) {
        for (OperatorTypes t : OperatorTypes.values())
            for (String s : t.getOperator())
                if (c == s.charAt(0)) return t;
        return OperatorTypes.NON;
    }

    /**
     * Get Type of Operator
     *
     * @return OperatorTypes
     */
    public OperatorTypes getOperatorTypes() {
        return operatorTypes;
    }

    /**
     * Checks the type of the operator
     *
     * @return returns true if the operator is specified
     */
    public boolean isOperator() {
        return operatorTypes.isOperator();

    }

    /**
     * Calls the required costing over the operands according to the specified type of operator
     *
     * @param firstOperand  first operand
     * @param secondOperand second operand
     * @return double showResult of operations
     * @throws IllegalArgumentException if take non specified showResult or an showError in the calculation
     */
    public double produce(double firstOperand, double secondOperand) throws CallculationExceptions {
        return operatorTypes.produce(firstOperand, secondOperand);
    }
}
