package com.sysgears.calculator.calculation.operators.performers;

import com.sysgears.calculator.calculation.parse.exception.MyException;

/**
 * Defines a specific type of operation for the operator
 */
public interface AbstractPerformer {

    /**
     * Performs the necessary operation on two operands
     * @param a - first operand
     * @param b - second operand
     * @return result of operation
     * @throws MyException if take it while calculatoin
     */

    double perform(double a, double b) throws MyException;
}
