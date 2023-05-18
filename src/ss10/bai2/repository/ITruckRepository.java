package ss10.bai2.repository;

import ss10.bai2.model.Car;
import ss10.bai2.model.Truck;

import java.util.List;

public interface ITruckRepository {
    List<Truck> displayTruck();

    void addTruck(Truck truck);

    void removeTruck( Truck truck);

    boolean findTruck(String seaOfControl);
}
