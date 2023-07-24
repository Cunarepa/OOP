package view.menu.mainMenu.commands;

import view.ConsoleUI;

public class ShowAllRecord implements Command {

    private ConsoleUI consoleUI;


    public ShowAllRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Показать все записи в древе";
    }

    @Override
    public void execute() {
        consoleUI.showAllRecord();

    }
}