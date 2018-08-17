package com.sysgears.calculator;

import com.sysgears.calculator.calculation.parse.MainParser;
import com.sysgears.calculator.calculation.parse.exception.MyException;
import com.sysgears.calculator.history.AbstractStorage;
import com.sysgears.calculator.history.History;
import com.sysgears.calculator.history.StorageInMemory;
import com.sysgears.calculator.user.*;

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

            while (true) {
                String input="";
                try {

                    messages.waitForInput();
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
                            double result = new MainParser().calculate(input);
                            history.save(input+" Результат: " + result);
                            messages.showResult(result);
                    }


                } catch (MyException e) {
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
