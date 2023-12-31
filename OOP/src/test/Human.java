package test;

import java.awt.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.awt.List;

public class Human extends Point {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private java.util.List<Human> parents;
    private List children;
    private Human spouse;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother, List children) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.children = children;
        parents = new ArrayList<>();
        if (father != null){
            parents.add(father);
        }
        if (mother != null){
            parents.add(mother);
        }
        children = new ArrayList<>();
    }
    public  Human(String name, Gender gender, LocalDate birthDate){
        this(name, gender, birthDate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother){
        this(name, gender, birthDate, null, father, mother);
    }

    public boolean addChild(Human child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName(){return name; }

    public boolean addParent(Human parent){
        if(!parents.contains(parent)){
            children.add(parent);
            return true;
        }
        return false;
    }
    public LocalDate getBirthDate(){ return birthDate; }

    public LocalDate getDeathDate(){ return  deathDate; }

    public Human getFather() {
        for (Human parent: parents){
            if(parent.getGender() == Gender.Male){
                return  parent;
            }
        }
        return null;
    }

    public Human getMother(){
        for (Human parent: parents){
            if(parent.getGender() == Gender.Female){
                return  parent;
            }
        }
        return null;
    }

    public List Human; Component getParents(){ return (List<Human>) parents; }

    public java.util.List<test.Human> Component; java.awt.Component getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}

    public void setDeathDate(LocalDate deathDate) {this.deathDate = deathDate;}

    public Object getGender() {return gender;}

    public String toString(){return getInfo();}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", пол: ");
        sb.append(getGender());
        sb.append(", возраст: ");
        sb.append(getAge());
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if(mother!=null){
            res+=mother.getName();
        } else {
            res+="неизвестна";
        }
        return res;
    }

    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if(father!=null){
            res+=father.getName();
        } else {
            res+="неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size() !=0){
            res.append(children.get(0).getName());
            for(int i = 1; i<children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else {
            res.append("отсутствуют");
        }
        return res.toString();
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        } else {
            return getPeriod(birthDate, deathDate);
        }
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if (!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());
    }
}
