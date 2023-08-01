package view.consoleUI.menu.endMenu.commands;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;


public class Save implements Command {

    private ConsoleUI consoleUI;

    public Save(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Сохранить файл";
    }

    @Override
    public void execute() {
        consoleUI.save();
    }
}