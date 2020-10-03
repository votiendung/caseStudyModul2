package model;

import java.io.Serializable;

public class Book implements Serializable {
    private static int id = 1000000;
    private int bookID;
    private String bookName;
    private String author;
    private String specialization;
    private double price;
    private int quantity;
    private String publisher;


    public Book() {
    }

    public Book(int quantity) {
        this.quantity = quantity;
    }

    public Book(int bookID, String bookName, String author, String specialization,
                double price, int quantity, String publisher) {
        if (bookID == 0) {
            this.bookID = id++;
        } else {
            this.bookID = bookID;
        }
        this.bookName = bookName;
        this.author = author;
        this.specialization = specialization;
        this.price = price;
        this.quantity = quantity;
        this.publisher = publisher;
    }

    public void input() {

    }

    public void output() {
        System.out.println(toString());
    }
    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Book.id = id;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", specialization='" + specialization + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
