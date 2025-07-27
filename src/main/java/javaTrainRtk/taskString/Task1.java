package javaTrainRtk.taskString;

import java.util.*;

/**
 * Задача 1. Для введенной с клавиатуры буквы английского алфавита
 * нужно вывести слева стоящую букву на стандартной клавиатуре. При этом
 * клавиатура замкнута, т.е. справа от буквы «p» стоит буква «a», а слева от "а"
 * буква "р"
 * , также соседними считаются буквы «l» и буква «z», а буква «m» с
 * буквой «q».
 * Входные данные: строка входного потока содержит один символ —
 * маленькую букву английского алфавита.
 * Выходные данные: следует вывести букву стоящую слева от заданной
 * буквы, с учетом замкнутости клавиатуры.
 */

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите маленькую букву английского алфавита: ");
        char input = scanner.next().charAt(0);
        System.out.println("Вы ввели: " + input);
        scanner.close();

        // Замкнутый ряд клавиш:
        // q w e r t y u i o p a s d f g h j k l z x c v b n m
        String keyboard = "qwertyuiopasdfghjklzxcvbnm";

        int index = keyboard.indexOf(input);
        if(index == -1) {
            System.out.println("Некорректный ввод, введите букву");
            return;
        }
        int leftIndex = (index - 1 + keyboard.length()) % keyboard.length();
        System.out.println("Буква которая расположена слева от введенной: " + keyboard.charAt(leftIndex));
    }
}