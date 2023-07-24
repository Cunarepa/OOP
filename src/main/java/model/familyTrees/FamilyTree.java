package model.familyTrees;

import model.familyTrees.comparators.ByDateBirth;
import model.familyTrees.comparators.NameLength;
import model.familyTrees.iterators.PersonIterator;
import model.members.Gender;
import model.members.Member;

import java.io.Serializable;
import java.time.Year;
import java.util.*;

public class FamilyTree<T extends Member> implements Serializable, Iterable<T> {
    private List<T> familyTree;
    private String nameFamilyTree;

    public FamilyTree(String nameFamilyTree) {
        this.nameFamilyTree = nameFamilyTree;
        this.familyTree = new ArrayList<>();
    }


    public String getNameFamilyTree() {
        return nameFamilyTree;
    }

    public List<T> getFamilyTree() {
        return familyTree;
    }


    public void addBranchParentChild(T parent, T child) {
        if (parent != null) {
            if (parent.getGender().equals(Gender.MAN)) {
                child.setFather(parent);
                addChildBranch(parent, child);
            }
            if (parent.getGender().equals(Gender.WOMAN)) {
                child.setMother(parent);
                addChildBranch(parent, child);
            }
        }
    }


    private void addChildBranch(T parent, T child) {

        if (!parent.getChildren().contains(child)) {
            parent.addChild((child));
        }
    }

    public void addPersonInFamilyTree(T person) {
        if (!isPersonInTree(person)) familyTree.add(person);
    }


    public void addPersonInFamilyTree(T person, String parent, int yearOfBirth) {
        if (!isPersonInTree(person)) {
            addBranchParentChild(getPersonFromTree(parent, yearOfBirth), person);
            familyTree.add(person);
        }
    }

    public void addPersonInFamilyTree(T child,
                                      String fatherName, int yearOfBirthFather,
                                      String motherName, int yearOfBirthMother) {
        if (!isPersonInTree(child)) {
            addBranchParentChild(getPersonFromTree(fatherName, yearOfBirthFather), child);
            addBranchParentChild(getPersonFromTree(motherName, yearOfBirthMother), child);
            familyTree.add(child);
        }
    }

    public T getPersonFromTree(String personName, int yearOfBirth) {
        Year temp = Year.of(yearOfBirth);
        Optional<T> result =
                familyTree.stream()
                        .filter(x -> x.getName().equalsIgnoreCase(personName) && x.getYearOfBirth().equals(temp))
                        .findFirst();
        return result.orElse(null);
    }

    private boolean isPersonInTree(T person) {
        return familyTree.contains(person);
    }

    public List<Member> getParents(String parentName, int yearOfBirth) {
        T child = getPersonFromTree(parentName, yearOfBirth);
        List<Member> temp = new ArrayList<>();
        if (child != null) {
            temp.add(child.getFather());
            temp.add(child.getMother());
        }
        return temp;
    }

    public List<Member> getChildren(String parentName, int yearOfBirth) {
        return Optional.ofNullable(getPersonFromTree(parentName, yearOfBirth))
                .map(T::getChildren).orElse(null);
    }


    @Override
    public Iterator<T> iterator() {
        return new PersonIterator(familyTree);
    }

    public void sortTreeByDateBirth() {
        familyTree.sort(new ByDateBirth<>());
    }

    public void sort(Comparator<Member> comparatorSort) {
        familyTree.sort(comparatorSort);
    }


}