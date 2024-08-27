
// тут  тоже обновила
package family_tree.human;

import family_tree.family_tree_Angelina.FamilyMember;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Human implements Serializable, FamilyMember<Human> {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> children = new ArrayList<>();
    private Human mother;
    private Human father;
    private Human spouse;

    // Конструктор без родителей
    public Human(String name, Gender gender, LocalDate birthDate) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
    }

    // Конструктор с родителями
    public Human(String name, Gender gender, LocalDate birthDate, Human mother, Human father) {
        this(name, gender, birthDate);
        this.mother = mother;
        this.father = father;
        if (mother != null) mother.addChild(this);
        if (father != null) father.addChild(this);
    }

    @Override
    public boolean addChild(Human child) {
        return children.add(child);
    }

    // Implementing other methods from TreeNode and FamilyMember

    @Override
    public List<Human> getChildren() {
        return children;
    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public List<Human> getParents() {
        return List.of(mother, father);
    }

    @Override
    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return spouse;
    }

    @Override
    public Iterator<Human> iterator() {
        return children.iterator();
    }

    @Override
    public Human getFather() {
        return null;
    }

    @Override
    public Human getMother() {
        return null;
    }
}
