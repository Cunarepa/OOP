package test;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.add(new Human("Сергей", Gender.Male, LocalDate.of(1955, 11, 25)));
        tree.add(new Human("Вера", Gender.Femail, LocalDate.of(1953, 1, 1)));
        tree.add(new Human("Юлия", Gender.Femail, LocalDate.of(1989, 9, 11),
                tree.getByName("Сергей"), tree.getByName("Вера")));
        tree.add(new Human("Роман", Gender.Male, LocalDate.of(2016, 8, 12),
                tree.getByName("Сергей"), tree.getByName("Вера")));

        System.out.println(tree);
    }
}
