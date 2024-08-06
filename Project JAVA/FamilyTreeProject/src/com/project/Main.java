package com.project;

import com.project.familytree.model.Gender;
import com.project.familytree.model.Human;
import com.project.familytree.presenter.FamilyTreePresenter;
import com.project.familytree.presenter.FamilyTreePresenterImpl;
import com.project.familytree.view.ConsoleFamilyTreeView;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreePresenter presenter = new FamilyTreePresenterImpl(view);

        Human olga = new Human("Ольга", LocalDate.of(1960, 1, 1), null, Gender.FEMALE, null, null);
        Human anatoliy = new Human("Анатолий", LocalDate.of(1958, 1, 1), null, Gender.MALE, null, null);
        Human katya = new Human("Катя", LocalDate.of(1980, 1, 1), null, Gender.FEMALE, anatoliy, olga);
        Human nikita = new Human("Никита", LocalDate.of(1982, 1, 1), null, Gender.MALE, anatoliy, olga);

        presenter.addMember(olga);
        presenter.addMember(anatoliy);
        presenter.addMember(katya);
        presenter.addMember(nikita);

        presenter.saveFamilyTree();
        presenter.loadFamilyTree();
        presenter.sortByName();
        presenter.sortByBirthDate();
    }
}
