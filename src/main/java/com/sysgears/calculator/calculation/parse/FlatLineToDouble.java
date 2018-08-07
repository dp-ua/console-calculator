package com.sysgears.calculator.calculation.parse;

import com.sysgears.calculator.calculation.operators.Operator;
import com.sysgears.calculator.calculation.operators.TypeOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Produce the calculations with "flat" line
 */
public class FlatLineToDouble {

    /**
     * line for work
     */
    private final String input;

    /**
     * Set line for work
     *
     * @param input "flat" line
     */
    public FlatLineToDouble(String input) {
        this.input = input;
    }


    /**
     * Produce "flat" line
     *
     * @return double result of calculation
     * @throws IllegalArgumentException take when wrong arguments
     * @throws StringIndexOutOfBoundsException wrong string
     */
    public double calculate() throws IllegalArgumentException, StringIndexOutOfBoundsException {
        double result;
        try {
            String flatString = input;
            String delimeter = TypeOperator.DELIMETER.getOperator().get(0);

            while (flatString.contains(delimeter)) {
                int iLast = flatString.lastIndexOf(delimeter);
                flatString = flatString.substring(0, iLast) + new FlatLineToDouble(flatString.substring(iLast + 1)).calculate();
            }

            List<String> list = new ArrayList<String>(Arrays.asList(flatString.split(" ")));

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

                list.set(now - 1, operator.produce(firstOperand, secondOperand) + "");
                list.remove(now + 1);
                list.remove(now);
                now -= 2;
            }

            if (list.size() == 3) {
                Operator operator = new Operator(list.get(1).charAt(0));
                double firstOperand = Double.parseDouble(list.get(0));
                double secondOperand = Double.parseDouble(list.get(2));
                result = operator.produce(firstOperand, secondOperand);
            } else if (list.size() == 1)
                result = Double.parseDouble(list.get(0));
            else throw new IllegalArgumentException("");

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка ввода данных.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при разборе параметров строки.");
        } catch (StringIndexOutOfBoundsException e) {
            throw new StringIndexOutOfBoundsException("Деление на ноль");
        }

        return result;
    }


}
