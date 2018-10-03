package com.example.calculator.parse.operators.performers;

import com.example.calculator.parse.exception.CallculationExceptions;
import com.example.calculator.parse.exception.ExceptionTypes;

/**
 * It divides the number a by the number b. In the case of division by zero returns an error
 */
public class Div implements AbstractPerformer {
    @Override
    public double perform(double a, double b) throws CallculationExceptions {
        try {
            double result=a/b;
            if (Double.isNaN(result)|Double.isInfinite(result) )throw new CallculationExceptions(ExceptionTypes.NAN);
            return result;
        } catch (ArithmeticException e) {
            throw new CallculationExceptions(ExceptionTypes.NAN);
        }
    }
}
