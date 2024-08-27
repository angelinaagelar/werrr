
// я сделала изменения в данном файле отличается от 5 дз

package family_tree.model;

import family_tree.family_tree_Angelina.FamilyTree;
import family_tree.human.Human;

import java.io.Serializable;
import java.util.List;

public class FamilyTreeModel implements Serializable {
    private FamilyTree<Human> familyTree;

    public FamilyTreeModel(List<Human> familyMembers) {
        this.familyTree = new FamilyTree<>(familyMembers);
    }

    public FamilyTree<Human> getFamilyTree() {
        return familyTree;
    }
}