package com.sysgears.calculator.calculations.parse;

import com.sysgears.calculator.calculations.operators.Operator;
import com.sysgears.calculator.calculations.operators.TypeOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class StringToFlatLinesList {

    /**
     * string for work
     */
    private final String sInput;

    /**
     * set input string
     * @param sInput
     */
    public StringToFlatLinesList(String sInput) {
        this.sInput = sInput;
    }

    /**
     * parse main string to list of "flat" lines
     * "Flat" string - string without brackets
     * @return list of "flat" lines
     * @throws IllegalArgumentException if there were errors during the parsing of the line
     * @throws NullPointerException if take blank string
     */
    public List<String> parse() throws IllegalArgumentException {
        List<String> list = new ArrayList<String>();

        if ("".equals(sInput.trim())) throw new IllegalArgumentException("Введена пустая строка");

        String defOperator = TypeOperator.DEF.getOperator().get(0);
        String openBr = TypeOperator.OPENBRACKETS.getOperator().get(0);
        String delimeter = TypeOperator.DELIMETER.getOperator().get(0);
        String minus = TypeOperator.MINUS.getOperator().get(0);

        if (sInput.contains(delimeter)) throw new IllegalArgumentException("В строке введен служебный символ "+delimeter);

        String pile = "";
        Stack<String> stack = new Stack<String>();

        for (char c : sInput.toCharArray()) {
            Operator operator = new Operator(c);
            if (c == minus.charAt(0) & "".equals(pile)) {
                pile += minus;
            } else if (operator.getTypeOperator()==TypeOperator.OPENBRACKETS) {
                if (pile.trim().length() > 0) {
                    stack.push(pile.trim());
                    stack.push(defOperator);
                }
                stack.push(openBr);
                pile = "";
            } else if (operator.getTypeOperator()==TypeOperator.CLOSEBRACKETS) {
                stack.push(pile);
                pile = "";
                while (!stack.empty()) {
                    if (!openBr.equals(stack.peek())) {
                        pile = " " + stack.pop() + pile;
                    } else {
                        stack.pop();
                        stack.push(delimeter + pile.trim());
                        pile = "";
                        break;
                    }
                }
                if (stack.empty())
                    throw new IllegalArgumentException("Ошибка разбора скобок. Проверьте правильность выражения");
            } else if (operator.isOperator()) {
                stack.push(pile.trim());
                stack.push(c + "");
                pile = "";
            } else {
                if (stack.size() > 0)
                    if (stack.peek().charAt(0) == delimeter.charAt(0)) stack.push(defOperator);
                pile += c;
            }
        }

        if (pile.length() > 0) stack.push(pile);
        while (!stack.empty())

        {
            String s = stack.pop();
            if (!"".equals(s)) list.add(0, s);
        }

        if (list.contains(openBr)) throw new IllegalArgumentException("Ошибка разбора скобок. Проверьте правильность выражения");

        return list;
    }


}
