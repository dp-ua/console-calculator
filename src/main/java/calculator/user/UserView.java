package calculator.user;

import java.io.IOException;


/**
 * class to communicate with the user
 */
public class UserView {

    /**
     * Interface for communications
     */
    private final UserInOut userInOut;

    /**
     * set the basic interface
     * @param userInOut
     */
    public UserView(UserInOut userInOut) {
        this.userInOut = userInOut;
    }

    /**
     * send message to user
     * @param message
     */
    public void send(String message) {
        userInOut.write(message);
    }

    /**
     * get message from user
     * @return String
     * @throws IOException
     */
    public String get() throws IOException {
        return userInOut.read();
    }
}
