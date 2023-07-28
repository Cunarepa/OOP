package view.consoleUI.menu.mainMenu.commands;

import model.members.Human;
import view.consoleUI.ConsoleUI;

import java.util.List;
public class GetAllRecord implements Command {

    private ConsoleUI consoleUI;

    public GetAllRecord(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получить все записи в древе";
    }

    @Override
    public void execute() {
        consoleUI.runRecordsMenu(consoleUI.getAllRecord());
    }


}