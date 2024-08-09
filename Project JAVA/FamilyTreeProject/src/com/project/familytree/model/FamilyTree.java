package com.project.familytree.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T human) {
        members.add(human);
    }

    public T findByName(String name) {
        for (T human : members) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public List<T> getMembers() {
        return members;
    }

    @Override
    public Iterator<T> iterator() {
        return members.iterator();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T human : members) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }
}
