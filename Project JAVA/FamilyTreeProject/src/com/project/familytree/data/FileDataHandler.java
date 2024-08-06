package com.project.familytree.data;

import com.project.familytree.model.FamilyTree;

import java.io.*;

public class FileDataHandler<T extends Serializable> implements DataHandler<T> {

    @Override
    public void writeToFile(String filePath, FamilyTree<T> familyTree) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(familyTree);
        }
    }

    @Override
    public FamilyTree<T> readFromFile(String filePath) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (FamilyTree<T>) ois.readObject();
        }
    }
}
