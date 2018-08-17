package com.sysgears.calculator.calculation.parse;

import com.sysgears.calculator.calculation.operators.Operator;
import com.sysgears.calculator.calculation.operators.TypeOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Take the string and parse it to List of operands, operators and "flat" strings without brackets
 */
public class StringToFlatLinesList {

    /**
     * String for work
     */
    private final String input;

    /**
     * Set input string
     *
     * @param input string fo parse
     */
    public StringToFlatLinesList(String input) {
        this.input = input;
    }

    /**
     * Parse main string to list of "flat" lines
     *
     * "Flat" string - string without brackets.
     * @return List of "flat" lines
     * @throws IllegalArgumentException if there were errors during the parsing of the line
     */
    public List<String> parse() throws IllegalArgumentException {
        List<String> list = new ArrayList<String>();

        if ("".equals(input.trim())) throw new IllegalArgumentException("Введена пустая строка");

        String defOperator = TypeOperator.DEF.getOperator().get(0);
        String openBr = TypeOperator.OPENBRACKETS.getOperator().get(0);
        String delimeter = TypeOperator.DELIMETER.getOperator().get(0);
        String minus = TypeOperator.MINUS.getOperator().get(0);

        if (input.contains(delimeter)) throw new IllegalArgumentException("В строке введен служебный символ "+delimeter);

        String pile = "";
        Stack<String> stack = new Stack<String>();

        for (char c : input.toCharArray()) {
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