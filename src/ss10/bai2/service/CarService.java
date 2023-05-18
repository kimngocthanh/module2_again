package ss10.bai2.service;

import ss10.bai2.model.Car;
import ss10.bai2.model.Manufacturer;
import ss10.bai2.repository.CarRepository;
import ss10.bai2.repository.ManufacturerRepository;

import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    CarRepository carRepository = new CarRepository();
    Scanner scanner = new Scanner(System.in);
    List<Car> carList = carRepository.displayCar();
    ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    List<Manufacturer> manufacturerRepositoryList = manufacturerRepository.display();

    @Override
    public void displayCar() {
        carList = carRepository.displayCar();
        for (Car c : carList) {
            System.out.println(c);
        }
    }

    @Override
    public void addCar() {
        carList = carRepository.displayCar();
        System.out.print("nhập biển kiểm soát: ");
        String seaOfControl = scanner.nextLine();
        manufacturerRepositoryList = manufacturerRepository.display();
        for (Manufacturer m : manufacturerRepositoryList) {
            System.out.println(m);
        }
        boolean flag = true;
        String nameFacturer = null;
        do {
            System.out.print("chọn hãng sản xuất theo id: ");
            String id = scanner.nextLine();
            boolean check = false;
            for (int i = 0; i < manufacturerRepositoryList.size(); i++) {
                if (id.equals(manufacturerRepositoryList.get(i).getIdFacturer())) {
                    nameFacturer = manufacturerRepositoryList.get(i).getNameFacrure();
                    flag = false;
                    check = true;
                }
            }if(!check){
                System.out.println("ko có id mời nhập lại!");
            }
        } while (flag);
        System.out.print("nhập năm sản xuất: ");
        String yearOfManufacture = scanner.nextLine();
        System.out.print("nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("nhập kiểu xe: ");
        String typeCar = scanner.nextLine();
        System.out.print("nhập số chỗ ngồi");
        int numberOfSeats = Integer.parseInt(scanner.nextLine());
        Car car = new Car(seaOfControl, nameFacturer, yearOfManufacture, owner, numberOfSeats, typeCar);
        carRepository.addCar(car);
        System.out.println("add oke");
    }

    @Override
    public void removeCar() {
        carList = carRepository.displayCar();

        System.out.print("nhập biển kiểm soát muốn xoá: ");
        String seaOfControl = scanner.nextLine();
        for (Car c : carList) {
            if (seaOfControl.equals(c.getSeaOfControl())) {
                System.out.print("bạn có chắc muốn xoá!\n" +
                        "1. Có\n" +
                        "2. Không\n" +
                        "chọn: ");
                String chose = scanner.nextLine();
                switch (chose) {
                    case "1":
                        carRepository.removeCar(c);
                        System.out.println("xoá thành công!");
                    case "2":
                        break;
                }
            }
        }

    }

    @Override
    public void findCar() {
        carList = carRepository.displayCar();
        System.out.print("nhập biển kiểm soát: ");
        String seaOfControl = scanner.nextLine();
        for (int i = 0; i < carList.size(); i++) {
            if(seaOfControl.equals(carList.get(i).getSeaOfControl())){
                carRepository.findCar(seaOfControl);
            }
        }
    }
}
