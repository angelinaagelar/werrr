package family_tree;

import family_tree.human.Gender;
import family_tree.human.Human;
import family_tree.model.FamilyTreeModel;
import family_tree.presenter.FamilyTreePresenter;
import family_tree.presenter.FamilyTreePresenterImpl;
import family_tree.view.FamilyTreeView;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main_Angelina implements FamilyTreeView {
    private static FamilyTreePresenter presenter;

    public static void main(String[] args) {
        presenter = new FamilyTreePresenterImpl();
        Main_Angelina main = new Main_Angelina();
        presenter.attachView(main);

        // Создание членов семьи
        main.createFamily();

        presenter.detachView();
    }

    private void createFamily() {
        // Создание бабушек и дедушек
        Human grandMotherHomer = new Human("Mona Simpson", Gender.FEMALE, LocalDate.of(1940, 7, 11));
        Human grandFatherHomer = new Human("Abraham Jay-Jebediah 'Abe' Simpson", Gender.MALE, LocalDate.of(1939, 8, 8));

        // Создание родителей
        Human homer = new Human("Homer Filipp Simpson", Gender.MALE, LocalDate.of(1962, 7, 10), grandMotherHomer, grandFatherHomer);

        // Создание бабушек и дедушек по линии Маржори
        Human grandMotherMarge = new Human("Jacqueline Gurney", Gender.FEMALE, LocalDate.of(1941, 4, 11));
        Human grandFatherMarge = new Human("Clancy Bouvier", Gender.MALE, LocalDate.of(1937, 2, 8));

        // Создание родителей
        Human marge = new Human("Marjiorie Jacqueline (Marge) Simpson", Gender.FEMALE, LocalDate.of(1964, 10, 2), grandMotherMarge, grandFatherMarge);

        // Создание детей
        Human bart = new Human("Bartholomew Jo-Jo 'Bart' Simpson", Gender.MALE, LocalDate.of(1990, 12, 15), marge, homer);
        Human lisa = new Human("Lisa Marie Simpson", Gender.FEMALE, LocalDate.of(1993, 9, 17), marge, homer);
        Human maggie = new Human("Margaret Lenny 'Maggie' Simpson", Gender.FEMALE, LocalDate.of(1999, 2, 27), marge, homer);

        // Установить супругов
        homer.setSpouse(marge);
        marge.setSpouse(homer);

        // Создание списка членов семьи
        List<Human> familyMembers = new ArrayList<>();
        familyMembers.add(homer);
        familyMembers.add(marge);
        familyMembers.add(grandMotherHomer);
        familyMembers.add(grandFatherHomer);
        familyMembers.add(grandMotherMarge);
        familyMembers.add(grandFatherMarge);
        familyMembers.add(bart);
        familyMembers.add(lisa);
        familyMembers.add(maggie);

        // Создание FamilyTreeModel
        FamilyTreeModel familyTreeModel = new FamilyTreeModel(familyMembers);
        presenter.saveFamilyTree(); // Сохранение семейного дерева
    }

    @Override
    public void displayFamilyTree(String familyTreeInfo) {
        System.out.println(familyTreeInfo);
    }

    @Override
    public void showError(String message) {
        System.err.println(message);
    }
}
