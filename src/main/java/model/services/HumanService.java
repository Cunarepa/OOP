package model.services;

import model.familyTrees.FamilyTree;
import model.familyTrees.comparators.ByDateBirth;
import model.familyTrees.comparators.NameAlphabetical;
import model.familyTrees.comparators.NameLength;
import model.fileManage.FileManager;
import model.members.Gender;
import model.members.Human;
import model.members.Member;

import java.util.ArrayList;
import java.util.List;

public class HumanService {
    private FamilyTree<Human> familyTree;
    private FileManager fileManager;
    public HumanService() {
        this.familyTree = null;
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }

    public String getNameFamilyTree() {
        return familyTree.getNameFamilyTree();
    }

    public boolean checkCreateFamilyTree() {
        return familyTree != null;
    }


    public void importFile(String filePath) {
        this.fileManager = new FileManager(filePath);
        this.familyTree = fileManager.loadFile();
    }


    public void saveFile() {
        fileManager.saveFile(familyTree);
    }

    public void addRecord(String name, Gender gender, int dateOfBirth) {
        familyTree.addPersonInFamilyTree(new Human(name, gender, dateOfBirth));
    }


    public void addRecord(String name, Gender gender, int dateOfBirth,
                          String fatherName, int yearOfBirthFather,
                          String motherName, int yearOfBirthMother) {
        familyTree.addPersonInFamilyTree(
                new Human(name, gender, dateOfBirth),
                fatherName, yearOfBirthFather,
                motherName, yearOfBirthMother);
    }

    public Member getRecord(String name, int year) {
        return familyTree.getPersonFromTree(name, year);
    }
    public List<Human> getAllRecord() {
        return familyTree.getFamilyTree();
    }
    public List<Human> getParents(String name, int yearOfBirth) {
        return convertMemberToChildren(familyTree.getParents(name, yearOfBirth));
    }

    public List<Human> getChildren(String name, int yearOfBirth) {
        return convertMemberToChildren(familyTree.getChildren(name, yearOfBirth));
    }

    private List<Human> convertMemberToChildren(List<Member> memberList) {
        List<Human> humanList = new ArrayList<>();
        for (Member member : memberList) {
            if (member instanceof Human human) {
                humanList.add(human);
            }
        }
        return humanList;
    }


    public void sortByAlphabeticalOrder() {
        familyTree.sort(new NameAlphabetical<>());
    }

    public void sortByDateBirth() {
        familyTree.sort(new ByDateBirth<>());
    }

    public void sortByNameLength() {
        familyTree.sort(new NameLength<>());
    }
}