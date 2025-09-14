package javaTrainRtk.attestation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {
    private String name;
    private int money;
    private final List<Product> bag = new ArrayList<>();

    public Person(String name, int money) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым");
        if (name.trim().length() < 3)
            throw new IllegalArgumentException("Имя не может быть короче 3 символов");
        if (money < 0)
            throw new IllegalArgumentException("Деньги не могут быть отрицательными");
        this.name = name.trim();
        this.money = money;
    }

    public boolean buy(Product product) {
        if (money >= product.getPrice()) {
            bag.add(product);
            money -= product.getPrice();
            System.out.println(name + " купил " + product.getName());
            return true;
        } else {
            System.out.println(name + " не может позволить себе " + product.getName());
            return false;
        }
    }

    public void printBag() {
        if (bag.isEmpty()) {
            System.out.println(name + " - Ничего не куплено");
        } else {
            System.out.print(name + " - ");
            for (int i = 0; i < bag.size(); i++) {
                System.out.print(bag.get(i).getName());
                if (i < bag.size() - 1) System.out.print(", ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() { return name + " (" + money + ")"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person p = (Person) o;
        return money == p.money && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name, money); }
}
