package javaTrainRtk.task3;

import java.util.Scanner;


/**
 * Домашнее задание по темам «Классы: поля, свойства, методы»
 * Формулировка задания:
 * Реализовать класс Телевизор. У класса есть поля, свойства и методы.
 * Проверить работу в классе App, методе main.
 * Ожидаемый результат:
 * 1. Создан класс Телевизор;
 * 2. У класса есть поля, свойства и методы. Поля желательно сделать
 * private. Задать новые значения полям класса можно через конструктор.
 * 4. Создан класс App с методом main.
 * 5. В методе main класса App создано несколько экземпляров класса
 * Телевизор.
 * 6. Дополнительно. Задавать параметры класса Телевизор с клавиатуры
 * или случайным числом.
 */

public class App {

    // Создадим 3 ТВ с заданными параметрами и один с рандомными
    public static void main(String[] args) {
        Tv tv1 = new Tv("Sony", "Super", 30.6, false);
        Tv tv2 = new Tv("Samsung", "Puper", 50.0, true);
        Tv randomTv = new Tv();

        System.out.println("ТВ1:" + tv1);
        System.out.println("ТВ2:" + tv2);
        System.out.println("Случайный ТВ " + randomTv);
        tv1.showInfo();
        tv2.showInfo();
        randomTv.showInfo();

        Scanner scanner = new Scanner(System.in); // создаём объект Scanner для чтения ввода
        System.out.print("Введите бренд производителя ТВ: ");   // выводим приглашение к вводу
        String brand = scanner.nextLine();         // считываем введённую строку
        System.out.print("Введите модель ТВ: ");   // выводим приглашение к вводу
        String model = scanner.nextLine();
        System.out.print("Введите желаемую Диагональ (в дюймах, например 42.5 или 42,5)): ");   // выводим приглашение к вводу
        Double screenDiagonal = scanner.nextDouble();
        System.out.print("Поддержка Smart TV (true/false): ");   // выводим приглашение к вводу
        boolean smartTvSupport = scanner.nextBoolean();
        scanner.close();
        Tv tv5 = new Tv(brand, model, screenDiagonal, smartTvSupport);
        tv5.showInfo();

    }
}
