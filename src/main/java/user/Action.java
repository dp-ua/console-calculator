package user;


import history.DataInterface;
import history.DataStory;
import logic.operators.ListOperators;

import java.io.IOException;
import java.util.Map;

/**
 * Класс взаимодействия с пользователем через пользовательский интерфейс
 * <p/>
 * Выводит помощь, приветствие, результаты, сообщения об ошибках
 * Вводит пользовательские данные
 */
public class Action {

    /**
     * Интерфейс для общения с пользователем
     * Устанавливается в конструкторе. Не изменяется
     */
    UserInterface userInterface;
    DataInterface dataLoader;

    /**
     * Базовый конструктор
     * Инициализирует интерфейс для общения с пользователем
     * Инициализует хранилище для истории
     *
     * @param userInterface
     */
    public Action(UserInterface userInterface) {
        this.userInterface = userInterface;
        dataLoader = new DataInterface(new DataStory());
    }

    /**
     * Сохраняем строку и результат операции в хранилище
     *
     * @param sA
     * @param sB
     */
    public void saveHistory(String sA, String sB) {
        dataLoader.saveToHistory(sA, sB);
    }

    /**
     * Выполняет нужные действия в соотстветствии с типом команды
     *
     * @param commandType
     */
    public void doCommand(CommandType commandType) {
        switch (commandType) {
            case QUIT:
                userInterface.send(commandType.getDescription());
                break;
            case HELP:
                showHelp();
                break;
            case HISTORY:
                showHistory();
                break;
            case HISTORYU:
                showUniqHistory();
                break;
            default:
        }
    }

    /**
     * Показываем историю уникальных операций
     */
    private void showUniqHistory() {
        for (Map.Entry<String, String> pair : dataLoader.getListUniq().entrySet()) {
            userInterface.send(pair.getKey() + " Результат: " + pair.getValue());
        }

    }

    /**
     * Отображение полной истории операций
     */
    private void showHistory() {
        for (String[] s : dataLoader.getListFull()) {
            userInterface.send(s[0] + " Результат: " + s[1]);
        }
    }

    /**
     * Вводит данные от пользователя.
     * Предварительно посылает строку-уточнение,
     *
     * @param sInput
     * @return
     * @throws IOException
     */
    public String userInput(String sInput) throws IOException {
        userInterface.send(sInput);
        String input = userInterface.get().trim();
        return input;

    }

    /**
     * Определяет тип введеной строки согласно типам CommandType
     * Если тип не определяется как команда
     * по-умолчанию присваивается тип STRING
     *
     * @param sInput
     * @return
     */
    public CommandType detectCommandType(String sInput) {
        CommandType commandType = CommandType.STRING;
        for (CommandType t : CommandType.values()) {
            if (t.getCommand().equals(sInput.trim())) commandType = t;
        }
        /*
        try {
            commandType = CommandType.valueOf(sInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = CommandType.STRING;
        }*/

        return commandType;
    }

    /**
     * Отображает результат операций пользователю
     *
     * @param dInput
     */
    public void showResult(double dInput) {
        String s = String.format("::Результат: %.2f", dInput);
        userInterface.send(s);
    }

    /**
     * отображение помощи для пользователя
     * Учитывает все установленные значения операторов.
     * Выводит информацию о всех символах и приоритетах операций
     */
    public void showHelp() {
        userInterface.send("Консольный калькулятор");
        userInterface.send("Вычисляет значение введеной строки");
        userInterface.send("Входные данные могут быть: ");
        for (CommandType type : CommandType.values()) {
            if (type == CommandType.STRING) {
                userInterface.send(" * " + type.getDescription());
            } else userInterface.send(" * " + type.getCommand() + " - " + type.getDescription());
        }
        userInterface.send("Поддерживаются целые числа, операторы и приоритетные разделители(скобки)");
        userInterface.send("Список операторов:");
        ListOperators listOperators = new ListOperators();
        userInterface.send("  -низший приоритет: ");
        for (Map.Entry<String, String> pair : listOperators.getOperatorsByPriority((byte) 1).entrySet())
            userInterface.send("    " + pair.getKey() + " " + pair.getValue());
        userInterface.send("  -средний приоритет: ");
        for (Map.Entry<String, String> pair : listOperators.getOperatorsByPriority((byte) 2).entrySet())
            userInterface.send("    " + pair.getKey() + " " + pair.getValue());
        userInterface.send("  -высший приоритет: ");
        for (Map.Entry<String, String> pair : listOperators.getOperatorsByPriority((byte) 3).entrySet())
            userInterface.send("    " + pair.getKey() + " " + pair.getValue());
        userInterface.send("  -разделители: ");
        for (Map.Entry<String, String> pair : listOperators.getOperatorsByPriority((byte) 4).entrySet())
            userInterface.send("    " + pair.getKey() + " " + pair.getValue());
        userInterface.send("  -системные символы: ");
        for (Map.Entry<String, String> pair : listOperators.getOperatorsByPriority((byte) 5).entrySet())
            userInterface.send("    " + pair.getKey() + " " + pair.getValue());
        userInterface.send("==============================================================================");
    }

    /**
     * Выводит сообщение с информацией об ошибке
     *
     * @param sInput
     */
    public void showError(String sInput) {
        userInterface.send("::Ошибка:: " + sInput);
    }

    /**
     * Приветствие
     */
    public void showIntro() {
        userInterface.send("Для вызова справки введите " + CommandType.HELP.getCommand());
        userInterface.send("Введите строку для расчета или команду.");
    }
}
