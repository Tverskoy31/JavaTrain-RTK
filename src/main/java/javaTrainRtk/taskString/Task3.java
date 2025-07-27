package javaTrainRtk.taskString;

import java.util.*;

/**
 * Задача 3*
 * Задана строка, состоящая из букв английского алфавита разделенных одним пробелом.
 * Необходимо каждую последовательность символов упорядочить по возрастанию
 * и вывести слова в нижнем регистре.
 * Входные данные: в единственной строке последовательность символов представляющее два слова.
 * Выходные данные: упорядоченные по возрастанию буквы в нижнем регистре.
 */

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку из букв английского алфавита разделенных одним пробелом:");
        String line = scanner.nextLine().toLowerCase(); // приведение к нижнему регистру
        scanner.close();

        String[] words = line.split(" ");
        for (String word : words) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            System.out.print(new String(chars) + " ");
        }
    }
}

