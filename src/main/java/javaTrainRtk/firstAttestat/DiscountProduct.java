package javaTrainRtk.firstAttestat;

import java.time.LocalDate;

public class DiscountProduct extends Product {
        private final int discountPercent;
        private final LocalDate until;

        public DiscountProduct(String name, int basePrice, int discountPercent, LocalDate until) {
            super(name, basePrice);
            if (discountPercent <= 0 || discountPercent >= 100) {
                throw new IllegalArgumentException("Скидка должна быть от 1 до 99%");
            }
            if (until == null) {
                throw new IllegalArgumentException("Срок действия скидки должен быть указан");
            }
            this.discountPercent = discountPercent;
            this.until = until;

            int discounted = calcDiscounted(super.getBasePrice(), discountPercent);
            validatePricePositive(discounted, "Стоимость скидочного продукта не может быть 0 или отрицательной");
        }

        private static int calcDiscounted(int base, int percent) {
            return (int) Math.floor(base * (100 - percent) / 100.0);
        }

        /** Проверка: активна ли скидка сегодня */
        private boolean isDiscountActiveToday() {
            LocalDate today = LocalDate.now();
            return !today.isAfter(until); // скидка действует только до даты "until" включительно
        }

        @Override
        public int getCurrentPrice() {
            // Если срок скидки ещё не истёк → возвращаем цену со скидкой
            // Если срок истёк → возвращаем базовую цену (скидка отменена)
            if (isDiscountActiveToday()) {
                return calcDiscounted(getBasePrice(), discountPercent);
            }
            return getBasePrice();
        }

        @Override
        public String toString() {
            if (isDiscountActiveToday()) {
                return getName() + " = " + getCurrentPrice()
                        + " (скидка " + discountPercent + "% до " + until + ")";
            } else {
                return getName() + " = " + getBasePrice()
                        + " (скидка истекла)";
            }
        }
    }
