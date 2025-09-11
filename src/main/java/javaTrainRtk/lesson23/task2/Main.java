package javaTrainRtk.lesson23.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * С консоли на вход подается две строки s и t. Необходимо вывести true, если одна строка является валидной анаграммой другой строки, и false – если это не так.
     * Анаграмма – это слово, или фраза, образованная путем перестановки букв другого слова или фразы, обычно с использованием всех исходных букв ровно один раз.
     * Для проверки:
     * ● Бейсбол – бобслей
     * ● Героин – регион
     * ● Клоака – околка
     */

    public static String normalize (String s){
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString();
    }

    public static boolean isAnagram (String s, String t){
        if (s == null || t == null) return false;

// Нормализация: убрать все не буквенно-цифровые символы (включая пробелы), привести к нижнему регистру
        String ns = normalize(s);
        String nt = normalize(t);

// Быстрая проверка длины
        if (ns.length() != nt.length()) return false;

// Проверка на анаграммы с помощью сортировки
        char[] a = ns.toCharArray();
        char[] b = nt.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);

        return Arrays.equals(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 2 слова через дефис, например:Бейсбол – бобслей");
        String line = sc.nextLine().trim();
        String[] parts = line.split("-");
        String s = parts[0].trim();
        String t = parts[1].trim();

        System.out.printf("%s <-> %s : %b\n", s, t, isAnagram(s, t));

    }
}
