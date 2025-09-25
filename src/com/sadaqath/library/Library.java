package com.sadaqath.library;

public class Library {
    private Book[] books = new Book[10];   
    private int bookCount = 0;

    private User[] users = new User[10];      
    private int userCount = 0;

    private Book[][] userBooks = new Book[10][10]; // Tracks books per user (userBooks[userIndex][bookIndex])
    private int[] userBookCount = new int[10];     // Count of books per user

    public void addBook(Book book) {
        if (bookCount < books.length) {
            books[bookCount++] = book;
        } else {
            System.out.println("Library is full!");
        }
    }

    public void showBooks() {
        System.out.println("\nLibrary Books:");
        for (int i = 0; i < bookCount; i++) {
            System.out.println(books[i]);
        }
    }

    public boolean registerUser(User user) {
        // Check duplicate ID
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUserId() == user.getUserId()) {
                return false; // ID exists
            }
        }
        if (userCount < users.length) {
            users[userCount++] = user;
            return true;
        } else {
            System.out.println("User limit reached!");
            return false;
        }
    }

    public void showUsers() {
        System.out.println("\nRegistered Users:");
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i]);
        }
    }

    public User getUser(int userId) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUserId() == userId) {
                return users[i];
            }
        }
        return null;
    }

    // Issue book to user
    public boolean issueBook(int userId, String title) {
        User user = getUser(userId);
        if (user == null) return false;

        int userIndex = getUserIndex(userId);

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title) && !books[i].isIssued()) {
                books[i].issueBook();
                userBooks[userIndex][userBookCount[userIndex]++] = books[i];
                return true;
            }
        }
        return false; // Book not available
    }

    public boolean returnBook(int userId, String title) {
        int userIndex = getUserIndex(userId);
        if (userIndex == -1) return false;

        for (int i = 0; i < userBookCount[userIndex]; i++) {
            if (userBooks[userIndex][i].getTitle().equalsIgnoreCase(title)) {
                userBooks[userIndex][i].returnBook();

                // Shift remaining books
                for (int j = i; j < userBookCount[userIndex] - 1; j++) {
                    userBooks[userIndex][j] = userBooks[userIndex][j + 1];
                }
                userBookCount[userIndex]--;
                return true;
            }
        }
        return false; // Book not found for user
    }

    // Helper: get index of user in array
    private int getUserIndex(int userId) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].getUserId() == userId) return i;
        }
        return -1;
    }
}
