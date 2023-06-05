package ru.netology;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Logger logger = Logger.getInstance();
        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");

        Scanner input = new Scanner(System.in);
        int listSize = 0;

        while (listSize <= 0) {
            System.out.print("Введите размер списка: ");
            listSize = input.nextInt();
            if (listSize < 0) {
                System.out.println("Не корректное значение: размер списка должен быть больше 0!");
            }
        }

        System.out.printf("Введите верхнюю границу для значений: ");
        int maxValue = input.nextInt();

        logger.log("Создаём и наполняем список");
        List<Integer> list = fillInList(listSize, maxValue);
        System.out.println("Вот случайный список: " + list);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        System.out.print("Введите порог для фильтра: ");
        int f = input.nextInt();
        Filter filter = new Filter(f);
        System.out.println("Отфильтрованный список: " +   filter.filterOut(list));

        logger.log("Завершаем программу");

    }

    public static List<Integer> fillInList(int listSize, int maxValue) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < listSize; i++) {
            Random random = new Random();
            list.add(random.nextInt(maxValue));
        }
        return list;
    }
}