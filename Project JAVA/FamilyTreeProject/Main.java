package com.project;

import com.project.familytree.presenter.FamilyTreePresenter;
import com.project.familytree.presenter.FamilyTreePresenterImpl;
import com.project.familytree.service.FamilyTreeService;
import com.project.familytree.data.FileDataHandler;
import com.project.familytree.view.ConsoleFamilyTreeView;

public class Main {
    public static void main(String[] args) {
        ConsoleFamilyTreeView view = new ConsoleFamilyTreeView();
        FamilyTreeService service = new FamilyTreeService(new FileDataHandler<>());
        FamilyTreePresenter presenter = new FamilyTreePresenterImpl(view, service);

        presenter.showMenu();
    }
}
