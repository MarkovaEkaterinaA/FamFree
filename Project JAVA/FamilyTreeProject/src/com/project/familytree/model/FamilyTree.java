package com.project.familytree.model;

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
public class FamilyTree<T extends Human> implements Serializable, Iterable<T> {
    private List<T> members;

    public FamilyTree() {
        this.members = new ArrayList<>();
    }

    public void addMember(T human) {
        members.add(human);
    }

    public void addParentChildRelation(T parent, T child) {
        parent.addChild(child);
        child.setParent(parent);
    }


}
