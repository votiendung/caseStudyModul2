package controller;

import model.Book;

import java.io.*;
import java.util.LinkedHashMap;

public class FileController {
    public static void writeBookToFile(LinkedHashMap<Integer, Book> bookList, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(bookList);
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static LinkedHashMap<Integer, Book> readBookFromFile(String path) {
        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Object bookList = objectInputStream.readObject();
            objectInputStream.close();
            return (LinkedHashMap<Integer, Book>) bookList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
