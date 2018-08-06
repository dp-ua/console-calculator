package calculator;

import calculator.history.DataStorage;
import calculator.history.History;
import calculator.history.StorageInMemory;
import calculator.logic.parse.CalcFlatList;
import calculator.logic.parse.ParseToList;
import calculator.user.*;

import java.util.List;

/**
 * simple calculator
 * 1+2*(100-95)^2-6
 */

public class Main {

    public static void main(String[] args) {
        try {
            //In Out
            UserInOut userInOut = new ConsoleInOut();
            UserView userView = new UserView(userInOut);

            //History
            DataStorage dataStorage = new StorageInMemory();
            History history = new History(dataStorage);


            Command command = new Command(userView, history);
            CommandType commandType = CommandType.INTRO;
            command.doCommand(commandType);

            while (commandType != CommandType.QUIT) {
                try {
                    userView.send("Введите команду или строку для просчета:");
                    String input = userView.get().trim();

                    commandType = command.detectCommandType(input);
                    if (commandType.isCommand()) {
                        command.doCommand(commandType);
                        continue;
                    }
                    String sResult;
                    try {
                        ParseToList parseToList = new ParseToList(input);
                        List<String> list = parseToList.getWorkList();
                        CalcFlatList calcFlatList = new CalcFlatList(list);
                        double result = calcFlatList.calculate();
                        sResult = result + "";
                        command.showResult(result);

                    } catch (NumberFormatException e) {
                        command.showError(e.getMessage());
                        sResult = e.getMessage();
                    } catch (IllegalArgumentException e) {
                        command.showError(e.getMessage());
                        sResult = e.getMessage();
                    } catch (NullPointerException e) {
                        command.showError(e.getMessage());
                        sResult = e.getMessage();
                    } catch (StringIndexOutOfBoundsException e) {
                        command.showError(e.getMessage());
                        sResult = e.getMessage();
                    } catch (ArithmeticException e) {
                        command.showError(e.getMessage());
                        sResult = e.getMessage();
                    }
                    command.saveHistory(input, sResult);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
