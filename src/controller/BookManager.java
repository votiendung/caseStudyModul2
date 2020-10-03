package controller;

import model.Book;

import java.util.*;

public class BookManager {
    public static LinkedHashMap<Integer, Book> bookMap = new LinkedHashMap<>();

    public static void add() {
        System.out.println("-------------------------");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter bookname: ");
        String bookName = input.nextLine();

        System.out.println("Enter quantity: ");
        int quantity = Integer.parseInt(input.nextLine());

        boolean isBookExist = false;
        boolean isCheck = false;

        if (!isCheck) {
            changeId();
            isCheck = true;
        }
        Set<Map.Entry<Integer, Book>> entries = bookMap.entrySet();
        for (Map.Entry<Integer, Book> bookEntry : entries) {
            Book value = bookEntry.getValue();
            String name = value.getBookName();
            if (name.equals(bookName)) {
                isBookExist = true;
                quantity += value.getQuantity();
                value.setQuantity(quantity);
                System.out.println("This book've already existed");
                break;
            }
        }
        if (!isBookExist) {
            System.out.println("Enter author: ");
            String author = input.nextLine();
            int choice;
            String[] specList = {"Science", "Art", "Economics", "IT"};
            do {
                System.out.println("-----------SPECIALIZATION-----------");
                System.out.println("1. Science\n2. Art\n3. Economics\n4. IT");
                System.out.println("Enter specialization: ");
                choice = Integer.parseInt(input.nextLine());
            } while (choice < 1 || choice > 4);
            String specialization = specList[choice - 1];
            System.out.println("Enter price: ");
            double price = Double.parseDouble(input.nextLine());
            System.out.println("Enter publisher: ");
            String publisher = input.nextLine();
            Book book = new Book(0, bookName, author, specialization, price, quantity, publisher);
            bookMap.put(book.getBookID(), book);
        }

    }

    private static void changeId() {
        Set<Map.Entry<Integer, Book>> entries = bookMap.entrySet();
        ArrayList<Map.Entry<Integer, Book>> arrayList = new ArrayList<>(entries);
        if (arrayList.size() > 0) {
            Map.Entry<Integer, Book> bookEntry = arrayList.get(arrayList.size() - 1);
            int bookID = bookEntry.getValue().getBookID();
            Book.setId(bookID + 1);
        }
    }

    public static void display() {
        Set<Map.Entry<Integer, Book>> entries = bookMap.entrySet();
        for (Map.Entry<Integer, Book> entry : entries) {
            System.out.println(entry.getValue());
        }
    }

    public static void editBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        String bookName = new Scanner(System.in).nextLine();
        Set<Map.Entry<Integer, Book>> bookEntry = bookMap.entrySet();
        for (Map.Entry<Integer, Book> entry: bookEntry) {
            if (entry.getValue().getBookName().equalsIgnoreCase(bookName)) {
                System.out.println("Enter new name: ");
                String newName = sc.nextLine();
                System.out.println("Enter new author: ");
                String newAuthor = sc.nextLine();
                int choice;
                String[] specList = {"Science", "Art", "Economics", "IT"};
                do {
                    System.out.println("-----------SPECIALIZATION-----------");
                    System.out.println("1. Science\n2. Art\n3. Economics\n4. IT");
                    System.out.println("Enter new specialization: ");
                    choice = Integer.parseInt(sc.nextLine());
                } while (choice < 1 || choice > 4);
                String newSpec = specList[choice - 1];
                System.out.println("Enter new price: ");
                double newPrice = Double.parseDouble(sc.nextLine());
                System.out.println("Enter new publisher: ");
                String newPublisher = sc.nextLine();
                entry.getValue().setBookName(newName);
                entry.getValue().setAuthor(newAuthor);
                entry.getValue().setSpecialization(newSpec);
                entry.getValue().setPrice(newPrice);
                entry.getValue().setPublisher(newPublisher);
            }
        }
    }
}

