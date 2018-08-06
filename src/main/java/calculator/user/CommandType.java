package calculator.user;

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
     * @param command string
     * @param description  string
     */
    CommandType(String command, String description) {
        this.command = command;
        this.description = description;
    }

    /**
     * return command
     * @return String
     */
    public String getCommand() {
        return command;
    }

    /**
     * return description of command
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * type is a command or not
     * @return if Type is STRING - return false. Other - return true
     */
    public boolean isCommand() {
        switch (this) {
            case STRING:
                return false;
            default:
                return true;
        }
    }
}
