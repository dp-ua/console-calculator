package com.example.calculator.parse;

import com.example.calculator.parse.operators.OperatorTypes;
import com.example.calculator.parse.exception.CallculationExceptions;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringToFlatLinesListTest {

    @Test
    public void parseToList_One_operator() throws CallculationExceptions {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> res = stringToFlatLinesList.parse("1+2");
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("+");
        expected.add("2");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void parseToList_Two_operators() throws CallculationExceptions {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> res = stringToFlatLinesList.parse("1+2*5");
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("+");
        expected.add("2");
        expected.add("*");
        expected.add("5");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }


    @Test
    public void parseToList_work_with_Brackets() throws CallculationExceptions {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> res = stringToFlatLinesList.parse("1+(2-5)*12");
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("+");
        expected.add("$2 - 5");
        expected.add("*");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void parseToList_Brackets_in_Brackets() throws CallculationExceptions {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> res = stringToFlatLinesList.parse("(4*(2-5))^12");
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = CallculationExceptions.class)
    public void parseToList_NullString_Error() throws CallculationExceptions {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> res = stringToFlatLinesList.parse("");
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = CallculationExceptions.class)
    public void parseToList_wrongBrackets1()throws CallculationExceptions {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> res = stringToFlatLinesList.parse("((1+2)");

        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("$1 + 2");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = CallculationExceptions.class)
    public void parseToList_wrongBrackets2() throws CallculationExceptions {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> res = stringToFlatLinesList.parse(")1+2(");
        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }


    @Test(expected = CallculationExceptions.class)
    public void parseToList_use_Forbiden_Symbol_Error() throws CallculationExceptions {
        StringToFlatLinesList stringToFlatLinesList = new StringToFlatLinesList();
        List<String> res = stringToFlatLinesList.parse("1+2"+OperatorTypes.DELIMETER.getOperator().get(0));
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }


}