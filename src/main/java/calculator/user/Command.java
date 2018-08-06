package calculator.user;

import calculator.history.History;
import calculator.logic.operators.ListOperators;
import java.util.Map;

/**
 * class implements all commands of project
 */
public class Command {

    /**
     * communicate with user variable
     */
    UserView userView;

    /**
     * variable to work with the history storage
     */
    History history;

    /**
     * Set userView and history variables
     * @param userView
     * @param history
     */
    public Command(UserView userView, History history) {
        this.userView = userView;
        this.history = history;
    }

    /**
     * Set only userView variable
     * @param userView
     */
    public Command(UserView userView) {
        this.userView = userView;
    }

    /**
     * show intro message to user
     */
    public void showIntro() {
        userView.send("Для вызова справки введите " + CommandType.HELP.getCommand());
        userView.send("Введите строку для расчета или команду.");
    }

    /**
     * make some actions
     * @param commandType entered type of command
     */
    public void doCommand(CommandType commandType) {
        switch (commandType) {
            case INTRO:
                showIntro();
                break;
            case QUIT:
                userView.send(commandType.getDescription());
                break;
            case HELP:
                showHelp();
                break;
            case HISTORY:
                showHistory();
                break;
            case HISTORYU:
                showUniqueHistory();
                break;
            default:
        }
    }

    /**
     * detect which type of command in entered string
     * @param input string from user input
     * @return type of command
     */
    public CommandType detectCommandType(String input) {
        for (CommandType t : CommandType.values()) {
            if (t.getCommand().equals(input.trim())) return t;
        }
        return CommandType.STRING;
    }

    /**
     * Show help to user about all operators and commands
     */
    private void showHelp() {
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

    /**
     * Show list of unique entrys from history storage
     */
    private void showUniqueHistory() {
        for (Map.Entry<String, String> pair : history.getListUnique().entrySet()) {
            userView.send(pair.getKey() + " Результат: " + pair.getValue());
        }
    }

    /**
     * show all entrys from history storage
     */
    private void showHistory() {
        for (String[] s : history.getListFull()) {
            userView.send(s[0] + " Результат: " + s[1]);
        }
    }

    /**
     * show message "Result...." to user
     * @param dInput result of calculation
     */
    public void showResult(double dInput) {
        String s = String.format("::Результат: %.2f", dInput);
        userView.send(s);
    }

    /**
     * Show error message to user
     * @param sInput text of Error
     */
    public void showError(String sInput) {
        userView.send("::Ошибка:: " + sInput);
    }


    /**
     * Save input string and result of calculations to history storage
     * @param input basic input string
     * @param result result of calculations
     */
    public void saveHistory(String input, String result) {
        history.save(input, result);
    }

}
