package calculator.user;

import java.io.IOException;


/**
 * Интерфейс общения с пользователем
 * <p/>
 * Использует consoleHelper
 */
public class UI {

    private final UserInOut userInOut;

    public UI(UserInOut userInOut) {
        this.userInOut = userInOut;
    }

    public void send(String sInput) {
        userInOut.write(sInput);
    }

    public String get() throws IOException {
        return userInOut.read();
    }
}
