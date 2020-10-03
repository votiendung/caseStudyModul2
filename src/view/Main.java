package view;

import controller.BookManager;
import controller.FileController;
import model.Book;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static LinkedHashMap<Integer, Book> integerBookLinkedHashMap;

    public static void menu() {

        System.out.println("----------------MENU----------------");
        System.out.println("1. Add new book");
        System.out.println("2. Display book list");
        System.out.println("3. Edit book list");
        System.out.println("4. ");
        System.out.println("0. Exit");
        System.out.println("-------------------------------------");
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1 -> {
                BookManager.add();
                FileController.writeBookToFile(BookManager.bookMap, "books.dat");
            }
            case 2 -> {
                BookManager.display();
            }
            case 3 -> {
                BookManager.editBook();
            }
            case 4 -> {

            }
            case 0 -> {
                System.err.println("Thank you!");
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        BookManager.bookMap = FileController.readBookFromFile("books.dat");
        while (true) {
            menu();
        }


    }
}
