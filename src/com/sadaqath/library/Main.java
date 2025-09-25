package com.sadaqath.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);

        // sample books
        lib.addBook(new Book("Java Basics", "James"));
        lib.addBook(new Book("Data Structures", "Cormen"));
        lib.addBook(new Book("OOP Concepts", "Grady Booch"));

        System.out.println("=== Library Management System ===");

        while (true) {
            System.out.println("\n1. Show Books");
            System.out.println("2. Register User");
            System.out.println("3. Show Users");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    lib.showBooks();
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine().trim();
                    System.out.print("Enter User ID (numeric): ");
                    String idStr = sc.nextLine().trim();
                    try {
                        int id = Integer.parseInt(idStr);
                        boolean ok = lib.registerUser(new User(name, id));
                        System.out.println(ok ? "User registered." : "User ID already exists.");
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid ID. Must be a number.");
                    }
                    break;
                case 3:
                    lib.showUsers();
                    break;
                case 4:
                    System.out.print("Enter User ID: ");
                    String uidStr = sc.nextLine().trim();
                    System.out.print("Enter Book Title: ");
                    String issueTitle = sc.nextLine().trim();
                    try {
                        int uid = Integer.parseInt(uidStr);
                        if (lib.getUser(uid) == null) {
                            System.out.println("User not registered. Register first.");
                        } else if (lib.issueBook(uid, issueTitle)) {
                            System.out.println("Book issued to user " + uid);
                        } else {
                            System.out.println("Book not available.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid User ID.");
                    }
                    break;
                case 5:
                    System.out.print("Enter User ID: ");
                    String ruidStr = sc.nextLine().trim();
                    System.out.print("Enter Book Title: ");
                    String returnTitle = sc.nextLine().trim();
                    try {
                        int ruid = Integer.parseInt(ruidStr);
                        if (lib.returnBook(ruid, returnTitle)) {
                            System.out.println("Book returned.");
                        } else {
                            System.out.println("No matching record found.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid User ID.");
                    }
                    break;
                case 6:
                    System.out.println("Exiting. Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
