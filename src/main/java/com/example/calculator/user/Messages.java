package com.example.calculator.user;

import com.example.calculator.calculation.operators.OperatorTypes;

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
     * Show information about showQuit
     */
    public void showQuit() {
        userView.send("Выход");
    }

    /**
     * Show invitation string for data entry
     */
    public void showWaitForInput() {
        userView.send("Введите команду или строку для просчета:");
    }

    /**
     * Show welcome message
     */
    public void showIntro() {
        userView.send("Для вызова справки введите " + CommandType.HELP.getCommand());
    }

    /**
     * Show showError message
     *
     * @param errorMessage text of Error
     */
    public void showError(String errorMessage) {
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
        for (String s : list) userView.send(s);
    }

    /**
     * Show sting with showResult of operation
     *
     * @param result of operation
     */
    public String showResult(double result) {
        String s = String.format("::Результат: %.2f", result);
        userView.send(s);
        return s;

    }

    /**
     * Show showHelp to user about all operators and commands
     */
    public void showHelp() {
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
            for (Map.Entry<String, String> pair : OperatorTypes.values()[0].getOperators((byte) i).entrySet())
                userView.send("    " + pair.getKey() + " " + pair.getValue());
        }
        userView.send("  -разделители: ");
        for (Map.Entry<String, String> pair : OperatorTypes.values()[0].getOperators((byte) 8).entrySet())
            userView.send("    " + pair.getKey() + " " + pair.getValue());
        userView.send("  -если перед или после разделителя вы не укажите оператор - он будет заменен на: ");
        userView.send("    " + OperatorTypes.DEF.getOperator().get(0) + " " + OperatorTypes.DEF.getDescription());
        userView.send("    пример: 2(5-2) воспринимается как 2" + OperatorTypes.DEF.getOperator().get(0) + "(5-2)");
        userView.send("==============================================================================");
    }
}
