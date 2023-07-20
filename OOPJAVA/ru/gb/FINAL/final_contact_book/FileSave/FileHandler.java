package ru.gb.FINAL.final_contact_book.FileSave;


import ru.gb.FINAL.final_contact_book.Commands.ContactBook;

import java.io.*;

public class FileHandler {
    public static void saveContactBook(ContactBook<?> contactBook, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(contactBook);
            System.out.println("Записная книжка успешно сохранена.");
        } catch (IOException e) {
            System.out.println("Ошибка при сохранении записной книжки: " + e.getMessage());
        }
    }

    public static ContactBook<?> loadContactBook(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            ContactBook<?> contactBook = (ContactBook<?>) ois.readObject();
            System.out.println("Записная книжка успешно загружена.");
            return contactBook;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Ошибка при загрузке записной книжки: " + e.getMessage());
        }
        return null;
    }
}