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
    private final UserInterface userInterface;
    private final DataInterface dataLoader;

    /**
     * Базовый конструктор
     * Инициализирует интерфейс для общения с пользователем
     * Инициализует хранилище для истории
     *
     * @param userInterface интерфейс пользователя
     */
    public Action(UserInterface userInterface) {
        this.userInterface = userInterface;
        dataLoader = new DataInterface(new DataStory());
    }

    /**
     * Сохраняем строку и результат операции в хранилище
     *
     * @param sA основная строка
     * @param sB результат
     */
    public void saveHistory(String sA, String sB) {
        dataLoader.saveToHistory(sA, sB);
    }

    /**
     * Выполняет нужные действия в соотстветствии с типом команды
     *
     * @param commandType тип команды
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
                showUniqueHistory();
                break;
            default:
        }
    }

    /**
     * Показываем историю уникальных операций
     */
    private void showUniqueHistory() {
        for (Map.Entry<String, String> pair : dataLoader.getListUnique().entrySet()) {
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
     * @param sInput строка для пользователя
     * @return строка введеная пользователем
     * @throws IOException ошибки чтения
     */
    public String userInput(String sInput) throws IOException {
        userInterface.send(sInput);
        return userInterface.get().trim();

    }

    /**
     * Определяет тип введеной строки согласно типам CommandType
     * Если тип не определяется как команда
     * по-умолчанию присваивается тип STRING
     *
     * @param sInput команда в виде строки
     * @return CommandType тип команды
     */
    public CommandType detectCommandType(String sInput) {
        for (CommandType t : CommandType.values()) {
            if (t.getCommand().equals(sInput.trim())) return t;
        }
        return CommandType.STRING;
    }

    /**
     * Отображает результат операций пользователю
     * @param dInput вычисленное значение.
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
    private void showHelp() {
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
     * @param sInput Текст ошибки
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
