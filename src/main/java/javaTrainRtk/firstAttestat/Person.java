package javaTrainRtk.firstAttestat;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;

class Person {
    private final String name;
    private int money;
    private final List<Product> bag;

    public Person(String name, int money) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        String trimmed = name.trim();
        if (trimmed.length() < 3) {
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        }
        if (money < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        }
        this.name = trimmed;
        this.money = money;
        this.bag = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void buyProduct(Product product) {
        int priceNow = product.getCurrentPrice();
        if (money >= priceNow) {
            bag.add(product);
            money -= priceNow;
            System.out.println(name + " купил " + product.getName());
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
        }
    }

    public String bagToString() {
        if (bag.isEmpty()) {
            return name + " - Ничего не куплено";
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (Product p : bag) {
            joiner.add(p.getName());
        }
        return name + " - " + joiner;
    }
}