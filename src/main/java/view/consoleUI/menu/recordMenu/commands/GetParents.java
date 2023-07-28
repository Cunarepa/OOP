package view.consoleUI.menu.recordMenu.commands;

import model.members.Member;
import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;

public class GetParents implements Command {
    private ConsoleUI consoleUI;

    public GetParents(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить родителей человека из дерева";
    }

    @Override
    public void execute() {
        consoleUI.getParents();

    }
}