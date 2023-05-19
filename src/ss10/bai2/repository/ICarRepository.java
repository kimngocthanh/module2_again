package ss10.bai2.repository;

import ss10.bai2.model.Car;

import java.util.List;

public interface ICarRepository {
    List<Car> displayCar();

    void addCar(Car car);

    void removeCar(int index);

    boolean findCar(String seaOfControl);
}
