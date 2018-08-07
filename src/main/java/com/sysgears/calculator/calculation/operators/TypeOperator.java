package com.sysgears.calculator.calculation.operators;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * List of all supported operators
 */
public enum TypeOperator {

    /**
     * List of opertarors. Format: operator, priority, description
     */
    PLUS(asList("+"), (byte) 1, "сложение"),
    MINUS(asList("-"), (byte) 1, "вычитание"),
    MULT(asList("*"), (byte) 2, "умножение"),
    DIV(asList("/", ":"), (byte) 2, "деление"),
    PERCENT(asList("%"), (byte) 3, "процент"),
    POW(asList("^"), (byte) 4, "возведение в степень"),
    OPENBRACKETS(asList("("), (byte) 8, "открывающая скобка"),
    CLOSEBRACKETS(asList(")"), (byte) 8, "закрывающая скобка"),
    DELIMETER(asList("$"), (byte) 9, "служебный символ"),
    NON(asList("non"), (byte) 0, "пустой оператор"),
    DEF(asList("*"), (byte) 0, "оператор по-умолчанию"),;


    /**
     * Symbols of operator
     */
    private final List<String> operator;

    /**
     * Priority of operator
     */
    private final byte priority;

    /**
     * Description of all operator
     */
    private final String description;

    /**
     * Set basic params for Enum
     *
     * @param operator    list of operators
     * @param priority    priority of operator
     * @param description descriptions
     */
    TypeOperator(List<String> operator, byte priority, String description) {
        this.operator = operator;
        this.priority = priority;
        this.description = description;
    }

    /**
     * Produce needed operations with two operands
     *
     * @param firstOperand - first operand in operations
     * @param secondOperand - second operand in operations
     * @return double result of operations
     * @throws IllegalArgumentException if take non specified result or an error in the calculation
     */
    public double produce(double firstOperand, double secondOperand) throws IllegalArgumentException {
        switch (this) {
            case PLUS:
                return firstOperand + secondOperand;
            case MINUS:
                return firstOperand - secondOperand;
            case MULT:
                return firstOperand * secondOperand;
            case DIV:
                double r = firstOperand / secondOperand;
                if (Double.isInfinite(r)) throw new ArithmeticException("Деление на ноль");
                if (Double.isNaN(r)) throw new ArithmeticException("Результат деления: NaN");
                return r;
            case PERCENT:
                return (firstOperand / 100) * secondOperand;
            case POW:
                return Math.pow(firstOperand, secondOperand);
            case NON:
            default:
                throw new IllegalArgumentException("Неверный тип оператора");

        }
    }


    /**
     * get Description of operator
     *
     * @return description of operator
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get String list of operators of selected type
     *
     * @return List<String> all supported operators</>
     */
    public List<String> getOperator() {
        return operator;
    }

    /**
     * Get priority of operator
     *
     * @return byte priority of selected operator
     */
    public byte getPriority() {
        return priority;
    }
}