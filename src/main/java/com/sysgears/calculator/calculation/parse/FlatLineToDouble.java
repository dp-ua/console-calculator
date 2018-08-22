package com.sysgears.calculator.calculation.parse;

import com.sysgears.calculator.calculation.operators.Operator;
import com.sysgears.calculator.calculation.operators.OperatorTypes;
import com.sysgears.calculator.calculation.parse.exception.CallculationExceptions;
import com.sysgears.calculator.calculation.parse.exception.ExceptionTypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Produce the calculations with "flat" line
 */
class FlatLineToDouble {

    /**
     * Produce "flat" line
     *
     * @param input
     * @return double showResult of calculation
     * @throws IllegalArgumentException take when wrong arguments
     * @throws StringIndexOutOfBoundsException wrong string
     */
    double calculate(String input) throws CallculationExceptions {
        double result;
        try {
            String flatString = input;
            String delimeter = OperatorTypes.DELIMETER.getOperator().get(0);

            while (flatString.contains(delimeter)) {
                int lastIndexOfDelimiter = flatString.lastIndexOf(delimeter);
                flatString = flatString.substring(0, lastIndexOfDelimiter) +
                        new FlatLineToDouble().calculate(flatString.substring(lastIndexOfDelimiter + 1));
            }

            List<String> list = new ArrayList<>(Arrays.asList(flatString.split(" ")));

            int currentPosition = 1;
            while (list.size() > 3) {
                Operator operator = new Operator(list.get(currentPosition).charAt(0));
                if ((currentPosition + 2) < (list.size())) {
                    Operator nextOperator = new Operator(list.get(currentPosition + 2).charAt(0));

                    if (operator.getOperatorTypes().getPriority() < nextOperator.getOperatorTypes().getPriority()) {
                        currentPosition += 2;
                        continue;
                    }
                }

                double firstOperand = Double.parseDouble(list.get(currentPosition - 1));
                double secondOperand = Double.parseDouble(list.get(currentPosition + 1));

                list.set(currentPosition - 1, Double.toString(operator.produce(firstOperand, secondOperand)));
                list.remove(currentPosition + 1);
                list.remove(currentPosition);
                currentPosition -= 2;
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
            throw new CallculationExceptions(ExceptionTypes.DATA);
        } catch (IllegalArgumentException e) {
            throw new CallculationExceptions(ExceptionTypes.PARAMS);
        } catch (StringIndexOutOfBoundsException e) {
            throw new CallculationExceptions(ExceptionTypes.NAN);
        }

        return result;
    }


}
