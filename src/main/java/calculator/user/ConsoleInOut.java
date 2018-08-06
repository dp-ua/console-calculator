package calculator.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ввод-Вывод
 * <p/>
 * Работа с консолью
 */
public class ConsoleHelper {

    /***
     * Вывод сообщения на консоль
     * @param sInput  строка для пользователя
     */
    public void write(String sInput){
        System.out.println(sInput);

    }

    /**
     * Ввод данных с консоли
     * @return String данные, прочитанные с консоли
     * @throws IOException ошибка при чтении
     */
    public String read() throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

}
