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
    private final TypeOperator defaultOperator = MULT; //Какой оператор будет выполнятся, если не указан оператор перед и после скобки

    /**
     *Принимает в конструкторе символ оператора и определяет что это за оператор
     * @param cOperator символ оператора
     */
    public Operator(char cOperator) {
        typeOperator = getTypeByString(cOperator);
    }

    /**
     * Преобразовывает символ операции в тип операции
     * @param cInput символ оператора
     * @return TypeOperator тип оператора
     */
    private TypeOperator getTypeByString(char cInput) {
        for (TypeOperator t : values())
            for (String s : t.getOperator())
                if (cInput == s.charAt(0)) return t;
        return NON;
    }

    /**
     * геттер
     * @return тип оператора
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
     * @return TypeOperator возвращает оператор по-умолчанию
     */
    public String getDefaultOperator() {
        return defaultOperator.getOperator().get(0);
    }


    /**
     * метод использовался больше в отладчике, чтобы сразу было видно какой тип оператора присвоился
     * В программе нигде не используется
     * @return String название оператора
     */
    @Override
    public String toString() {
        return typeOperator.toString();
    }
}
