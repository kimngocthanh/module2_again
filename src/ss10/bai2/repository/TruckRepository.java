package ss10.bai2.repository;

import ss10.bai2.model.Car;
import ss10.bai2.model.MotoBiker;
import ss10.bai2.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements ITruckRepository{
    public static List<Truck> truckList = new ArrayList<>();
    static {
        Truck truck = new Truck("27A-1234", "honda", "2018", "Kim Thành", "10");
        Truck truck1 = new Truck("27A-7892", "honda", "2019", "Ngọc Thành", "10");
        Truck truck2 = new Truck("27A-1523", "honda", "2017", "Kim Ngọc", "10");
        Truck truck3 = new Truck("27A-6734", "honda", "2017", "Kim Thân", "10");
        Truck truck4 = new Truck("27A-1235", "honda", "2016", "Kim Thu", "10");


        truckList.add(truck);
        truckList.add(truck1);
        truckList.add(truck2);
        truckList.add(truck3);
        truckList.add(truck4);

    }
    @Override
    public List<Truck> displayTruck() {
        return truckList;
    }

    @Override
    public void addTruck(Truck truck) {
        truckList.add(truck);
    }

    @Override
    public void removeTruck(Truck truck) {
        truckList.remove(truck);
    }

    @Override
    public boolean findTruck(String seaOfControl) {
        for (int i = 0; i < truckList.size(); i++) {
            if(seaOfControl.equals(truckList.get(i).getSeaOfControl())){
                System.out.println(truckList.get(i));
                return true;
            }
        }return false;
    }
}
