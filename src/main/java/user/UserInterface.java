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
    ConsoleHelper console;

    /**
     * Базовый конструктор
     * @param console
     */
    public UserInterface(ConsoleHelper console) {
        this.console = console;
    }

    /**
     * отправка сообщения пользователю
     * @param message
     */
    public void send(String message) {
        console.write(message);
    }

    /**
     * отправка отладочных сообщений
     *
     * @param message
     * @param debugMode
     */
    public void send(String message, boolean debugMode) {
        if (debugMode) console.write(":::::  " + message);
    }

    /**
     * Получение данных от пользователя
     *
     * @return
     * @throws IOException
     */
    public String get() throws IOException {
        String result = "";
        result = console.read();
        return result;
    }
}
