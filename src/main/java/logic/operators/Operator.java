package logic.operators;

import static logic.operators.TypeOperator.*;

/**
 * Класс для работы со списком операторов TypeOperator
 * <p/>
 * кроме работы с текущим оператором также задает такой параметр как defaultOperator
 * данный оператор необходим для корректного парсинга строки вида 1(1+2)
 * Пропущенный оператор  перед или после скобки заменяется на этот стандартный оператор
 */
public class Operator {

    /**
     * Базовая приватная переменная.
     * Инициализируется в конструкторе и не изменяется
     */
    TypeOperator typeOperator;

    /**
     * Финальная инициализация переменной, которая отвечает за стандартный оператор
     */
    final TypeOperator defaultOperator = MULT; //Какой оператор будет выполнятся, если не указан оператор перед и после скобки

    /**
     *
     * @param cOperator
     */
    public Operator(char cOperator) {
        typeOperator = getTypeByString(cOperator);
    }

    /**
     * Преобразовывает символ операции в тип операции
     * @param cInput
     * @return TypeOperator
     */
    private TypeOperator getTypeByString(char cInput) {
        TypeOperator result = NON;
        for (TypeOperator t : values())
            for (String s : t.getOperator())
                if (cInput == s.charAt(0)) return t;
        return result;
    }

    /**
     *
     * @return
     */
    public TypeOperator getTypeOperator() {
        return typeOperator;
    }

    /**
     * Проверяет, оператор это или нет. К операторам не относятся числа, разделители и служебные символы
     * @return boolean
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
     * Возвращает дефолтный оператор.
     * @return
     */
    public String getDefaultOperator() {
        return defaultOperator.getOperator().get(0);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return typeOperator.toString();
    }
}
