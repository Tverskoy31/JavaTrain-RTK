package javaTrainRtk.streamAPI.repository;

import javaTrainRtk.streamAPI.Car;

import java.util.List;

public interface CarsRepository {
    List<Car> getAllCars();
    void saveToFile(String fileName, List<Car> cars);
    List<Car> loadFromFile(String fileName);
}