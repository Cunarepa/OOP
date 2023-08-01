import model.familyTrees.FamilyTree;
import model.fileManage.FileManager;
import model.members.Member;
import presenter.Presenter;
import view.consoleUI.ConsoleUI;
import view.View;

import static model.familyTrees.FamilyTreesArchive.fedorov;


public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI(new Presenter());
        view.start();
    }
}