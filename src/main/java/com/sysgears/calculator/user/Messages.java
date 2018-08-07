package com.sysgears.calculator.user;

import com.sysgears.calculator.calculation.Calculate;
import com.sysgears.calculator.calculation.operators.ListOperators;

import java.util.List;
import java.util.Map;


/**
 * Send basic messages to user via UserView
 */
public class Messages {

    /**
     * User interface
     */
    private final UserView userView;

    /**
     * Set user interface
     *
     * @param userView user interface
     */
    public Messages(UserView userView) {
        this.userView = userView;
    }

    /**
     * Show information about quit
     */
    public void quit() {
        userView.send("Выход");
    }

    /**
     * Show invitation string for data entry
     */
    public void waitForInput() {
        userView.send("Введите команду или строку для просчета:");
    }

    /**
     * Show welcome message
     */
    public void intro() {
        userView.send("Для вызова справки введите " + CommandType.HELP.getCommand());
        userView.send("Введите строку для расчета или команду.");
    }

    /**
     * Show error message
     *
     * @param errorMessage text of Error
     */
    public void error(String errorMessage) {
        userView.send("::Ошибка:: " + errorMessage);
    }

    /**
     * Show list to user.
     * <p>
     * Take list of Strings, calculate it and show to user
     *
     * @param list of strings
     */
    public void showList(List<String> list) {
        if (list.size() == 0) return;
        for (String s : list) {
            try {
                userView.send(s + " = " + new Calculate(s).calculate());
            } catch (Exception e) {
                userView.send(s + " = " + e.getMessage());
            }
        }
    }

    /**
     * Show sting with result of operation
     *
     * @param result of operation
     */
    public void result(double result) {
        String s = String.format("::Результат: %.2f", result);
        userView.send(s);
    }

    /**
     * Show help to user about all operators and commands
     */
    public void help() {
        userView.send("Консольный калькулятор");
        userView.send("Вычисляет значение введеной строки");
        userView.send("Входные данные могут быть: ");
        for (CommandType type : CommandType.values()) {
            if (type == CommandType.STRING) {
                userView.send(" * " + type.getDescription());
            } else userView.send(" * " + type.getCommand() + " - " + type.getDescription());
        }
        userView.send("Поддерживаются целые числа, операторы и приоритетные разделители(скобки)");
        userView.send("Список операторов:");
        for (int i = 1; i < 6; i++) {
            userView.send("  -приоритет [" + i + "]: ");
            for (Map.Entry<String, String> pair : new ListOperators((byte) i).getOperators().entrySet())
                userView.send("    " + pair.getKey() + " " + pair.getValue());
        }
        userView.send("  -разделители: ");
        for (Map.Entry<String, String> pair : new ListOperators((byte) 8).getOperators().entrySet())
            userView.send("    " + pair.getKey() + " " + pair.getValue());
        userView.send("  -системные символы: ");
        for (Map.Entry<String, String> pair : new ListOperators((byte) 9).getOperators().entrySet())
            userView.send("    " + pair.getKey() + " " + pair.getValue());
        userView.send("==============================================================================");
    }
}
