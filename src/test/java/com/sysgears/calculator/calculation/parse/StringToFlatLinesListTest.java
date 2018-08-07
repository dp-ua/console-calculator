package com.sysgears.calculator.calculation.parse;

import com.sysgears.calculator.calculation.operators.TypeOperator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringToFlatLinesListTest {

    @Test
    public void parseToList_One_operator() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList("1+2");
        List<String> res = stringToFlatLinesList.parse();
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("+");
        expected.add("2");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void parseToList_Two_operators() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList("1+2*5");
        List<String> res = stringToFlatLinesList.parse();
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("+");
        expected.add("2");
        expected.add("*");
        expected.add("5");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }


    @Test
    public void parseToList_work_with_Brackets() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList("1+(2-5)*12");
        List<String> res = stringToFlatLinesList.parse();
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("+");
        expected.add("$2 - 5");
        expected.add("*");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void parseToList_Brackets_in_Brackets() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList("(4*(2-5))^12");
        List<String> res = stringToFlatLinesList.parse();
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = NullPointerException.class)
    public void parseToList_NullString_Error() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList("");
        List<String> res = stringToFlatLinesList.parse();
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseToList_wrongBrackets1() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList("((1+2)");
        List<String> res = stringToFlatLinesList.parse();

        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("$1 + 2");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseToList_wrongBrackets2() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList(")1+2(");
        List<String> res = stringToFlatLinesList.parse();
        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }


    @Test(expected = IllegalArgumentException.class)
    public void parseToList_use_Forbiden_Symbol_Error() {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList("1+2"+TypeOperator.DELIMETER.getOperator().get(0));
        List<String> res = stringToFlatLinesList.parse();
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }


}