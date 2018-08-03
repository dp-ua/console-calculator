package user;

import java.io.IOException;


/**
 * Интерфейс общения с пользователем
 * <p/>
 * Использует consoleHelper
 */
public class UserInterface {

    /**
     * Интерфейс, куда пользователь вводит данные
     * и откуда получает наши сообщения
     */
    private final ConsoleHelper console;

    /**
     * Базовый конструктор
     * @param console через что мы общаемся с пользователем
     */
    public UserInterface(ConsoleHelper console) {
        this.console = console;
    }

    /**
     * отправка сообщения пользователю
     * @param sInput  сообщение для пользователя
     */
    public void send(String sInput) {
        console.write(sInput);
    }

// --Commented out by Inspection START (03.08.18 16:01):
//    /**
//     * отправка отладочных сообщений
//     *
//     * @param message
//     * @param debugMode
//     */
//    public void send(String message, boolean debugMode) {
//        if (debugMode) console.write(":::::  " + message);
//    }
// --Commented out by Inspection STOP (03.08.18 16:01)

    /**
     * Получение данных от пользователя
     *
     * @return данные от пользователя
     * @throws IOException ошибка при чтении
     */
    public String get() throws IOException {
        return console.read();
    }
}
