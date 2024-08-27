
// тут разделила на более мелкие интерфейсы
package family_tree.family_tree_Angelina;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public interface TreeNode<T> extends Serializable, Iterable<T> {
    long getId();
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
    T getSpouse();
    void setSpouse(T spouse);
}

