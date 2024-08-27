package family_tree.presenter;

import family_tree.view.FamilyTreeView;

public interface FamilyTreePresenter {
    void loadFamilyTree();
    void saveFamilyTree();
    void attachView(FamilyTreeView view);
    void detachView();
}