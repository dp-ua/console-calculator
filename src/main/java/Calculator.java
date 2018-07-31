import user.CommandType;
import logic.math.ParseString;
import user.ConsoleHelper;
import user.UserInterface;

public class Calculator {
    public static boolean debugMode = true;


    public static void main(String[] args) {
        try {

            UserInterface userInterface = new UserInterface(new ConsoleHelper());

            userInterface.send("Для вызова справки введите help.");
            userInterface.send("Введите строку для расчета или команду.");


            while (true) {
                String input = userInterface.get("Введите данне для работы:").trim();
                CommandType command;
                try {
                    command = CommandType.valueOf(input.toUpperCase());
                } catch (IllegalArgumentException e) {
                    command = CommandType.STRING;
                }

                switch (command) {
                    case QUIT:
                        userInterface.send("Выход.");
                        return;
                    case HELP: // TODO: 31.07.18  показать помощь по программе
                        userInterface.send("Запрошена помощь", debugMode);
                        continue;
                    default:
                }
                ParseString parse = new ParseString(input);
                if (!parse.check()) {
                    userInterface.send("Некорректный ввод данных");
                    continue;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
