package com.project.familytree.model;

import com.project.familytree.data.DataHandler;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Serializable> implements Serializable, Iterable<T> {
    private static final long serialVersionUID = 1L;
    private List<T> members;
    private transient DataHandler<T> dataHandler;

    public FamilyTree(DataHandler<T> dataHandler) {
        this.members = new ArrayList<>();
        this.dataHandler = dataHandler;
    }

    public void addMember(T member) {
        members.add(member);
    }

    public T findMemberByName(String name) {
        for (T member : members) {
            if (member.toString().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }

    public void saveToFile(String filePath) throws IOException {
        dataHandler.writeToFile(filePath, this);
    }

    public void loadFromFile(String filePath) throws IOException, ClassNotFoundException {
        FamilyTree<T> loadedTree = dataHandler.readFromFile(filePath);
        this.members = loadedTree.members;
    }

    public List<T> getMembers() {
        return members;
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    public void sortByName() {
        members.sort(Comparator.comparing(Object::toString));
    }

    public void sortByBirthDate() {
        if (members.isEmpty() || !(members.get(0) instanceof Human)) {
            throw new UnsupportedOperationException("Sorting by birth date is only supported for Humans");
        }
        members.sort((Comparator<T>) Comparator.comparing(h -> ((Human) h).getBirthDate()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T member : members) {
            sb.append(member).append("\n");
        }
        return sb.toString();
    }
}
