package com.sysgears.calculator.calculation.operators.performers;

/**
 * Returns the result of subtracting the number b from the number a
 */
public class Minus implements AbstractPerformer {
    @Override
    public double perform(double a, double b) {
        return a-b;
    }
}
