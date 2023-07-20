package ru.gb.FINAL.final_contact_book.Commands;




import ru.gb.FINAL.final_contact_book.M.Model.Contact;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;

public class ContactBook<T extends Contact> {
    private List<T> contacts;

    public ContactBook() {
        this.contacts = new ArrayList<>();
    }

    public void addContact(T contact) {
        contacts.add(contact);
    }

    public String getContactInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T contact : contacts) {
            stringBuilder.append(contact);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortContacts(Comparator<T> comparator) {
        contacts.sort(comparator);
    }

    public void sortContactsByLastName() {
        sortContacts(Comparator.comparing(Contact::getLastName));
    }

    public void sortContactsByFirstName() {
        sortContacts(Comparator.comparing(Contact::getFirstName));
    }

    public void sortContactsByAge() {
        sortContacts(Comparator.comparing(Contact::getDateOfBirth));
    }
}