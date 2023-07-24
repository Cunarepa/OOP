import model.familyTrees.FamilyTree;
import model.fileManage.FileManager;
import model.members.Member;
import presenter.Presenter;
import view.ConsoleUI;
import view.View;

import static model.familyTrees.FamilyTreesArchive.fedorov;
import static model.familyTrees.FamilyTreesArchive.barboss;


public class Main {
    public static void main(String[] args) {

        View view = new ConsoleUI(new Presenter());
        view.start();
    }


    private static void fixBug() {
        FileManager filePathFedorov = new FileManager("data/fedorovTree.bin");
        filePathFedorov.saveFile(fedorov);
        fedorov = filePathFedorov.loadFile();
    }
}