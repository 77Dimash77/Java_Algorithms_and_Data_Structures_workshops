package ru.gb.iskluchenia.Final;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class DataFormatException extends Exception {
    public DataFormatException(String message) {
        super(message);
    }
}

public class UserInputData {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Введите данные (Фамилия Имя Отчество датарождения номертелефона пол): ");
            String userInput = scanner.nextLine();

            String[] data = userInput.split(" ");
            if (data.length != 6) {
                throw new DataFormatException("Неверное количество данных!");
            }

            String surname = data[0];
            String name = data[1];
            String patronymic = data[2];
            String birthDate = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            if (gender != 'f' && gender != 'm') {
                throw new DataFormatException("Некорректный формат поля 'пол' (должен быть 'f' или 'm')!");
            }

            String fileName = surname + ".txt";
            String record = surname + " " + name + " " + patronymic + " " + birthDate + " " + phoneNumber + " " + gender;

            try (FileWriter fileWriter = new FileWriter(fileName, true)) {
                fileWriter.write(record + System.lineSeparator());
                System.out.println("Данные успешно записаны в файл: " + fileName);
            } catch (IOException e) {
                System.err.println("Ошибка при записи данных в файл!");
                e.printStackTrace();
            }
        } catch (DataFormatException e) {
            System.err.println("Ошибка: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Ошибка: Некорректный формат номера телефона!");
        } catch (Exception e) {
            System.err.println("Ошибка: Что-то пошло не так...");
            e.printStackTrace();
        }
    }
}
