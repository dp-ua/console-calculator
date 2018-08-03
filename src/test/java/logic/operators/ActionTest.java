package logic.operators;

import org.junit.Assert;
import org.junit.Test;

public class ActionTest {
    private double delta=0.009;

    @Test
    public void calc_100plus2_120returned() {
        Action action = new Action(new Operator('+'));
        double res = action.calculate(100, 20);
        Assert.assertEquals(120, res, delta);
    }

    @Test
    public void calc_100minus2_98returned() {
        Action  action = new Action(new Operator('-'));
        double res = action.calculate(100, 2);
        Assert.assertEquals(98, res, delta);
    }

    @Test
    public void calc_5mult20_100returned() {
        Action  action = new Action(new Operator('*'));
        double res = action.calculate(5, 20);
        Assert.assertEquals(100, res, delta);
    }


    @Test
    public void calc_100div3_33returned() {
        Action  action = new Action(new Operator('/'));
        double res = action.calculate(100, 3);
        Assert.assertEquals(33.33, res, delta);
    }

    @Test(expected = ArithmeticException.class)
    public void calc_100div0_ErrorReturned() {
        Action  action = new Action(new Operator('/'));
        double res = action.calculate(100, 0);
        Assert.assertEquals(33.33, res, delta);
    }

    @Test(expected = ArithmeticException.class)
    public void calc_0div0_ErrorReturned() {
        Action  action = new Action(new Operator('/'));
        double res = action.calculate(0, 0);
        Assert.assertEquals(33.33, res, delta);
    }

    @Test
    public void calc_100perc25_25returned() {
        Action  action = new Action(new Operator('%'));
        double res = action.calculate(100, 25);
        Assert.assertEquals(25, res, delta);
    }

    @Test
    public void calc_5pow2_25returned() {
        Action action = new Action(new Operator('^'));
        double res = action.calculate(5, 2);
        Assert.assertEquals(25, res, delta);
    }

    @Test
    public void calc_5pow0_1returned() {
        Action action = new Action(new Operator('^'));
        double res = action.calculate(5, 0);
        Assert.assertEquals(1, res, delta);
    }

    @Test
    public void calc_5powM1_02returned() {
        //возведение в отрицательную степень
        Action action = new Action(new Operator('^'));
        double res = action.calculate(5, -1);
        Assert.assertEquals(0.2, res, delta);
    }

    @Test
    public void calc_0pow1_0returned() {
        //возведение в отрицательную степень
        Action action = new Action(new Operator('^'));
        double res = action.calculate(0, 1);
        Assert.assertEquals(0, res, delta);
    }
}