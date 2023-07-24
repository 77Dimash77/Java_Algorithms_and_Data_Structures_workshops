package ru.gb.iskluchenia.Zadanie4;

import java.util.Scanner;

public class EmptyStringExceptionExample {
    public static void main(String[] args) {
        try {
            String userInput = readNonEmptyString();
            System.out.println("Вы ввели: " + userInput);
        } catch (Exception e) {
            System.out.println("Ошибка: Пустые строки вводить нельзя.");
        }
    }

    public static String readNonEmptyString() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите непустую строку: ");
        String input = scanner.nextLine();

        if (input.isEmpty()) {
            throw new Exception();
        }

        return input;
    }
}