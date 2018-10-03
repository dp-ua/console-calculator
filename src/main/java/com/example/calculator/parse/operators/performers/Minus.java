package com.example.calculator.parse.operators.performers;

/**
 * Returns the result of subtracting the number b from the number a
 */
public class Minus implements AbstractPerformer {
    @Override
    public double perform(double a, double b) {
        return a-b;
    }
}
