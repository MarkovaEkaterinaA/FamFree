package com.project.familytree.data;

import com.project.familytree.model.FamilyTree;

import java.io.IOException;

public interface DataHandler<T extends java.io.Serializable> {
    void writeToFile(String filePath, FamilyTree<T> familyTree) throws IOException;
    FamilyTree<T> readFromFile(String filePath) throws IOException, ClassNotFoundException;
}
