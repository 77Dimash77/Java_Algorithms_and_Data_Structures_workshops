package ru.gb.final_contact_book.V;

public class MainMenu {
    private StringBuilder menu;

    public MainMenu() {
        menu = new StringBuilder();
        menu.append("Доступные команды:\n");
        menu.append("add - Добавить новый контакт\n");
        menu.append("info - Отобразить информацию о контактах\n");
        menu.append("sort - Сортировать контакты\n");
        menu.append("exit - Выйти из программы\n");
        menu.append("Введите команду:");
    }

    public String getMenu() {
        return menu.toString();
    }
}