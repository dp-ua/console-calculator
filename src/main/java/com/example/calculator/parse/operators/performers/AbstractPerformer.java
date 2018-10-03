package com.example.calculator.parse.operators.performers;

import com.example.calculator.parse.exception.CallculationExceptions;

/**
 * Defines a specific type of operation for the operator
 */
public interface AbstractPerformer {

    /**
     * Performs the necessary operation on two operands
     * @param a - first operand
     * @param b - second operand
     * @return result of operation
     * @throws CallculationExceptions if take it while calculatoin
     */

    double perform(double a, double b) throws CallculationExceptions;
}
