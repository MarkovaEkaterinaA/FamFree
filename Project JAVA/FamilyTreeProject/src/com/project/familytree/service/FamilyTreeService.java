package com.project.familytree.service;

import com.project.familytree.model.FamilyTree;
import com.project.familytree.model.Human;
import com.project.familytree.data.IDataHandler;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FamilyTreeService implements IFamilyTreeService {
    private FamilyTree<Human> familyTree;
    private IDataHandler<FamilyTree<Human>> dataHandler;

    public FamilyTreeService(IDataHandler<FamilyTree<Human>> dataHandler) {
        this.familyTree = new FamilyTree<>();
        this.dataHandler = dataHandler;
    }

    @Override
    public void addHuman(Human human) {
        familyTree.addMember(human);
    }

    @Override
    public Human findHuman(String name) {
        return familyTree.findByName(name);
    }

    @Override
    public void sortByName() {
        familyTree.getMembers().sort(Comparator.comparing(Human::getName));
    }

    @Override
    public void sortByBirthDate() {
        familyTree.getMembers().sort(Comparator.comparing(Human::getBirthDate));
    }

    @Override
    public List<Human> getFamilyTree() {
        return familyTree.getMembers();
    }

    public void saveTree(String filename) throws IOException {
        dataHandler.save(familyTree, filename);
    }

    public void loadTree(String filename) {
        this.familyTree = dataHandler.load(filename);
    }
}
