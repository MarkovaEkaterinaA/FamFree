package com.project.familytree.model;

import java.util.List;

public interface IFamilyTree<T extends Human> {
    void addMember(T human);
    T findByName(String name);
    List<T> getMembers();
}
