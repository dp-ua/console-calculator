package com.sysgears.calculator.calculation.parse;

import com.sysgears.calculator.calculation.operators.Operator;
import com.sysgears.calculator.calculation.operators.OperatorTypes;
import com.sysgears.calculator.calculation.parse.exception.CallculationExceptions;
import com.sysgears.calculator.calculation.parse.exception.ExceptionTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * Take the string and parse it to List of operands, operators and "flat" strings without brackets
 */
public class StringToFlatLinesList {

    /**
     * Parse main string to list of "flat" lines
     *
     * "Flat" string - string without brackets.
     * @return List of "flat" lines
     * @throws CallculationExceptions if there were errors during the parsing of the line
     */
    public List<String> parse(String input) throws CallculationExceptions {
        List<String> list = new ArrayList<>();

        if ("".equals(input.trim())) throw new CallculationExceptions(ExceptionTypes.BLANK);

        String defOperator = OperatorTypes.DEF.getOperator().get(0);
        String openBr = OperatorTypes.OPENBRACKETS.getOperator().get(0);
        String delimeter = OperatorTypes.DELIMETER.getOperator().get(0);
        String minus = OperatorTypes.MINUS.getOperator().get(0);

        if (input.contains(delimeter)) throw new CallculationExceptions(ExceptionTypes.STANDART);

        String pile = "";
        Stack<String> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            Operator operator = new Operator(c);
            if (c == minus.charAt(0) & "".equals(pile)) {
                pile += minus;
            } else if (operator.getOperatorTypes()==OperatorTypes.OPENBRACKETS) {
                if (pile.trim().length() > 0) {
                    stack.push(pile.trim());
                    stack.push(defOperator);
                }
                stack.push(openBr);
                pile = "";
            } else if (operator.getOperatorTypes()==OperatorTypes.CLOSEBRACKETS) {
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
                    throw new CallculationExceptions(ExceptionTypes.BRACKETS);
            } else if (operator.isOperator()) {
                stack.push(pile.trim());
                stack.push(Character.toString(c));
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

        if (list.contains(openBr)) throw new CallculationExceptions(ExceptionTypes.BRACKETS);

        return list;
    }


}
