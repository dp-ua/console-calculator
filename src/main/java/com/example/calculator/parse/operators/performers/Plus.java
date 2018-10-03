package com.example.calculator.parse.operators.performers;

/**
 * Do a+b function
 */
public class Plus implements AbstractPerformer {
    @Override
    public double perform(double a, double b) {
        return a+b;
    }
}
