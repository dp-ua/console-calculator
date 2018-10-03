package com.example.calculator.calculation.parse.exception;

/**
 * Types of exception handling.
 *
 */
public enum ExceptionTypes {
    NAN("error: devide by Zero"),
    BRACKETS("error parsing the brackets"),
    STANDART("error evaluating the expression value"),
    DATA("input error"),
    PARAMS("error parsing string parameters"),
    BLANK("error: an empty string is entered")
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
    ExceptionTypes(String description) {
        this.description = description;
    }
}
