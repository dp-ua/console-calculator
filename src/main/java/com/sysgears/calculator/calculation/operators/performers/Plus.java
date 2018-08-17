package com.sysgears.calculator.calculation.operators.performers;

/**
 * Do a+b function
 */
public class Plus implements AbstractPerformer {
    @Override
    public double perform(double a, double b) {
        return a+b;
    }
}
