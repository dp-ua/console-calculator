package com.example.calculator.calculation.operators.performers;


/**
 * Blank performer. Return zero. Use for nonoperatable entities
 */
public class Blank implements AbstractPerformer {
    @Override
    public double perform(double a, double b) throws ArithmeticException {
        return 0;
    }
}
