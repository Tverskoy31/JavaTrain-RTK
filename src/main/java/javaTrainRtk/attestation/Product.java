package javaTrainRtk.attestation;

import java.util.Objects;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Имя продукта не может быть пустым");
        if (price < 0)
            throw new IllegalArgumentException("Стоимость продукта не может быть отрицательной");
        this.name = name.trim();
        this.price = price;
    }

    public String getName() { return name; }
    public int getPrice() { return price; }

    @Override
    public String toString() { return name + " (" + price + ")"; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product p = (Product) o;
        return price == p.price && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() { return Objects.hash(name, price); }
}
