package com.example.calculator.calculation.operators.performers;

/**
 * Returns b percent of the number a
 */
public class Percent implements AbstractPerformer {
    @Override
    public double perform(double a, double b) {
        return (a/100)*b;
    }
}
