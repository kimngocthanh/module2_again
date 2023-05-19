package ss10.bai2.repository;

import ss10.bai2.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements ICarRepository {
    public static List<Car> carList = new ArrayList<>();

    static {
        Car car = new Car("29A-1234", "honda", "2018", "Kim Ngọc Thành", 7, "du lịch");
        Car car1 = new Car("29A-4321", "bmw", "2019", "Nguyễn Thành Thân", 7, "du lịch");
        Car car2 = new Car("29A-2356", "kia", "2017", "Duy Huỳnh", 7, "du lịch");
        Car car3 = new Car("29A-2131", "mazda", "2016", "Lê Viết Tuấn ", 7, "du lịch");
        carList.add(car);
        carList.add(car1);
        carList.add(car2);
        carList.add(car3);
    }

    @Override
    public List<Car> displayCar() {
        return carList;
    }

    @Override
    public void addCar(Car car) {
        carList.add(car);
    }

    @Override
    public void removeCar(int index) {
        carList.remove(index);
    }

    @Override
    public boolean findCar(String seaOfControl) {
        for (int i = 0; i < carList.size(); i++) {
            if (seaOfControl.equals(carList.get(i).getSeaOfControl())) {
                System.out.println(carList.get(i));
                return true;
            }
        }
        return false;
    }


}
