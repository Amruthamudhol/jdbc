package com.xworkz.library.unchecked;

public class AppStarter {
    public static void main(String[] args) {

        BookCreator bookCreator = new BookCreator();
        System.out.println("before method execution");

        try {
            System.out.println("running try block");
            bookCreator.addBook("  ");
            System.out.println("after method execution in try block");
        } catch (Exception e) {
            System.err.println("Exception handled");
        }

        System.out.println("after method execution");
        System.out.println("dummy code start");
        System.out.println("dummy line 1");
        System.out.println("dummy line 2");

    }
}
