package com.sysgears.calculator.calculation.operators;

import com.sysgears.calculator.calculation.operators.performers.*;
import com.sysgears.calculator.calculation.parse.exception.MyException;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * List of all supported operators
 */
public enum TypeOperator {

    /**
     * List of opertarors. Format: operator, priority, description, isOperrator, Performer
     */
    PLUS(asList("+"), (byte) 1, "сложение", true, new Plus()),
    MINUS(asList("-"), (byte) 1, "вычитание", true, new Minus()),
    MULT(asList("*"), (byte) 2, "умножение", true, new Mult()),
    DIV(asList("/", ":"), (byte) 2, "деление", true, new Div()),
    MOD(asList("m"),(byte) 2, "остаток от деления", true, new Mod()),
    PERCENT(asList("%"), (byte) 3, "процент от числа", true, new Percent()),
    POW(asList("^"), (byte) 4, "возведение в степень", true, new Pow()),
    OPENBRACKETS(asList("(","[","{"), (byte) 8, "открывающая скобка", false, new Blank()),
    CLOSEBRACKETS(asList(")","]","}"), (byte) 8, "закрывающая скобка", false,new Blank()),
    DELIMETER(asList("$"), (byte) 9, "служебный символ", false,new Blank()),
    NON(asList("non"), (byte) 0, "пустой оператор", false,new Blank()),
    DEF(TypeOperator.MULT),
    ;

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
     * Type of character. Is the symbol the operator or not
     */
    private final boolean isOperator;

    private final AbstractPerformer performer;

    /**
     * Sets the parameters the same as for the specified operator
     *
     * @param typeOperator another TypeOperator
     */
    TypeOperator(TypeOperator typeOperator) {
        this.operator=typeOperator.operator;
        this.priority=typeOperator.priority;
        this.description=typeOperator.description;
        this.isOperator=typeOperator.isOperator;
        this.performer=typeOperator.performer;
    }

    /**
     * Set basic params for Enum
     *
     * @param operator - symbols denoting the given operator
     * @param priority - priority of operator
     * @param description - descriptions of operator
     * @param isOperator - Is the character an operator
     * @param perfomer - action performed by the operator
     */
    TypeOperator(List<String> operator, byte priority, String description, boolean isOperator, AbstractPerformer perfomer) {
        this.operator = operator;
        this.priority = priority;
        this.description = description;
        this.isOperator = isOperator;
        this.performer=perfomer;
    }

    /**
     * Produce needed operations with two operands
     *
     * @param firstOperand  - first operand in operations
     * @param secondOperand - second operand in operations
     * @return double result of operations
     * @throws IllegalArgumentException if take non specified result of calculations
     */
    public double produce(double firstOperand, double secondOperand) throws MyException {
        return performer.perform(firstOperand,secondOperand);
    }

    /**
     * getAll Description of operator
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

    /**
     * Get information about the type of the character. Is he an operator.
     *
     * @return boolean. True - if operator and false - if not
     */
    public boolean isOperator() {
        return isOperator;
    }
}