package javaTrainRtk.task2;

import java.util.Random;

/**
 * Задача 2*. Вася и Петя играют в игру “Камень, ножницы, бумага”.
 * Каждый из них показывает свою фигуру камень-0, ножницы-1, бумага-2.
 * Программа определяет, кто из них выиграл.
 * Выбор каждого участника формируется случайным образом.
 */
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        String[] figureName = { "Камень", "Ножницы", "Бумага" };
        String vasyaChoice = figureName[random.nextInt(figureName.length)];
        String petyaChoice = figureName[random.nextInt(figureName.length)];

        System.out.println("Вася выбрал: " + vasyaChoice);
        System.out.println("Петя выбрал: " + petyaChoice);

        if (vasyaChoice.equals(petyaChoice)) {
            System.out.println("Ничья!");
        } else if (
            (vasyaChoice.equals("Камень") && petyaChoice.equals("Ножницы")) ||
            (vasyaChoice.equals("Ножницы") && petyaChoice.equals("Бумага")) ||
            (vasyaChoice.equals("Бумага") && petyaChoice.equals("Камень"))
        ) {
            System.out.println("Победил Вася!");
        } else {
            System.out.println("Победил Петя!");
        }
    }
}