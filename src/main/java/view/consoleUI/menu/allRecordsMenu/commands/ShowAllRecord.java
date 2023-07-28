package view.consoleUI.menu.allRecordsMenu.commands;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;
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