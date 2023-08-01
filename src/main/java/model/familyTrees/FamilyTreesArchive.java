package model.familyTrees;

import model.members.Aliens;
import model.members.Human;
import model.members.Member;

import java.util.ArrayList;
import java.util.List;

import static model.members.Gender.MAN;
import static model.members.Gender.WOMAN;

public class FamilyTreesArchive {

    public List<FamilyTree> familyTreeList = new ArrayList<>(){{
        add(fedorov);
        add(barboss);
    }};
    public static FamilyTree<Member> fedorov = new FamilyTree<>("Федоровы") {
        {
            addPersonInFamilyTree(new Human("Антон", MAN, 1900));
            addPersonInFamilyTree(new Human("Анатолий", MAN, 1950), "Антон", 1900);
            addPersonInFamilyTree(new Human("Вера", WOMAN, 1953));
            addPersonInFamilyTree(new Human("Владимир", MAN, 1975), "Анатолий", 1950, "Вера", 1953);
            addPersonInFamilyTree(new Human("Сергей", MAN, 1995), "Владимир", 1975);
            addPersonInFamilyTree(new Human("Татьяна", WOMAN, 2000), "Владимир", 1975);
            addPersonInFamilyTree(new Human("Роман", MAN, 2016), "Владимир", 1975);

        }
    };

    public static FamilyTree<Aliens> barboss = new FamilyTree<>("Барбоскины") {
        {
            addPersonInFamilyTree(new Aliens("Дедушка", "Барбоскин", MAN, 2002));
            addPersonInFamilyTree(new Aliens("Папа", "Барбоскин", MAN, 2015), "Дедушка", 2002);
            addPersonInFamilyTree(new Aliens("Мама", "Барбоскин", WOMAN, 2019));
            addPersonInFamilyTree(new Aliens("Дружок", "Барбоскин", MAN, 2022), "Папа", 2015, "Мама", 2019);
            addPersonInFamilyTree(new Aliens("Роза", "Барбоскин", WOMAN, 2022), "Папа", 2015, "Мама", 2019);
            addPersonInFamilyTree(new Aliens("Лиза", "Барбоскин", WOMAN, 2021));
            addPersonInFamilyTree(new Aliens("Малыш", "Барбоскин", MAN, 2023), "Папа", 2015, "Мама", 2019);
        }
    };

}
