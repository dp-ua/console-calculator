package user;

/**
 * Типы доступных команд
 * <p/>
 * Программирование действий по командам задается в классе user.Action
 *
 */
public enum CommandType {
    /**
     * Типы команд
     */
    STRING("", "вычисляемая строка"),
    HISTORY("history", "полная история операций"),
    HISTORYU("history unique","история операций. Только уникальные строки"),
    HELP("help", "Вызов помощи"),
    QUIT("quit", "Выход из программы")
    ;

    /**
     * Приватная переменная. Синтаксис команды
     */
    private final String command;

    /**
     * Описание команды. Используется для формирования справки по программе
     */
    private final String description;

    /**
     * Базовый конструктор
     * @param command команда
     * @param description  описание
     */
    CommandType(String command, String description) {
        this.command = command;
        this.description = description;
    }

    /**
     * геттер
     * @return команда
     */
    public String getCommand() {
        return command;
    }

    /**
     * геттер
     * @return описание
     */
    public String getDescription() {
        return description;
    }

    /**
     * Все что не STRING - команда
     * @return boolean команда или нет
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
