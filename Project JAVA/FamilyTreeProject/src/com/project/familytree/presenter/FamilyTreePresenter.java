package com.project.familytree.presenter;

import com.project.familytree.model.Human;

public interface FamilyTreePresenter {
    void loadFamilyTree();
    void saveFamilyTree();
    void addMember(Human member);
    void sortByName();
    void sortByBirthDate();
}
