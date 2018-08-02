package logic.parse;

import logic.operators.Operator;
import logic.operators.TypeOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Класс для работы с первичной введеной строкой.
 * <p/>
 * Преобразует входную строку в список, где каждый элемент представляет
 * из себя "плоскую" строку без скобок
 * в которой есть:
 * либо только числ
 * оператор
 * выражение с числами и оператором - результат разбора скобки
 */
public class ParseToList {

    /**
     *Входная не изменяема строка
     * Инициализируется только в конструкторе.
     * В процессе не изменяется
     */
    String sInput;

    /**
     * Конструктор
     * @param sInput
     */
    public ParseToList(String sInput) {
        this.sInput = sInput;
    }

    /**
     * Разбирает входную строку на список из "плоских" строк
     * "Плоская" строка - строка без скобок.
     * Операция внутри скобок помечается системным символом и подлежит разборки с конца строки
     * т.к. может иметь вложенные скобки.
     * @return
     * @throws IllegalArgumentException
     * @throws NullPointerException
     */
    public List<String> getWorkList() throws IllegalArgumentException, NullPointerException {
        List<String> list = new ArrayList<String>();
        String openBr = TypeOperator.OPENBRACKETS.getOperator().get(0);
        String closeBr = TypeOperator.CLOSEBRACKETS.getOperator().get(0);
        int openBracket = sInput.replaceAll("[^" + openBr + "]", "").length();
        int closeBracket = sInput.replaceAll("[^" + closeBr + "]", "").length();
        String delimeter = TypeOperator.DELIMETER.getOperator().get(0);
        if (sInput.contains(delimeter)) throw new IllegalArgumentException("В строке введен служебный символ "+delimeter);
        if ("".equals(sInput.trim())) throw new NullPointerException("Введена пустая строка");
        if (openBracket != closeBracket)
            throw new IllegalArgumentException("Не совпадает колличество открытых и закрытых скобок");
        Stack<String> stack = new Stack<String>();
        String sTmp = "";

        for (char c : sInput.toCharArray()) {
            Operator operator = new Operator(c);
            if (c == '-' & "".equals(sTmp)) {
                sTmp += "-";
            } else if (operator.getTypeOperator()==TypeOperator.OPENBRACKETS) {
                if (sTmp.trim().length() > 0) {
                    stack.push(sTmp.trim());
                    stack.push(operator.getDefaultOperator());
                }
                stack.push(openBr);
                sTmp = "";
            } else if (operator.getTypeOperator()==TypeOperator.CLOSEBRACKETS) {
                stack.push(sTmp);
                sTmp = "";
                while (!stack.empty()) {
                    if (!openBr.equals(stack.peek())) {
                        sTmp = " " + stack.pop() + sTmp;
                    } else {
                        stack.pop();
                        stack.push(delimeter + sTmp.trim());
                        sTmp = "";
                        break;
                    }
                }
                if (stack.empty())
                    throw new IllegalArgumentException("Ошибка разбора скобок. Проверьте правильность выражения");
            } else if (operator.isOperator()) {
                stack.push(sTmp.trim());
                stack.push(c + "");
                sTmp = "";
            } else {
                if (stack.size() > 0)
                    if (stack.peek().charAt(0) == delimeter.charAt(0)) stack.push(operator.getDefaultOperator());
                sTmp += c;
            }
        }

        if (sTmp.length() > 0) stack.push(sTmp);
        while (!stack.empty())

        {
            String s = stack.pop();
            if (!"".equals(s)) list.add(0, s);
        }


        return list;
    }


}
