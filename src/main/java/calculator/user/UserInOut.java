package calculator.user;

import java.io.IOException;

/**
 * Basic interface to talk with user
 */
public interface UserInOut {
    /**
     * write message to User
     * @param sInput
     */
    void write(String sInput);

    /**
     * get message from User
     * @return
     * @throws IOException
     */
    String read() throws IOException;
}
