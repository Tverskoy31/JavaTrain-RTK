package javaTrainRtk.streamAPI;

import javaTrainRtk.streamAPI.repository.CarsRepository;
import javaTrainRtk.streamAPI.repository.CarsRepositoryImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = Arrays.asList(
                new Car("a123me","Mercedes","White",0,8300000),
                new Car("b873of","Volga","Black",0,673000),
                new Car("w487mn","Lexus","Grey",76000,900000),
                new Car("p987hj","Volga","Red",610,704340),
                new Car("c987ss","Toyota","White",254000,761000),
                new Car("o983op","Toyota","Black",698000,740000),
                new Car("p146op","BMW","White",271000,850000),
                new Car("u893ii","Toyota","Purple",210900,440000),
                new Car("l097df","Toyota","Black",108000,780000),
                new Car("y876wd","Toyota","Black",160000,1000000)
        );

        CarsRepository repo = new CarsRepositoryImpl(cars);
        repo.saveToFile("cars.txt", cars);

        System.out.println("Автомобили в базе:");
        System.out.printf("%8s %10s %8s %8s %12s\n","Number","Model","Color","Mileage","Cost");
        repo.getAllCars().forEach(System.out::println);

        String colorToFind = "Black";
        long mileageToFind = 0;
        System.out.println("\nНомера автомобилей по цвету или пробегу:");
        cars.stream()
                .filter(c -> c.getColor().equalsIgnoreCase(colorToFind) || c.getMileage() == mileageToFind)
                .map(Car::getNumber)
                .forEach(n -> System.out.print(n + " "));

        long n = 700_000, m = 800_000;
        long unique = cars.stream()
                .filter(c -> c.getCost() >= n && c.getCost() <= m)
                .map(Car::getModel)
                .distinct()
                .count();
        System.out.println("\n\nУникальные автомобили: " + unique + " шт.");

        cars.stream().min(Comparator.comparingLong(Car::getCost))
                .ifPresent(c -> System.out.println("Цвет автомобиля с минимальной стоимостью: " + c.getColor()));

        String modelToFind = "Toyota";
        double avgToyota = cars.stream()
                .filter(c -> c.getModel().equalsIgnoreCase(modelToFind))
                .mapToLong(Car::getCost)
                .average().orElse(0);
        System.out.printf("Средняя стоимость модели %s: %.2f\n", modelToFind, avgToyota);

        String model2 = "Volvo";
        double avgVolvo = cars.stream()
                .filter(c -> c.getModel().equalsIgnoreCase(model2))
                .mapToLong(Car::getCost)
                .average().orElse(0);
        System.out.printf("Средняя стоимость модели %s: %.2f\n", model2, avgVolvo);
    }
}