package view.menu.mainMenu.commands;

import view.ConsoleUI;


public class GetChildren implements Command {
    private ConsoleUI consoleUI;

    public GetChildren(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить детей человека из дерева";
    }

    @Override
    public void execute() {
        consoleUI.getChildren();

    }
}