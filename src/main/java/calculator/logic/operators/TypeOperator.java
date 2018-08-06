package logic.operators;

import java.util.List;
import static java.util.Arrays.asList;

/**
 * перечисление операторов и их приоритета
 * <p/>
  * В данном классе задаются сами операции, их описание и символы, по которым они
 * парсятся из строки
 * При добавлении новых названий операций список действий нужно прописать
 * отдельно в классе operators.Action
  */
public enum TypeOperator {

    /**
     * Список операторов
     */
    NON(asList("non"),(byte)0,"пустой оператор"),
    PLUS(asList("+"), (byte) 1,"сложение"),
    MINUS(asList("-"), (byte) 1,"вычитание"),
    MULT(asList("*"), (byte) 2,"умножение"),
    DIV(asList("/",":"), (byte) 2,"деление"),
    PERCENT(asList("%"), (byte) 3,"процент"),
    POW(asList("^"), (byte) 3,"возведение в степень"),
    OPENBRACKETS(asList("("),(byte)4,"открывающая скобка"),
    CLOSEBRACKETS(asList(")"),(byte)4,"закрывающая скобка"),
    DELIMETER(asList("$"),(byte)5,"служебный символ");

    /**
     * Приватная переменная.
     * Список, где указываются символы, соответствующие данной операции
     */
    private List<String> operator;

    /**
     * Приоритет операторов
     */
    private byte priority;

    /**
     * Описание оператора.
     * Используется для формирования help
     */
    private String description;

    /**
     *Базовый приватный конструктор
     * @param operator значения оператора. Задается в виде списка
     * @param priority приоритет
     * @param description описание
     */
     TypeOperator(List<String> operator, byte priority,String description) {
        this.operator = operator;
        this.priority = priority;
        this.description=description;
    }

    /**
     * геттер
     * @return String описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * геттер
     * @return List<String> список операторов</String>
     */
    public List<String> getOperator() {
        return operator;
    }

    /**
     * гетер
     * @return приоритет
     */
    public byte getPriority() {
        return priority;
    }
}