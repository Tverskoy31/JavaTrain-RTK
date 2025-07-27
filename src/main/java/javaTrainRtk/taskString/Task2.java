package javaTrainRtk.taskString;

import java.util.Random;
import java.util.Scanner;

/**
 * Задача 2. Задана последовательность, состоящая только из символов ‘>’,‘<’ и ‘-‘
 * Требуется найти количество стрел, которые спрятаны в этой последовательности.
 * Стрелы – это подстроки вида ‘>>-->’ и ‘<--<<’.
 * Входные данные:
 * в первой строке входного потока записана строка, состоящая из символов ‘>’,‘<’ и ‘-‘ (без пробелов).
 * Строка может содержать до 106 символов.
 * Выходные данные: в единственную строку выходного потока нужно вывести искомое количество стрелок
 */

public class Task2 {
    public static void main(String[] args) {
        int length = 106; // длина случайной последовательности
        char[] symbols = {'>', '<', '-'};
        StringBuilder sequenceBuilder = new StringBuilder(length);
        Random random = new Random();

        for (int i = 0; i < length; i++) {
            sequenceBuilder.append(symbols[random.nextInt(symbols.length)]);
        }

        String sequence = sequenceBuilder.toString();
        System.out.println("Сгенерированная последовательность: " + sequence);
        int count = 0;
        for (int i = 0; i < length - 4; i++) {
            String substring = sequence.substring(i, i + 5);
            if (substring.equals(">>-->") || substring.equals("<--<<")) {
                count++;
            }
        }
        System.out.println("Количество стрелок: " + count);
    }
}