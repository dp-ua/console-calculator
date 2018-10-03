package com.example.calculator.parse.operators.performers;

import com.example.calculator.parse.exception.CallculationExceptions;
import com.example.calculator.parse.exception.ExceptionTypes;

/**
 * Returns the remainder of a division
 */
public class Mod implements AbstractPerformer {
    @Override
    public double perform(double a, double b) throws CallculationExceptions {
        double result=a % b;
        if (Double.isNaN(result)|Double.isInfinite(result) )throw new CallculationExceptions(ExceptionTypes.NAN);
        return result;
    }
}
