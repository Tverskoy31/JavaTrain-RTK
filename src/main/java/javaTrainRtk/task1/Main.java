package javaTrainRtk.task1;


import java.util.Scanner;


/**
* Задача 1. Составить программу вывода на экран в одну строку сообщения
* «Привет, имя_пользователя», где «имя_пользователя» - это введёное в консоль
* имя, для выполнения данного задания нужно использовать класс Scanner.
*/

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // создаём объект Scanner для чтения ввода
        System.out.print("Введите ваше имя: ");   // выводим приглашение к вводу
        String name = scanner.nextLine();         // считываем введённую строку
        System.out.println("Привет, " + name);    // выводим приветствие
        scanner.close();                          // закрываем Scanner
    }
}