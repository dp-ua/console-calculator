package calculator.logic.operators;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

/**
 * List of all supported operators
 */
public enum TypeOperator {

    /**
     * List of opertarors
     */

    PLUS(asList("+"), (byte) 1,"сложение"),
    MINUS(asList("-"), (byte) 1,"вычитание"),
    MULT(asList("*"), (byte) 2,"умножение"),
    DIV(asList("/",":"), (byte) 2,"деление"),
    PERCENT(asList("%"), (byte) 3,"процент"),
    POW(asList("^"), (byte) 4,"возведение в степень"),
    OPENBRACKETS(asList("("),(byte)8,"открывающая скобка"),
    CLOSEBRACKETS(asList(")"),(byte)8,"закрывающая скобка"),
    DELIMETER(asList("$"),(byte)9,"служебный символ"),
    NON(asList("non"),(byte)0,"пустой оператор"),
    DEF(asList("*"),(byte)0,"оператор по-умолчанию"),

    ;

    /**
     * enumeration of operator symbols
     */
    private List<String> operator;

    /**
     * priority of Operators
     */
    private byte priority;

    /** Descriptions of all opertators
     *  used to generate help
     */
    private String description;

    /**
     * set all basic params of Enum
     * @param operator list of operators
     * @param priority priority of operator
     * @param description descriptions
     */
     TypeOperator(List<String> operator, byte priority,String description) {
        this.operator = operator;
        this.priority = priority;
        this.description=description;
    }

    /**
     * get Description
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get list of operators
     * @return List<String> all supported operators</>
     */
    public List<String> getOperator() {
        return operator;
    }

    /**
     * get priority of operator
     * @return
     */
    public byte getPriority() {
        return priority;
    }

}