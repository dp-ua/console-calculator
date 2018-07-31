package user;

import java.io.IOException;

public class UserInterface {
    ConsoleHelper console;

    public UserInterface(ConsoleHelper console) {
        this.console = console;
    }

    public void send(String message) {
        console.write(message);
    }

    public void send(String message,boolean debugMode) {
        if (debugMode)console.write(":::::  " + message);
    }

    public String get(){
        String result="";
        try {
            result=console.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
    public String get(String question) {
        String result="";
        console.write(question);
        try {
            result=console.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
