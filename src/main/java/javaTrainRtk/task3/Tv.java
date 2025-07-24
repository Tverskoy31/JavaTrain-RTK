package javaTrainRtk.task3;

import java.security.SecureRandom;
import java.util.Random;


public class Tv {
    private String brand;
    private String model;
    private Double screenDiagonal;
    private boolean smartTvSupport;
    Random random = new Random();

    public static String getRandomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));

        return sb.toString();
    }

    public Tv(String brand, String model, Double screenDiagonal, boolean smartTvSupport) {
        this.brand = brand;
        this.model = model;
        this.screenDiagonal = screenDiagonal;
        this.smartTvSupport = smartTvSupport;
    }

    public Tv() {
        setBrand();
        setModel();
        setScreenDiagonal();
        setSmartTvSupport();
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setScreenDiagonal(Double screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }

    public void setSmartTvSupport(boolean smartTvSupport) {
        this.smartTvSupport = smartTvSupport;
    }

    public void setBrand() {
        this.brand = getRandomString(8);
    }

    public void setModel() {
        this.model = getRandomString(10);
    }

    public void setScreenDiagonal() {
        double a = random.nextDouble(100);
        this.screenDiagonal = (double) Math.round(a * 100) / 100;
    }

    public void setSmartTvSupport() {
        this.smartTvSupport = random.nextBoolean();
    }

    public void showInfo() {
        System.out.println("Ваш телевизор: " + brand + " " + model +
            " | Диагональ: " + screenDiagonal + " дюймов" +
            " | Smart TV: " + (smartTvSupport ? "да" : "нет"));
    }
    @Override
    public String toString() {
        return "Tv{" +
            "brand='" + brand + '\'' +
            ", model='" + model + '\'' +
            ", screenDiagonal=" + screenDiagonal +
            ", smartTvSupport=" + smartTvSupport +
            '}';
    }
}
