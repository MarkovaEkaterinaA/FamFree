package com.project.familytree.service;

import com.project.familytree.model.Human;

import java.io.IOException;
import java.util.List;

public interface IFamilyTreeService {
    void addHuman(Human human);
    Human findHuman(String name);
    void sortByName();
    void sortByBirthDate();
    List<Human> getFamilyTree();
    void loadTree(String string);
    void saveTree(String string) throws IOException;
}
