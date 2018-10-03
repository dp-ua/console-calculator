package com.example.calculator.user;

/**
 * Detect the type of user input
 */
public class Command {

     /**
     * Detect which type of command in entered string
      *
     * @return type of command
     */
    public CommandType detectCommandType(String input) {
        for (CommandType t : CommandType.values()) {
            if (t.getCommand().equals(input.trim())) return t;
        }
        return CommandType.STRING;
    }


}
