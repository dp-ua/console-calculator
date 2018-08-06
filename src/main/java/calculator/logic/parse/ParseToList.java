package calculator.logic.parse;

import calculator.logic.operators.Operator;
import calculator.logic.operators.TypeOperator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * class for work with input string
 */
public class ParseToList {

    /**
     * string for work
     */
    private final String sInput;

    /**
     * set input string
     * @param sInput
     */
    public ParseToList(String sInput) {
        this.sInput = sInput;
    }

    /**
     * parse main string to list of "flat" lines
     * "Flat" string - string without brackets
     * @return list of "flat" lines
     * @throws IllegalArgumentException if there were errors during the parsing of the line
     * @throws NullPointerException if take blank string
     */
    public List<String> getWorkList() throws IllegalArgumentException, NullPointerException {
        List<String> list = new ArrayList<String>();

        if ("".equals(sInput.trim())) throw new NullPointerException("Введена пустая строка");

        String defOperator = TypeOperator.DEF.getOperator().get(0);
        String openBr = TypeOperator.OPENBRACKETS.getOperator().get(0);

        String delimeter = TypeOperator.DELIMETER.getOperator().get(0);
        if (sInput.contains(delimeter)) throw new IllegalArgumentException("В строке введен служебный символ "+delimeter);


        String sTmp = "";
        Stack<String> stack = new Stack<String>();

        for (char c : sInput.toCharArray()) {
            Operator operator = new Operator(c);
            if (c == '-' & "".equals(sTmp)) {
                sTmp += "-";
            } else if (operator.getTypeOperator()==TypeOperator.OPENBRACKETS) {
                if (sTmp.trim().length() > 0) {
                    stack.push(sTmp.trim());
                    stack.push(defOperator);
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
                    if (stack.peek().charAt(0) == delimeter.charAt(0)) stack.push(defOperator);
                sTmp += c;
            }
        }

        if (sTmp.length() > 0) stack.push(sTmp);
        while (!stack.empty())

        {
            String s = stack.pop();
            if (!"".equals(s)) list.add(0, s);
        }

        if (list.contains(openBr)) throw new IllegalArgumentException("Ошибка разбора скобок. Проверьте правильность выражения");

        return list;
    }


}
