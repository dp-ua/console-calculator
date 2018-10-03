package com.example.calculator.calculation.operators.performers;

/**
 * Make pow functions with two operands
 */
public class Pow implements AbstractPerformer {
    @Override
    public double perform(double a, double b) {
        return a*b;
    }
}
