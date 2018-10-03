package com.example.calculator.parse.operators.performers;

/**
 * Multiplies two operands
 */
public class Mult implements AbstractPerformer {
    @Override
    public double perform(double a, double b) {
        return a*b;
    }
}
