package com.sysgears.calculator;

import com.sysgears.calculator.calculation.Calculate;
import com.sysgears.calculator.history.AbstractStorage;
import com.sysgears.calculator.history.History;
import com.sysgears.calculator.history.StorageInMemory;
import com.sysgears.calculator.user.*;


import static com.sysgears.calculator.user.CommandType.STRING;

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
            messages.intro();

            AbstractStorage abstractStorage = new StorageInMemory();
            History history = new History(abstractStorage);

            while (true) {
                try {
                    messages.waitForInput();
                    String input = userView.get().trim();


                    CommandType commandType = new Command(input).detectCommandType();
                    if (commandType == CommandType.QUIT) {
                        messages.quit();
                        break;
                    }

                    if (commandType != STRING) {
                        switch (commandType) {
                            case INTRO:
                                messages.intro();
                                break;
                            case HISTORY:
                                messages.showList(history.getFull());
                                break;
                            case HISTORYU:
                                messages.showList(history.getUnique());
                                break;
                            case HELP:
                                messages.help();
                                break;
                        }
                    } else {
                        history.save(input);
                        double result = new Calculate(input).calculate();
                        messages.result(result);

                    }

                } catch (NumberFormatException e) {
                    messages.error(e.getMessage());
                } catch (IllegalArgumentException e) {
                    messages.error(e.getMessage());
                } catch (StringIndexOutOfBoundsException e) {
                    messages.error(e.getMessage());
                } catch (ArithmeticException e) {
                    messages.error(e.getMessage());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }
}
