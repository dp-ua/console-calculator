package logic.parse;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CalcListTest {

    @Test
    public void calcFlatList_Simple() {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("+");
        list.add("2");

        CalcList calcList = new CalcList(list);
        double res = calcList.calcFlatList();

        Assert.assertEquals(3, res, 0.009);
    }

    @Test
    public void calcFlatList_OneBracket() {
        List<String> list = new ArrayList<String>();
        list.add("2");
        list.add("*");
        list.add("$2 + 7");

        CalcList calcList = new CalcList(list);
        double res = calcList.calcFlatList();

        Assert.assertEquals(18, res, 0.009);
    }


}

