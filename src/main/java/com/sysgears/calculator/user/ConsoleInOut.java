package com.sysgears.calculator.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Class for work with console
 */
public class ConsoleInOut implements UserInOut {

    /**
     * Write message to console
     * @param message
     */
    public void write(String message) {
        System.out.println(message);
    }

    /**
     * Read message from console
     * @return
     * @throws IOException
     */
    public String read() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }


}
