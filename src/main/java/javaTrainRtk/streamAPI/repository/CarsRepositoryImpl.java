package javaTrainRtk.streamAPI.repository;

import javaTrainRtk.streamAPI.Car;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CarsRepositoryImpl implements CarsRepository {
    private final List<Car> cars;

    public CarsRepositoryImpl(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    @Override
    public List<Car> getAllCars() {
        return new ArrayList<>(cars);
    }

    @Override
    public void saveToFile(String fileName, List<Car> cars) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName))) {
            pw.printf("%8s %10s %8s %8s %12s\n","Number","Model","Color","Mileage","Cost");
            cars.forEach(pw::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> loadFromFile(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            return br.lines()
                    .skip(1)
                    .map(line -> line.trim().split("\\s+"))
                    .filter(arr -> arr.length == 5)
                    .map(arr -> new Car(arr[0], arr[1], arr[2],
                            Long.parseLong(arr[3]), Long.parseLong(arr[4])))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
