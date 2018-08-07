package com.sysgears.calculator.calculations.parse;

import com.sysgears.calculator.calculations.operators.Operator;
import com.sysgears.calculator.calculations.operators.TypeOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class calculate "flat" line
 */
public class FlatLineToDouble {

    /**
     * line for work
     */
    private final String input;

    /**
     * set line for work
     * @param input "flat" line
     */
    public FlatLineToDouble(String input) {
        this.input = input;
    }


    /**
     * calculate "flat" line
     * @return String result of calculations
     * @throws IllegalArgumentException wrong arguments
     * @throws StringIndexOutOfBoundsException wrong string
     */
    public double calculate() throws IllegalArgumentException, StringIndexOutOfBoundsException {
        double dResult;
        try {
            String sWork = input;
            String delimeter = TypeOperator.DELIMETER.getOperator().get(0);

            while (sWork.contains(delimeter)) {
                int iLast = sWork.lastIndexOf(delimeter);
                sWork = sWork.substring(0, iLast) + new FlatLineToDouble(sWork.substring(iLast + 1)).calculate();
            }

            List<String> list = new ArrayList<String>(Arrays.asList(sWork.split(" ")));

            int now = 1;
            while (list.size() > 3) {
                Operator operator = new Operator(list.get(now).charAt(0));
                if ((now + 2) < (list.size())) {
                    Operator nextOperator = new Operator(list.get(now + 2).charAt(0));

                    if (operator.getTypeOperator().getPriority() < nextOperator.getTypeOperator().getPriority()) {
                        now += 2;
                        continue;
                    }
                }

                double firstOperand = Double.parseDouble(list.get(now - 1));
                double secondOperand = Double.parseDouble(list.get(now + 1));

                list.set(now - 1, operator.calculate(firstOperand, secondOperand) + "");
                list.remove(now + 1);
                list.remove(now);
                now -= 2;
            }

            if (list.size() == 3) {
                Operator operator = new Operator(list.get(1).charAt(0));
                double firstOperand = Double.parseDouble(list.get(0));
                double secondOperand = Double.parseDouble(list.get(2));
                dResult = operator.calculate(firstOperand, secondOperand);
            } else if (list.size() == 1)
                dResult = Double.parseDouble(list.get(0));
            else throw new IllegalArgumentException("");

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка ввода данных.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при разборе параметров строки.");
        } catch (StringIndexOutOfBoundsException e) {
            throw new StringIndexOutOfBoundsException("Деление на ноль");
        }

        return dResult;
    }


}
