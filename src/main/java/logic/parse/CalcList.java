package logic.parse;

import logic.operators.Action;
import logic.operators.Operator;
import logic.operators.TypeOperator;

import java.util.*;

/**
 * Класс для работы со списком "плоских" строк
 * <p/>
 *
 */
public class CalcList {

    /**
     * Приватная переменная. Инициализируется в конструкторе
     * Изменяется в процессе работы над списком
     */
    List<String> list;

    /**
     * Базовый конструктор
     * @param list
     */
    public CalcList(List<String> list) {
        this.list = list;
    }

    /**
     * Запускает обработку списка "плоских" строк
     * Используется рекурсия для парсинга спецсимвола для вычисления значений в скобках
     * В итоге список преобразуется в "плоскую" строку где есть только значения и операторы
     * все скобки уже разобраны и значения вычислены
      * @return
     * @throws Exception
     */
    public double calcFlatList() throws Exception {

        String sFlat = "";
        for (String s : list) {
            if ("".equals(s.trim())) continue;
            if (s.contains(TypeOperator.DELIMETER.getOperator().get(0))) {
                String sCalc = calcFlatString(s);
                sFlat += " " + sCalc;
            } else sFlat += " " + s.trim();
        }
        String result = calcFlatString(sFlat.trim());
        return Double.parseDouble(result);
    }


    /**
     * Функция высчитывает значение строки в которой нет скобок.
     * Строка может содержать вложенные скобки, помеченные спецсимволом
     * Самая последняя вложенная скобка стоит в конце строки
     * Разбор строки начинаем с самого конца.
     * Используем рекурсию до тех пор, пока не посчитаем значение всех вложенных скобок
     * @param sInput
     * @return String
     */
    private String calcFlatString(String sInput) throws Exception {
        double dResult;


        try {
            String sWork = new String(sInput);
            String delimeter = TypeOperator.DELIMETER.getOperator().get(0);

            while (sWork.contains(delimeter)) {
                int iLast = sWork.lastIndexOf(delimeter);
                sWork = sWork.substring(0, iLast) + calcFlatString(sWork.substring(iLast + 1));
            }

            List<String> list = new ArrayList<String>();
            list.addAll(Arrays.asList(sWork.split(" ")));

            int now = 1;
            while (list.size() > 3) {
                Operator opA = new Operator(list.get(now).charAt(0));
                if ((now + 2) < (list.size())) {
                    Operator opB = new Operator(list.get(now + 2).charAt(0));

                    if (opA.getTypeOperator().getPriority() < opB.getTypeOperator().getPriority()) {
                        now += 2;
                        continue;
                    }
                }

                Action action = new Action(opA);
                double dA = Double.parseDouble(list.get(now - 1));
                double dB = Double.parseDouble(list.get(now + 1));

                list.set(now - 1, action.calculate(dA, dB) + "");
                list.remove(now + 1);
                list.remove(now);
                now -= 2;

            }


            if (list.size() == 3) {
                Operator opA = new Operator(list.get(1).charAt(0));
                Action action = new Action(opA);
                double dA = Double.parseDouble(list.get(0));
                double dB = Double.parseDouble(list.get(2));
                dResult = action.calculate(dA, dB);
            } else if (list.size() == 1)
                dResult = Double.parseDouble(list.get(0));
            else throw new IllegalArgumentException("");

        } catch (NumberFormatException e) {
            throw new NumberFormatException("Ошибка ввода данных.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Ошибка при разборе параметров строки.");
        }catch (StringIndexOutOfBoundsException e) {
            throw new StringIndexOutOfBoundsException("Деление на ноль");
        }

        return String.format("%.2f", dResult);
    }


}
