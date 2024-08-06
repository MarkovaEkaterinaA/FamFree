package com.project.familytree.view;

import com.project.familytree.model.Human;
import java.util.List;

public class ConsoleFamilyTreeView implements FamilyTreeView {
    @Override
    public void showFamilyTree(List<Human> members) {
        for (Human human : members) {
            System.out.println(human);
        }
    }

    @Override
    public void showError(String message) {
        System.err.println("Error: " + message);
    }
}
