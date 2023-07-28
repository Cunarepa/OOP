package presenter;

import model.members.Human;
import model.services.HumanService;
import model.members.Gender;
import model.members.Member;

import java.io.Serializable;
import java.util.List;
public class Presenter implements Serializable {

    boolean importFileLoaded;

    private HumanService humanService;
    public Presenter() {
        importFileLoaded = false;

        this.humanService = new HumanService();
    }


    public boolean isImportFileLoaded() {
        return importFileLoaded;
    }

    public boolean checkCreateFamilyTree() {
        return humanService.checkCreateFamilyTree();
    }

    public String getNameFamilyTree() {
        return humanService.getNameFamilyTree();
    }

    public void importFile(String filePath) {
        humanService.importFile(filePath);
        if (checkCreateFamilyTree()){
            importFileLoaded = true;

        }
    }

    public void saveFile() {
        humanService.saveFile();
    }

    public void addRecord(String name, Gender gender, int yearOfBirth) {
        humanService.addRecord(name, gender, yearOfBirth);
    }


    public void addRecord(String name, Gender gender, int dateOfBirth,
                          String fatherName, int yearOfBirthFather,
                          String motherName, int yearOfBirthMother) {
        humanService.addRecord(
                name, gender, dateOfBirth,
                fatherName, yearOfBirthFather,
                motherName, yearOfBirthMother);
    }


    public Member getRecord(String name, int yearOfBirth) {
        return humanService.getRecord(name, yearOfBirth);
    }

    public List<Human> getAllRecord() {
        return humanService.getAllRecord();
    }

    public List<Human> getParents(String name, int yearOfBirth) {
        return humanService.getParents(name, yearOfBirth);
    }

    public List<Human> getChildren(String name, int yearOfBirth) {
        return humanService.getChildren(name, yearOfBirth);

    }

    public void sortByAlphabeticalOrder() {
        humanService.sortByAlphabeticalOrder();
    }


    public void sortByDateBirth() {
        humanService.sortByDateBirth();
    }

    public void sortByNameLength() {
        humanService.sortByNameLength();
    }
}
