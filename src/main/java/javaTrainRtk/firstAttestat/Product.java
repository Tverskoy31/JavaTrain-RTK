package javaTrainRtk.firstAttestat;

import java.util.*;

/**
 * Базовый продукт
 */
class Product {
    private final String name;
    private final int price; // базовая цена

    public Product(String name, int price) {
        validateName(name);
        validatePricePositive(price, "Стоимость продукта не может быть 0 или отрицательной");
        this.name = name;
        this.price = price;
    }

    protected static void validateName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым");
        }
        String trimmed = name.trim();
        if (trimmed.length() < 3) {
            throw new IllegalArgumentException("Название продукта не может быть короче 3 символов");
        }
        if (trimmed.matches("^\\d+$")) {
            throw new IllegalArgumentException("Название продукта не должно содержать только цифры");
        }
    }

    protected static void validatePricePositive(int price, String message) {
        if (price <= 0) {
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }

    /** Базовая цена без скидок */
    public int getBasePrice() {
        return price;
    }

    /** Текущая цена (для Product равна базовой) */
    public int getCurrentPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " = " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
