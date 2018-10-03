package com.example.calculator;

import com.example.calculator.parse.exception.CallculationExceptions;
import com.example.calculator.history.AbstractStorage;
import com.example.calculator.history.History;
import com.example.calculator.history.StorageInMemory;
import com.example.calculator.user.*;
import com.example.calculator.parse.MainParser;


/**
 * simple com.sysgears.calculator
 * 1+2*(100-95)^2-6
 */

public class Main {

    public static void main(String[] args) {
        try {
            UserInOut userInOut = new ConsoleInOut();
            UserView userView = new UserView(userInOut);
            Messages messages = new Messages(userView);
            messages.showIntro();

            AbstractStorage abstractStorage = new StorageInMemory();
            History history = new History(abstractStorage);
            Command command = new Command();
            MainParser parser = new MainParser();

            while (true) {
                String input="";
                try {
                    messages.showWaitForInput();
                    input = userView.get().trim();

                    CommandType commandType = command.detectCommandType(input);
                    if (commandType == CommandType.QUIT) {
                        messages.showQuit();
                        break;
                    }

                    switch (commandType) {
                        case INTRO:
                            messages.showIntro();
                            break;
                        case HISTORY:
                            messages.showList(history.getListFull());
                            break;
                        case HISTORYU:
                            messages.showList(history.getListUnique());
                            break;
                        case HELP:
                            messages.showHelp();
                            break;
                        default:
                            double result = parser.calculate(input);
                            history.save(input+" Результат: " + result);
                            messages.showResult(result);
                    }

                } catch (CallculationExceptions e) {
                    history.save(input+" Результат: " + e.getMessage());
                    messages.showError(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
