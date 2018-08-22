package com.sysgears.calculator.calculation.parse.exception;

/**
 * Exception handling that occurs during the costing process.
 * <p>
 * Invalid parsing of string parameters
 * Using incorrect operators
 * Error parsing the parentheses
 * Errors in arithmetic operations
 */
public class CallculationExceptions extends Exception {

    private final ExceptionTypes exceptionTypes;
    private final String message;

    public CallculationExceptions(ExceptionTypes exceptionTypes) {
        this.exceptionTypes = exceptionTypes;
        this.message = exceptionTypes.getDescription();
    }

    public CallculationExceptions(String message) {
        this.exceptionTypes = ExceptionTypes.STANDART;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
