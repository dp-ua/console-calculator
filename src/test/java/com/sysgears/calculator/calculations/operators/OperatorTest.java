package com.sysgears.calculator.calculations.operators;

import org.junit.Assert;
import org.junit.Test;

public class OperatorTest {

    @Test
    public void testType_Plus() {
        Operator operator = new Operator('+');
        TypeOperator res = operator.getTypeOperator();
        Assert.assertEquals(TypeOperator.PLUS, res);
    }

    @Test
    public void testType_Minus() {
        Operator operator = new Operator('-');
        TypeOperator res = operator.getTypeOperator();
        Assert.assertEquals(TypeOperator.MINUS, res);
    }

    @Test
    public void testType_Mult() {
        Operator operator = new Operator('*');
        TypeOperator res = operator.getTypeOperator();
        Assert.assertEquals(TypeOperator.MULT, res);
    }

    @Test
    public void testType_DIV1() {
        Operator operator = new Operator('/');
        TypeOperator res = operator.getTypeOperator();
        Assert.assertEquals(TypeOperator.DIV, res);
    }

    @Test
    public void testType_DIV2() {
        Operator operator = new Operator(':');
        TypeOperator res = operator.getTypeOperator();
        Assert.assertEquals(TypeOperator.DIV, res);
    }


    @Test
    public void testType_Perc() {
        Operator operator = new Operator('%');
        TypeOperator res = operator.getTypeOperator();
        Assert.assertEquals(TypeOperator.PERCENT, res);
    }

    @Test
    public void testType_Pow() {
        Operator operator = new Operator('^');
        TypeOperator res = operator.getTypeOperator();
        Assert.assertEquals(TypeOperator.POW, res);
    }

    @Test
    public void testType_String() {
        Operator operator = new Operator('d');
        TypeOperator res = operator.getTypeOperator();
        Assert.assertEquals(TypeOperator.NON, res);
    }

}