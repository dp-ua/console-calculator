package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {
    public void write(String message){
        System.out.println(message);

    }

    public String read() throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        String result = reader.readLine();
        return result;
    }

}
