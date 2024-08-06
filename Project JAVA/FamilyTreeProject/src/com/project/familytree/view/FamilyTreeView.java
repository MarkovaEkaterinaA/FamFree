package com.project.familytree.view;

import com.project.familytree.model.Human;
import java.util.List;

public interface FamilyTreeView {
    void showFamilyTree(List<Human> members);
    void showError(String message);
}
