package com.sysgears.calculator.calculation.operators.performers;

import com.sysgears.calculator.calculation.parse.exception.MyException;
import com.sysgears.calculator.calculation.parse.exception.TypeExtention;

/**
 * Returns the remainder of a division
 */
public class Mod implements AbstractPerformer {
    @Override
    public double perform(double a, double b) throws MyException{
        double result=a % b;
        if (Double.isNaN(result)|Double.isInfinite(result) )throw new MyException(TypeExtention.NAN);
        return result;
    }
}
