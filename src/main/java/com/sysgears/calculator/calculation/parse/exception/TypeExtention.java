package com.sysgears.calculator.calculation.parse.exception;

/**
 * Enum for personal Exception
 *
 * Set standart type of extentions and descriptions for it
 */
public enum TypeExtention {
    NAN("ошибка: деление на ноль"),
    BRACKETS("ошибка разбора скобок"),
    STANDART("ошибка вычисления значения выражения"),
    DATA("ошибка ввода данных"),
    PARAMS("ошибка разбора параметров строки"),
    BLANK("введена пустая строка")
    ;

    /**
     * Description of Exception
     */
    private final String description;

    /**
     * Get description
     *
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set description
     *
     * @param description of Exception
     */
    TypeExtention(String description) {
        this.description = description;
    }
}
