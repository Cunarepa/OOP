package model.familyTrees;

import model.members.Aliens;
import model.members.Human;


public class FamilyTreesArchive {
    public static FamilyTree<Human> fedorov = new FamilyTree<>("Федоровы") {
        {
            addPersonInFamilyTree(new Human("Антон", "man", 1900));
            addPersonInFamilyTree(new Human("Анатолий", "man", 1950), "Антон", 1900);
            addPersonInFamilyTree(new Human("Вера", "woman", 1953));
            addPersonInFamilyTree(new Human("Владимир", "man", 1975), "Анатолий", 1950, "Вера", 1953);
            addPersonInFamilyTree(new Human("Сергей", "man", 1995), "Владимир", 1975);
            addPersonInFamilyTree(new Human("Татьяна", "woman", 2000), "Владимир", 1975);
            addPersonInFamilyTree(new Human("Роман", "man", 2016), "Владимир", 1975);

        }
    };

    public static FamilyTree<Aliens> barboss = new FamilyTree<>("Барбоскины") {
        {
            addPersonInFamilyTree(new Aliens("Дедушка", "Барбоскин", "man", 2002));
            addPersonInFamilyTree(new Aliens("Папа", "Барбоскин", "man", 2015), "Дедушка", 2002);
            addPersonInFamilyTree(new Aliens("Мама", "Барбоскин", "woman", 2019));
            addPersonInFamilyTree(new Aliens("Дружок", "Барбоскин", "man", 2022), "Папа", 2015, "Мама", 2019);
            addPersonInFamilyTree(new Aliens("Роза", "Барбоскин", "woman", 2022), "Папа", 2015, "Мама", 2019);
            addPersonInFamilyTree(new Aliens("Лиза", "Барбоскин", "woman", 2021));
            addPersonInFamilyTree(new Aliens("Малыш", "Барбоскин", "man", 2023), "Папа", 2015, "Мама", 2019);
        }
    };

}
