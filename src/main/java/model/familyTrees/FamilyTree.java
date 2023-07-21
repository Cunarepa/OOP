package model.familyTrees;

import model.familyTrees.comparators.ByDateBirth;
import model.familyTrees.comparators.NameAlphabetical;
import model.familyTrees.comparators.NameLength;
import model.familyTrees.iterators.PersonIterator;
import model.members.Member;

import java.io.Serializable;
import java.time.Year;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
            if (parent.getGender().equalsIgnoreCase("man")) {
                child.setFather(parent);
                addChildBranch(parent, child);
            }
            if (parent.getGender().equalsIgnoreCase("woman")) {
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
            addBranchParentChild(getHumanFromTree(parent, yearOfBirth), person);
            familyTree.add(person);
        }
    }


    public void addPersonInFamilyTree(T child,
                                      String fatherName, int yearOfBirthFather,
                                      String motherName, int yearOfBirthMother) {
        if (!isPersonInTree(child)) {
            addBranchParentChild(getHumanFromTree(fatherName, yearOfBirthFather), child);
            addBranchParentChild(getHumanFromTree(motherName, yearOfBirthMother), child);
            familyTree.add(child);
        }
    }

    public T getHumanFromTree(String personName, int yearOfBirth) {
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
        T child = getHumanFromTree(parentName, yearOfBirth);
        List<Member> temp = new ArrayList<>();
        if (child != null) {
            temp.add(child.getFather());
            temp.add(child.getMother());
            return temp;
        } else return temp;
    }

    public List<Member> getChildren(String parentName, int yearOfBirth) {
        return Optional.ofNullable(getHumanFromTree(parentName, yearOfBirth))
                .map(T::getChildren).orElse(null);
    }


    @Override
    public Iterator<T> iterator() {
        return new PersonIterator(familyTree);
    }


    public void sortTreeByDateBirth() {
        familyTree.sort(new ByDateBirth<>());
    }

    public void sortTreeByAlphabeticalOrder() {

        familyTree.sort(new NameAlphabetical<>());
    }


    public void sortTreeByNameLength() {
        familyTree.sort(new NameLength<>());
    }

    public int familyTreeSize() {
        return familyTree.size();
    }
}
