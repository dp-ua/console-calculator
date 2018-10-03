package com.example.calculator.parse.operators;

import com.example.calculator.calculation.parse.operators.performers.*;
import com.example.calculator.parse.exception.CallculationExceptions;
import com.example.calculator.parse.operators.performers.*;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Arrays.asList;

/**
 * List of all supported operators
 */
public enum OperatorTypes {

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
    DEF(OperatorTypes.MULT),
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
     * @param operatorTypes another OperatorTypes
     */
    OperatorTypes(OperatorTypes operatorTypes) {
        this.operator= operatorTypes.operator;
        this.priority= operatorTypes.priority;
        this.description= operatorTypes.description;
        this.isOperator= operatorTypes.isOperator;
        this.performer= operatorTypes.performer;
    }

    /**
     * Set basic params for Enum
     *
     * @param operator - symbols denoting the given operator
     * @param priority - priority of operator
     * @param description - descriptions of operator
     * @param isOperator - Is the character an operator
     * @param performer - action performed by the operator
     */
    OperatorTypes(List<String> operator, byte priority, String description, boolean isOperator, AbstractPerformer performer) {
        this.operator = operator;
        this.priority = priority;
        this.description = description;
        this.isOperator = isOperator;
        this.performer=performer;
    }

    /**
     * Produce needed operations with two operands
     *
     * @param firstOperand  - first operand in operations
     * @param secondOperand - second operand in operations
     * @return double result of operations
     * @throws IllegalArgumentException if take non specified result of calculations
     */
    public double produce(double firstOperand, double secondOperand) throws CallculationExceptions {
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

    /**
     * Get Map of operators with the specified priority
     *
     * @return Map<String,String>key - operator. value - description </String>
     */
    public Map<String, String> getOperators(byte priority) {
        Map<String, String> map = new TreeMap<>();
        for (OperatorTypes t : OperatorTypes.values())
            if (t.getPriority() == priority) for (String s : t.getOperator()) map.put(s, t.getDescription());
        return map;
    }

}