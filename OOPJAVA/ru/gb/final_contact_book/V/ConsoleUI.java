package ru.gb.final_contact_book.V;


import ru.gb.final_contact_book.M.Enum.Gender;
import ru.gb.final_contact_book.P.Presenter;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean running;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        running = true;
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        System.out.println("Добро пожаловать в Контактную книгу!");
        while (running) {
            System.out.println("Доступные команды:\nadd - Добавить контакт\ninfo - Отобразить информацию о контактах\nsort - Сортировать контакты\nexit - Выйти из программы");
            System.out.print("Введите команду: ");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    addContact();
                    break;
                case "info":
                    displayContactInfo();
                    break;
                case "sort":
                    sortContacts();
                    break;
                case "exit":
                    exitProgram();
                    break;
                default:
                    System.out.println("Неверная команда. Пожалуйста, попробуйте снова.");
                    break;
            }
        }
    }

    private void addContact() {
        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите пол (Мужской/Женский): ");
        String genderInput = scanner.nextLine();
        Gender gender;
        if (genderInput.equalsIgnoreCase("Мужской")) {
            gender = Gender.MALE;
        } else if (genderInput.equalsIgnoreCase("Женский")) {
            gender = Gender.FEMALE;
        } else {
            System.out.println("Неверный пол. Пожалуйста, попробуйте снова.");
            return;
        }
        System.out.print("Введите дату рождения (ГГГГ-ММ-ДД): ");
        String dobInput = scanner.nextLine();
        LocalDate dateOfBirth;
        try {
            dateOfBirth = LocalDate.parse(dobInput);
        } catch (Exception e) {
            System.out.println("Неверный формат даты. Пожалуйста, попробуйте снова.");
            return;
        }
        System.out.print("Введите номера телефонов (через запятую): ");
        String phoneNumbersInput = scanner.nextLine();
        String[] phoneNumberArray = phoneNumbersInput.split(",");
        List<String> phoneNumbers = Arrays.asList(phoneNumberArray);
        presenter.addContact(firstName, lastName, gender, dateOfBirth, phoneNumbers);
        System.out.println("Контакт успешно добавлен.");
    }

    private void displayContactInfo() {
        String contactInfo = presenter.getContactInfo();
        if (contactInfo.isEmpty()) {
            System.out.println("Контакты не найдены.");
        } else {
            System.out.println(contactInfo);
        }
    }

    private void sortContacts() {
        System.out.println("Варианты сортировки:\n1. Сортировать по фамилии\n2. Сортировать по имени\n3. Сортировать по возрасту");
        System.out.print("Введите ваш выбор: ");
        String choiceInput = scanner.nextLine();
        switch (choiceInput) {
            case "1":
                presenter.sortByLastName();
                System.out.println("Контакты отсортированы по фамилии.");
                break;
            case "2":
                presenter.sortByFirstName();
                System.out.println("Контакты отсортированы по имени.");
                break;
            case "3":
                presenter.sortByAge();
                System.out.println("Контакты отсортированы по возрасту.");
                break;
            default:
                System.out.println("Неверный выбор. Пожалуйста, попробуйте снова.");
                break;
        }
    }

    private void exitProgram() {
        System.out.println("Завершение программы...");
        running = false;
    }
}