package com.project.familytree.view;

import java.util.Scanner;

public class ConsoleFamilyTreeView {
    private final Scanner scanner;

    public ConsoleFamilyTreeView() {
        this.scanner = new Scanner(System.in);
    }

    public void displayMenu() {
        System.out.println("1. Display Family Tree");
        System.out.println("2. Add Human");
        System.out.println("3. Sort by Name");
        System.out.println("4. Sort by Birth Date");
        System.out.println("5. Save Family Tree");
        System.out.println("6. Load Family Tree");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    public int getUserInput() {
        return Integer.parseInt(scanner.nextLine());
    }

    public void displayTree(String tree) {
        System.out.println("Family Tree:");
        System.out.println(tree);
    }

    public String[] getHumanData() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter birth date (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();
        System.out.print("Enter gender (MALE/FEMALE): ");
        String gender = scanner.nextLine();
        return new String[]{name, birthDate, gender};
    }

    public void showMessage(String message) {
        System.out.println(message);
    }
}
