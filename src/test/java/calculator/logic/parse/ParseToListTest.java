package calculator.logic.parse;

import calculator.logic.operators.TypeOperator;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ParseToListTest {

    @Test
    public void parseToList_One_operator() {
        ParseToList parseToList = new ParseToList("1+2");
        List<String> res = parseToList.getWorkList();
        List<String> expected = new ArrayList<String>();
        expected.add("1");
        expected.add("+");
        expected.add("2");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test
    public void parseToList_Two_operators() {
        ParseToList parseToList = new ParseToList("1+2*5");
        List<String> res = parseToList.getWorkList();
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
        ParseToList parseToList = new ParseToList("1+(2-5)*12");
        List<String> res = parseToList.getWorkList();
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
        ParseToList parseToList = new ParseToList("(4*(2-5))^12");
        List<String> res = parseToList.getWorkList();
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = NullPointerException.class)
    public void parseToList_NullString_Error() {
        ParseToList parseToList = new ParseToList("");
        List<String> res = parseToList.getWorkList();
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseToList_wrongBrackets1() {
        ParseToList parseToList = new ParseToList("((1+2)");
        List<String> res = parseToList.getWorkList();

        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("$1 + 2");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void parseToList_wrongBrackets2() {
        ParseToList parseToList = new ParseToList(")1+2(");
        List<String> res = parseToList.getWorkList();
        List<String> expected = new ArrayList<String>();
        expected.add("(");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }


    @Test(expected = IllegalArgumentException.class)
    public void parseToList_use_Forbiden_Symbol_Error() {
        ParseToList parseToList = new ParseToList("1+2"+TypeOperator.DELIMETER.getOperator().get(0));
        List<String> res = parseToList.getWorkList();
        List<String> expected = new ArrayList<String>();
        expected.add("$4 * $2 - 5");
        expected.add("^");
        expected.add("12");

        Assert.assertArrayEquals(expected.toArray(), res.toArray());
    }


}