package calculator.logic.parse;

import calculator.logic.operators.Operator;
import calculator.logic.operators.TypeOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcFlatString {

    String input;

    public CalcFlatString(String input) {
        this.input = input;
    }


    public String calculate() throws IllegalArgumentException, StringIndexOutOfBoundsException {
        double dResult;
        try {
            String sWork = input;
            String delimeter = TypeOperator.DELIMETER.getOperator().get(0);

            while (sWork.contains(delimeter)) {
                int iLast = sWork.lastIndexOf(delimeter);
                sWork = sWork.substring(0, iLast) + new CalcFlatString(sWork.substring(iLast + 1)).calculate();
            }

            List<String> list = new ArrayList<String>(Arrays.asList(sWork.split(" ")));

            int now = 1;
            while (list.size() > 3) {
                Operator operator = new Operator(list.get(now).charAt(0));
                if ((now + 2) < (list.size())) {
                    Operator opB = new Operator(list.get(now + 2).charAt(0));

                    if (operator.getTypeOperator().getPriority() < opB.getTypeOperator().getPriority()) {
                        now += 2;
                        continue;
                    }
                }

                double dA = Double.parseDouble(list.get(now - 1));
                double dB = Double.parseDouble(list.get(now + 1));

                list.set(now - 1, operator.calculate(dA, dB) + "");
                list.remove(now + 1);
                list.remove(now);
                now -= 2;
            }

            if (list.size() == 3) {
                Operator operator = new Operator(list.get(1).charAt(0));
                double dA = Double.parseDouble(list.get(0));
                double dB = Double.parseDouble(list.get(2));
                dResult = operator.calculate(dA, dB);
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

        return String.format("%.2f", dResult);
    }


}
