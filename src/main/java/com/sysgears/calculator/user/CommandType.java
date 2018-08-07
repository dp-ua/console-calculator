package com.sysgears.calculator.user;

/**
 * Type of commands
 */
public enum CommandType {

    INTRO("intro", "Вызов приветствия"),
    STRING("", "вычисляемая строка"),
    HISTORY("history", "полная история операций"),
    HISTORYU("history unique", "история операций. Только уникальные строки"),
    HELP("help", "Вызов помощи"),
    QUIT("quit", "Выход из программы");

    /**
     * command
     */
    private final String command;

    /**
     * description of command
     */
    private final String description;

    /**
     * set command and description
     *
     * @param command     string
     * @param description string
     */
    CommandType(String command, String description) {
        this.command = command;
        this.description = description;
    }

    /**
     * Return command
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
