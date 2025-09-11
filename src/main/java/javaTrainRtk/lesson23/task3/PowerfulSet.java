package javaTrainRtk.lesson23.task3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PowerfulSet {
    /**
     * Реализовать класс PowerfulSet, в котором должны быть следующие методы:
     * ● public <T> Set<T> intersection(Set<T> set1, Set<T> set2) – возвращает пересечение двух наборов.
     *  Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {1, 2}
     * ● public <T> Set<T> union(Set<T> set1, Set<T> set2) – возвращает объединение двух наборов
     *  Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {0, 1, 2, 3, 4}
     * ● public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) – возвращает элементы первого набора без тех, которые находятся также и во втором наборе.
     *  Пример: set1 = {1, 2, 3}, set2 = {0, 1, 2, 4}. Вернуть {3}
     */

    public <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
// Создаём новый HashSet, чтобы не изменять исходные
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }


    public <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }


    public <T> Set<T> relativeComplement(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }

    public static void main(String[] args) {

    System.out.println("=== Задача 3: PowerfulSet ===");
    PowerfulSet ps = new PowerfulSet();
    Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
    Set<Integer> set2 = new HashSet<>(Arrays.asList(0, 1, 2, 4));


System.out.println("set1 = " + set1);
System.out.println("set2 = " + set2);
System.out.println("intersection: " + ps.intersection(set1, set2));
System.out.println("union: " + ps.union(set1, set2));
System.out.println("relativeComplement (set1 \\ set2): " + ps.relativeComplement(set1, set2));
}
}