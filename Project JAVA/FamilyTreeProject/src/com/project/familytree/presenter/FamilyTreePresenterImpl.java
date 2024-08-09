package com.project.familytree.presenter;

import com.project.familytree.model.Gender;
import com.project.familytree.model.Human;
import com.project.familytree.service.IFamilyTreeService;
import com.project.familytree.view.ConsoleFamilyTreeView;

import java.time.LocalDate;
import java.util.Scanner;

public class FamilyTreePresenterImpl implements FamilyTreePresenter {
    private final ConsoleFamilyTreeView view;
    private final IFamilyTreeService service;

    public FamilyTreePresenterImpl(ConsoleFamilyTreeView view, IFamilyTreeService service) {
        this.view = view;
        this.service = service;
    }

    @Override
    public void showMenu() {
        boolean running = true;
        while (running) {
            view.displayMenu();
            int choice = view.getUserInput();
            switch (choice) {
                case 1 -> displayFamilyTree();
                case 2 -> addHuman();
                case 3 -> sortByName();
                case 4 -> sortByBirthDate();
                case 5 -> saveFamilyTree();
                case 6 -> loadFamilyTree();
                case 0 -> running = false;
                default -> view.showMessage("Invalid choice. Please try again.");
            }
        }
    }

    @Override
    public void addHuman() {
        String[] data = view.getHumanData();
        Human human = new Human(data[0], LocalDate.parse(data[1]), Gender.valueOf(data[2]), null, null);
        service.addHuman(human);
        view.showMessage("Human added successfully.");
    }

    @Override
    public void displayFamilyTree() {
        view.displayTree(service.getFamilyTree().toString());
    }

    @Override
    public void sortByName() {
        service.sortByName();
        view.showMessage("Family tree sorted by name.");
    }

    @Override
    public void sortByBirthDate() {
        service.sortByBirthDate();
        view.showMessage("Family tree sorted by birth date.");
    }

    @Override
    public void saveFamilyTree() {
        try {
            service.saveTree("familytree.dat");
            view.showMessage("Family tree saved successfully.");
        } catch (Exception e) {
            view.showMessage("Error saving family tree: " + e.getMessage());
        }
    }

    @Override
    public void loadFamilyTree() {
        try {
            service.loadTree("familytree.dat");
            view.showMessage("Family tree loaded successfully.");
        } catch (Exception e) {
            view.showMessage("Error loading family tree: " + e.getMessage());
        }
    }
}
