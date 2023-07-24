package view.menu;

import view.ConsoleUI;
import view.menu.mainMenu.commands.*;

import java.util.List;

public abstract class BaseMenu  {
    private List<Command> commandList;

    public BaseMenu(List<Command> commandList) {
        this.commandList = commandList;
    }


    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();

    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }


    public int size() {
        return commandList.size();
    }


    public int checkInputLineMenu(String choice) {
        if (choice.matches("[0-9]+")) {
            int result = Integer.parseInt(choice);
            if (result > 0 && result <= size()) return result;
        }
        return -1;
    }


}
