package com.sysgears.calculator.user;

/**
 * Type of supported commands
 */
public enum CommandType {

    /**
     * Types of command
     */
    INTRO("intro", "Вызов приветствия"),
    STRING("", "вычисляемая строка"),
    HISTORY("history", "полная история операций"),
    HISTORYU("history unique", "история операций. Только уникальные строки"),
    HELP("help", "Вызов помощи"),
    QUIT("quit", "Выход из программы");

    /**
     * How to call the command
     */
    private final String command;

    /**
     * Description of command
     */
    private final String description;

    /**
     * Set command and description
     *
     * @param command  mnemonic string of Command
     * @param description string description of command
     */
    CommandType(String command, String description) {
        this.command = command;
        this.description = description;
    }

    /**
     * Return mnemonic string of command
     *
     * @return String how to call a command
     */
    public String getCommand() {
        return command;
    }

    /**
     * Return description of command
     *
     * @return String description of command
     */
    public String getDescription() {
        return description;
    }

}
