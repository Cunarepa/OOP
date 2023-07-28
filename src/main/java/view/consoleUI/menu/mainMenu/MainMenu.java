package view.consoleUI.menu.mainMenu;

import view.consoleUI.ConsoleUI;
import view.consoleUI.menu.Menu;
import view.consoleUI.menu.endMenu.commands.Save;
import view.consoleUI.menu.mainMenu.commands.*;

import java.util.Arrays;

public class MainMenu extends Menu {

    private boolean isRun;

    public MainMenu(ConsoleUI consoleUI) {
        super(Arrays.asList(
                new AddRecord(consoleUI),
                new GetRecord(consoleUI),
                new GetAllRecord(consoleUI),
                new RunEndMenu(consoleUI)));
        this.isRun = true;
    }

    public boolean isRun() {
        return isRun;
    }

    public void setRun(boolean run) {
        isRun = run;
    }
}