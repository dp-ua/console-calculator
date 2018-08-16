package com.sysgears.calculator.calculation.operators.performers;

/**
 * Defines a specific type of operation for the operator
 */
public interface AbstractPerformer {

    /**
     * Performs the necessary operation on two operands
     * @param a - first operand
     * @param b - second operand
     * @return result of operation
     * @throws ArithmeticException - if take arafmetical error while calculations
     */
    double perform(double a, double b) throws ArithmeticException;
}
