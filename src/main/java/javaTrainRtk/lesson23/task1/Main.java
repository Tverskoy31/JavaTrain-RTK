package javaTrainRtk.lesson23.task1;

import java.util.*;

public class Main {
    /**
     * Реализовать метод, который на вход принимает ArrayList<T>, а возвращает набор
     * уникальных элементов этого массива. Решить, используя коллекции
     */
    // Используем HashSet, который оставит только уникальные элементы
    public static <T> Set<T> uniqueElements(ArrayList<T> list) {
        return new HashSet<>(list);
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 4, 4, 5));
        Set<Integer> unique = uniqueElements(nums);
        System.out.println("Вход: " + nums);
        System.out.println("Уникальные: " + unique);
    }
}