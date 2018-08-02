package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ввод-Вывод
 * <p/>
 * Работа с консолью
 */
public class ConsoleHelper {

    /**
     * Вывод сообщения на консоль
     * @param message
     */
    public void write(String message){
        System.out.println(message);

    }

    /**
     * Ввод данных с консоли
     * @return
     * @throws IOException
     */
    public String read() throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String result = reader.readLine();
        return result;
    }

}
