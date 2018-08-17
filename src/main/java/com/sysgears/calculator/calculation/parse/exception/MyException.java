package com.sysgears.calculator.calculation.parse.exception;

/**
 * Personal Excenption class
 */
public class MyException extends Exception {

    private final TypeExtention typeExtention;
    private final String message;

    public MyException(TypeExtention typeExtention) {
        this.typeExtention = typeExtention;
        this.message=typeExtention.getDescription();
    }

    public MyException(String message) {
        this.typeExtention=TypeExtention.STANDART;
        this.message=message;
        }

    @Override
    public String getMessage() {
        return message;
    }
}
