package com.sysgears.calculator.user;

import com.sysgears.calculator.calculations.Calculate;
import com.sysgears.calculator.calculations.operators.ListOperators;

import java.util.List;
import java.util.Map;

public class Messages {
    private final UserView userView;

    public Messages(UserView userView) {
        this.userView = userView;
    }

    public void quit() {
        userView.send("Выход");
    }

    public void waitForInput() {
        userView.send("Введите команду или строку для просчета:");
    }

    /**
     * show intro message to user
     */
    public void intro() {
        userView.send("Для вызова справки введите " + CommandType.HELP.getCommand());
        userView.send("Введите строку для расчета или команду.");
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

    public void result(double dInput) {
        String s = String.format("::Результат: %.2f", dInput);
        userView.send(s);
    }

    /**
     * Show error message to user
     *
     * @param sInput text of Error
     */
    public void error(String sInput) {
        userView.send("::Ошибка:: " + sInput);
    }


}
