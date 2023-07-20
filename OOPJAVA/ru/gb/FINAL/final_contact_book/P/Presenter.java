package ru.gb.FINAL.final_contact_book.P;

import ru.gb.FINAL.final_contact_book.Commands.ContactBook;
import ru.gb.FINAL.final_contact_book.M.Enum.Gender;
import ru.gb.FINAL.final_contact_book.M.Model.Contact;
import ru.gb.FINAL.final_contact_book.M.Model.PhoneNumber;
import ru.gb.FINAL.final_contact_book.V.View;

import java.time.LocalDate;
import java.util.List;

public class Presenter {
    private View view;
    private ContactBook<Contact> contactBook;

    public Presenter(View view) {
        this.view = view;
        this.contactBook = new ContactBook<>();
    }

    public void addContact(String firstName, String lastName, Gender gender, LocalDate dateOfBirth, List<String> phoneNumbers) {
        Contact contact = new Contact(firstName, lastName, gender, dateOfBirth);
        for (String phoneNumber : phoneNumbers) {
            contact.addPhoneNumber(new PhoneNumber(phoneNumber));
        }
        contactBook.addContact(contact);
    }

    public String getContactInfo() {
        return contactBook.getContactInfo();
    }

    public void sortByLastName() {
        contactBook.sortContactsByLastName();
    }

    public void sortByFirstName() {
        contactBook.sortContactsByFirstName();
    }

    public void sortByAge() {
        contactBook.sortContactsByAge();
    }
}