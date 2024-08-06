package com.project.familytree.presenter;

import com.project.familytree.data.FileDataHandler;
import com.project.familytree.model.FamilyTree;
import com.project.familytree.model.Human;
import com.project.familytree.view.FamilyTreeView;

import java.io.IOException;

public class FamilyTreePresenterImpl implements FamilyTreePresenter {
    private FamilyTreeView view;
    private FamilyTree<Human> familyTree;
    private FileDataHandler<Human> dataHandler;

    public FamilyTreePresenterImpl(FamilyTreeView view) {
        this.view = view;
        this.dataHandler = new FileDataHandler<>();
        this.familyTree = new FamilyTree<>(dataHandler);
    }

    @Override
    public void loadFamilyTree() {
        try {
            familyTree.loadFromFile("family_tree.dat");
            view.showFamilyTree(familyTree.getMembers());
        } catch (IOException | ClassNotFoundException e) {
            view.showError("Failed to load family tree: " + e.getMessage());
        }
    }

    @Override
    public void saveFamilyTree() {
        try {
            familyTree.saveToFile("family_tree.dat");
        } catch (IOException e) {
            view.showError("Failed to save family tree: " + e.getMessage());
        }
    }

    @Override
    public void addMember(Human member) {
        familyTree.addMember(member);
        view.showFamilyTree(familyTree.getMembers());
    }

    @Override
    public void sortByName() {
        familyTree.sortByName();
        view.showFamilyTree(familyTree.getMembers());
    }

    @Override
    public void sortByBirthDate() {
        familyTree.sortByBirthDate();
        view.showFamilyTree(familyTree.getMembers());
    }
}
