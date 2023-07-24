package ru.gb.iskluchenia.Zadanie1;

import java.util.Scanner;

public class UserInput {
    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float value = 0.0f;
        boolean isValidInput = false;

        do {
            try {
                System.out.print("Введите дробное число: ");
                String input = scanner.nextLine();
                value = Float.parseFloat(input);
                isValidInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Введено некорректное число. Попробуйте снова.");
            }
        } while (!isValidInput);

        return value;
    }

    public static void main(String[] args) {
        float number = getFloatInput();
        System.out.println("Вы ввели: " + number);
    }
}