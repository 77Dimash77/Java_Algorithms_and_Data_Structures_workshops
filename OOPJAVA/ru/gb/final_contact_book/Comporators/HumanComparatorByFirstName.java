package ru.gb.final_contact_book.Comporators;

import ru.gb.final_contact_book.M.Model.Contact;

import java.util.Comparator;

public class HumanComparatorByFirstName<T extends Contact> implements Comparator<T> {
    @Override
    public int compare(T c1, T c2) {
        return c1.getFirstName().compareTo(c2.getFirstName());
    }
}