package com.xworkz.library.unchecked;

public class BookCreator {
    public void addBook(String title) {

        System.out.println("Running addBook()");

        if (title == null || title.trim().length() < 3 || title.trim().length() > 30 || title.contains("  ")) {

            System.err.println("Book title cannot be null, length should be between 3 and 30, and should not contain multiple spaces");

            throw new IllegalArgumentException("Invalid book title");
        }
        System.out.println("Book added successfully");
    }
}
