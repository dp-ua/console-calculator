import logic.parse.CalcList;
import logic.parse.ParseToList;
import user.Action;
import user.CommandType;
import user.ConsoleHelper;
import user.UserInterface;

import java.util.List;

/**
 * Простейший консольный калькулятор
 * 1+2*(100-95)^2-6
 */

public class Calculator {
    public static boolean debugMode = true;

    public static void main(String[] args) {
        try {

            UserInterface userInterface = new UserInterface(new ConsoleHelper());
            Action action = new Action(userInterface);
            action.showIntro();
            CommandType commandType = CommandType.STRING;

            while (commandType != CommandType.QUIT) {
                try {
                    String sInput = action.userInput("Введите данные для работы:").trim();
                    commandType = action.detectCommandType(sInput);
                    if (commandType.isCommand()) {
                        action.doCommand(commandType);
                        continue;
                    }
                    String sResult="";

                    try {

                        ParseToList parseToList = new ParseToList(sInput);
                        List<String> list = parseToList.getWorkList();
                        CalcList calcList = new CalcList(list);
                        double result = calcList.calcFlatList();
                        sResult=result+"";
                        action.showResult(result);

                    } catch (NumberFormatException e) {
                        action.showError(e.getMessage());
                        sResult=e.getMessage();
                    } catch (IllegalArgumentException e) {
                        action.showError(e.getMessage());
                        sResult=e.getMessage();
                    } catch (NullPointerException e) {
                        action.showError(e.getMessage());
                        sResult=e.getMessage();
                    } catch (StringIndexOutOfBoundsException e) {
                        action.showError(e.getMessage());
                        sResult=e.getMessage();
                    } catch (ArithmeticException e) {
                        action.showError(e.getMessage());
                        sResult=e.getMessage();
                    }
                action.saveHistory(sInput,sResult);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
