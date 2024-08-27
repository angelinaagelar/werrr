package family_tree.presenter;

import family_tree.Writer.FileHandler;
import family_tree.family_tree_Angelina.FamilyTree;
import family_tree.human.Human;
import family_tree.model.FamilyTreeModel;
import family_tree.view.FamilyTreeView;

import java.util.ArrayList;
import java.util.List;

public class FamilyTreePresenterImpl implements family_tree.presenter.FamilyTreePresenter {
    private FamilyTreeView view;
    private final String filePath = "src/family_tree/family_tree.Writer/tree.txt";
    private FamilyTreeModel familyTreeModel;

    @Override
    public void attachView(FamilyTreeView view) {
        this.view = view;
        loadFamilyTree();
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void loadFamilyTree() {
        FileHandler fileHandler = new FileHandler(filePath);
        familyTreeModel = (FamilyTreeModel) fileHandler.read();
        if (familyTreeModel != null) {
            String familyTreeInfo = familyTreeModel.getFamilyTree().displayFamilyTree();
            view.displayFamilyTree(familyTreeInfo);
        } else {
            view.showError("Не удалось загрузить семейное дерево.");
        }
    }

    @Override
    public void saveFamilyTree() {
        if (familyTreeModel != null) {
            FileHandler fileHandler = new FileHandler(filePath);
            boolean success = fileHandler.save(familyTreeModel);
            if (!success) {
                view.showError("Не удалось сохранить семейное дерево.");
            }
        } else {
            view.showError("Семейное дерево пустое.");
        }
    }
}

