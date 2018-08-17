package com.sysgears.calculator.calculation.operators.performers;

/**
 * Multiplies two operands
 */
public class Mult implements AbstractPerformer {
    @Override
    public double perform(double a, double b) {
        return a*b;
    }
}
