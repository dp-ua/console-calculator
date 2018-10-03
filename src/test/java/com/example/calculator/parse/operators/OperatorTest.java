package com.example.calculator.parse.operators;

import org.junit.Assert;
import org.junit.Test;

public class OperatorTest {

    @Test
    public void testType_Plus() {
        Operator operator = new Operator('+');
        OperatorTypes res = operator.getOperatorTypes();
        Assert.assertEquals(OperatorTypes.PLUS, res);
    }

    @Test
    public void testType_Minus() {
        Operator operator = new Operator('-');
        OperatorTypes res = operator.getOperatorTypes();
        Assert.assertEquals(OperatorTypes.MINUS, res);
    }

    @Test
    public void testType_Mult() {
        Operator operator = new Operator('*');
        OperatorTypes res = operator.getOperatorTypes();
        Assert.assertEquals(OperatorTypes.MULT, res);
    }

    @Test
    public void testType_DIV1() {
        Operator operator = new Operator('/');
        OperatorTypes res = operator.getOperatorTypes();
        Assert.assertEquals(OperatorTypes.DIV, res);
    }

    @Test
    public void testType_DIV2() {
        Operator operator = new Operator(':');
        OperatorTypes res = operator.getOperatorTypes();
        Assert.assertEquals(OperatorTypes.DIV, res);
    }


    @Test
    public void testType_Perc() {
        Operator operator = new Operator('%');
        OperatorTypes res = operator.getOperatorTypes();
        Assert.assertEquals(OperatorTypes.PERCENT, res);
    }

    @Test
    public void testType_Pow() {
        Operator operator = new Operator('^');
        OperatorTypes res = operator.getOperatorTypes();
        Assert.assertEquals(OperatorTypes.POW, res);
    }

    @Test
    public void testType_String() {
        Operator operator = new Operator('d');
        OperatorTypes res = operator.getOperatorTypes();
        Assert.assertEquals(OperatorTypes.NON, res);
    }

}