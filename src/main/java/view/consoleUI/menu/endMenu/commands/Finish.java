package view.consoleUI.menu.endMenu.commands;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.mainMenu.commands.Command;

public class Finish implements Command {

    private ConsoleUI consoleUI;

    public Finish(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Выйти из программы";
    }

    @Override
    public void execute() {
        consoleUI.finish();
    }
}