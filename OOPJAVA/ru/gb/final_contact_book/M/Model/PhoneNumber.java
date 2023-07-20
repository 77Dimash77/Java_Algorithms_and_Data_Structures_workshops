package ru.gb.final_contact_book.M.Model;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return number;
    }
}
