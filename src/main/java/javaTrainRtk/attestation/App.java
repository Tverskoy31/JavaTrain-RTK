package javaTrainRtk.attestation;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Введите покупателей: Имя = Деньги (через ;) ");
            String[] peopleInput = sc.nextLine().split(";");
            Map<String, Person> people = new LinkedHashMap<>();
            for (String p : peopleInput) {
                String[] parts = p.trim().split("=");
                people.put(parts[0].trim(), new Person(parts[0].trim(), Integer.parseInt(parts[1].trim())));
            }

            System.out.println("Введите продукты: Название = Цена (через ;) ");
            String[] productsInput = sc.nextLine().split(";");
            Map<String, Product> products = new LinkedHashMap<>();
            for (String pr : productsInput) {
                String[] parts = pr.trim().split("=");
                products.put(parts[0].trim(), new Product(parts[0].trim(), Integer.parseInt(parts[1].trim())));
            }

            System.out.println("Введите покупки: Имя - Продукт. Для завершения END");
            while (true) {
                String line = sc.nextLine();
                if ("END".equalsIgnoreCase(line.trim())) break;
                String[] parts = line.split("-");
                Person person = people.get(parts[0].trim());
                Product product = products.get(parts[1].trim());
                if (person != null && product != null) person.buy(product);
            }

            System.out.println("\nИтоговые покупки:");
            for (Person person : people.values()) {
                person.printBag();
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
