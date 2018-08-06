package calculator.logic.operators;

import static calculator.logic.operators.TypeOperator.*;

/**
 * class for work with basic operators
 */
public class Operator {

    /**
     * Type of operator
     */
    TypeOperator typeOperator;

    /**
     * set the basic operator
     * @param cOperator symbol of working operator
     */
    public Operator(char cOperator) {
        typeOperator = getTypeByString(cOperator);
    }

    /**
     * Specifies the type of operator by the entered character
     * @param cInput character of operator
     * @return TypeOperator
     */
    private TypeOperator getTypeByString(char cInput) {
        for (TypeOperator t : values())
            for (String s : t.getOperator())
                if (cInput == s.charAt(0)) return t;
        return NON;
    }

    /**
     * get Type of Operator
     * @return TypeOperator
     */
    public TypeOperator getTypeOperator() {
        return typeOperator;
    }

    /**
     * checks the type of the operator
     * @return returns true if the operator is specified
     */
    public boolean isOperator() {
        switch (typeOperator) {
            case NON:
            case OPENBRACKETS:
            case CLOSEBRACKETS:
            case DELIMETER:
                return false;
        }
        return true;

    }

    /**
     * Make the necessary actions on the specified operands
     * @param dA first operand
     * @param dB second operand
     * @return result of operations
     * @throws IllegalArgumentException if take non specified result
     */
    public double calculate(double dA, double dB) throws IllegalArgumentException {
        switch (typeOperator) {
            case PLUS:
                return dA + dB;
            case MINUS:
                return dA - dB;
            case MULT:
                return dA * dB;
            case DIV:
                double r = dA / dB;
                if (Double.isInfinite(r)) throw new ArithmeticException("Деление на ноль");
                if (Double.isNaN(r)) throw new ArithmeticException("Результат деления: NaN");
                return r;
            case PERCENT:
                return (dA / 100) * dB;
            case POW:
                return Math.pow(dA, dB);
            case NON:
            default:
                throw new IllegalArgumentException("Неверный тип оператора");
        }
    }

}
