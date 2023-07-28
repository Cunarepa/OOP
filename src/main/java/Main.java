import model.fileManage.FileManager;
import presenter.Presenter;
import view.consoleUI.ConsoleUI;
import view.View;

import static model.familyTrees.FamilyTreesArchive.fedorov;


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