package javaTrainRtk.firstAttestat;

import java.time.LocalDate;
import java.util.*;

/**
 * Домашнее задание по теме
 * «Понятия ООП: наследование, полиморфизм»
 * Формулировка задания:
 * Расширить программу из задания с промежуточной аттестации.
 * Добавить механизм наследования.
 * В программе должно быть два класса – один для обычных продуктов –
 * Product, а другой для специальных – DiscountProduct.
 * • Product - представляет обычный продукт из прошлого домашнего
 * задания. Характеристики Продукта: название и стоимость. Название продукта
 * не может быть пустой строкой, оно должно быть. Стоимость продукта не может
 * быть отрицательным числом.
 * • Скидочный продукт — специальный продукт, цена которого снижена на
 * размер скидки. У скидки есть также срок действия. После завершения срока
 * действия скидка меняется.
 * Ограничения в классах для продуктов:
 * - Название продукта не должно содержать только цифры;
 * - Если название продукта короче, чем 3 символа, то такое название
 * недействительно;
 * - Если стоимость продукта или скидочного продукта 0 или
 * отрицательная, то такая цена неправильная. Должна быть ошибка валидации.
 * Программа реализуется в отдельной ветке git homeworks/homework07.
 * При сохранении состояния программы (коммиты) пишется сообщение с
 * описанием хода работы по задаче.
 * В корне папки с программой должен быть файл .gitignore.
 * Программа локально коммитится и публикуется в репозиторий GitHub на
 * проверку.
 */

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // Ввод покупателей
            System.out.println("Введите покупателей в формате 'Имя = деньги', через ';'");
            String[] personInput = sc.nextLine().split(";");
            List<Person> people = new ArrayList<>();
            for (String p : personInput) {
                if (p.isBlank()) continue;
                String[] parts = p.trim().split("=");
                String name = parts[0].trim();
                int money = Integer.parseInt(parts[1].trim());
                people.add(new Person(name, money));
            }

            // Ввод продуктов
            System.out.println("Введите продукты (обычные 'Название = 1000' или скидочные 'Название = 1000, срок = 10, до = 2025-12-31'");
            String[] productInput = sc.nextLine().split(";");
            Map<String, Product> products = new HashMap<>();
            for (String raw : productInput) {
                if (raw.isBlank()) continue;
                Product prod = parseProduct(raw.trim());
                products.put(prod.getName(), prod);
            }

            // Процесс покупок
            System.out.println("Введите покупки в формате 'Имя - Продукт'. Введите END для завершения");
            while (true) {
                String line = sc.nextLine().trim();
                if (line.equalsIgnoreCase("END")) break;
                String[] parts = line.split("-");
                String personName = parts[0].trim();
                String productName = parts[1].trim();

                Person person = people.stream()
                        .filter(p -> p.getName().equals(personName))
                        .findFirst().orElse(null);
                Product product = products.get(productName);

                if (person != null && product != null) {
                    person.buyProduct(product);
                }
            }

            // Итоговые результаты
            System.out.println();
            for (Person p : people) {
                System.out.println(p.bagToString());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static Product parseProduct(String raw) {
        // "Название = 1000"  или  "Название = 1000, срок = 10, до = 2025-12-31"
        String[] leftRight = raw.split("=");
        String name = leftRight[0].trim();
        String right = raw.substring(raw.indexOf('=') + 1).trim();

        String[] tokens = right.split(",");
        int price = Integer.parseInt(tokens[0].trim());

        Integer discount = null;
        LocalDate until = null;

        for (int i = 1; i < tokens.length; i++) {
            String[] kv = tokens[i].split("=");
            if (kv.length != 2) continue;
            String key = kv[0].trim().toLowerCase();
            String val = kv[1].trim();

            if (key.equals("скидка")) {
                discount = Integer.parseInt(val.replace("%", ""));
            } else if (key.equals("до")) {
                until = LocalDate.parse(val);
            }
        }

        if (discount != null && until != null) {
            return new DiscountProduct(name, price, discount, until);
        }
        return new Product(name, price);
    }
}
