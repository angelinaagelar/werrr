package family_tree.family_tree_Angelina;

public interface FamilyMember<T> extends TreeNode<T>, Parent<T> {
    T getFather();
    T getMother();
}
