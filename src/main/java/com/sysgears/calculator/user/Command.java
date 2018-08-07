package com.sysgears.calculator.user;

/**
 * Detect the type of user input
 */
public class Command {

    /**
     *
     */
    private final String input;

    /**
     * Set input String
     * @param input work string or command
     */
    public Command(String input) {
        this.input = input;
    }

    /**
     * Detect which type of command in entered string
     * @return type of command
     */
    public CommandType detectCommandType() {
        for (CommandType t : CommandType.values()) {
            if (t.getCommand().equals(input.trim())) return t;
        }
        return CommandType.STRING;
    }


}
