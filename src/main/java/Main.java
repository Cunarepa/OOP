import model.fileManage.FileManager;
import view.ConsoleUI;
import view.View;

import java.nio.file.Paths;

import static model.familyTrees.FamilyTreesArchive.fedorov;
import static model.familyTrees.FamilyTreesArchive.barboss;

public class Main {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}