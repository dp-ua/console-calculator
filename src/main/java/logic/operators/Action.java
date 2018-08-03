package logic.operators;

/**
 * Список действий для операторов
 * <p/>
 *
 */
public class Action {

    /**
     * Приватная переменная
     * устанавливается в конструкторе и не изменяется
     */
    private final Operator operator;

    /**
     * @param operator тип оператора
     */
    public Action(Operator operator) {
        this.operator = operator;
    }

    /**
     * Совершает нужную операцию, основываясь на типе установленной операции
     * @param dA первый операнд
     * @param dB второй операнд
     * @return double результат операции
     * @throws IllegalArgumentException ошибка в случае неудачи
     */
    public double calculate(double dA, double dB) throws IllegalArgumentException {
        switch (operator.typeOperator) {
            case PLUS:
                return dA + dB;
            case MINUS:
                return dA - dB;
            case MULT:
                return dA * dB;
            case DIV:
                double r =dA / dB;
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
