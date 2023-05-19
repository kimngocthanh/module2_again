package ss10.bai2.service;

import ss10.bai2.model.Manufacturer;
import ss10.bai2.model.MotoBiker;
import ss10.bai2.model.Truck;
import ss10.bai2.repository.ManufacturerRepository;
import ss10.bai2.repository.TruckRepository;

import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruckService {
    TruckRepository truckRepository = new TruckRepository();
    List<Truck> truckList = truckRepository.displayTruck();
    Scanner scanner = new Scanner(System.in);
    ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    List<Manufacturer> manufacturerRepositoryList = manufacturerRepository.display();

    @Override
    public void addTruck() {
        truckList = truckRepository.displayTruck();
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
            }
            if (!check) {
                System.out.println("ko có id mời nhập lại!");
            }
        } while (flag);
        System.out.print("nhập năm sản xuất: ");
        String yearOfManufacture = scanner.nextLine();
        System.out.print("nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("nhập trọng tải: ");
        String tonnage = scanner.nextLine();
        Truck truck = new Truck(seaOfControl, nameFacturer, yearOfManufacture, owner, tonnage);
        truckRepository.addTruck(truck);
        System.out.println("add oke");
    }

    @Override
    public void displayTruck() {
        truckList = truckRepository.displayTruck();
        for (Truck t:truckList) {
            System.out.println(t);
        }
    }

    @Override
    public void removeTruck() {
        truckList = truckRepository.displayTruck();
        boolean flag = true;
        System.out.print("nhập biển kiểm soát muốn xoá: ");
        String seaOfControl = scanner.nextLine();
        for (int i = 0; i< truckList.size(); i++) {
            flag = true;
            if (seaOfControl.equals(truckList.get(i).getSeaOfControl())) {
                flag = true;
                System.out.print("bạn có chắc muốn xoá!\n" +
                        "1. Có\n" +
                        "2. Không\n" +
                        "chọn: ");
                String chose = scanner.nextLine();
                switch (chose) {
                    case "1":
                        truckRepository.removeTruck(i);
                        System.out.println("xoá thành công!");
                    case "2":
                        break;
                }
            }
        }
        if (!flag) {
            System.out.print("ko có biển muốn xoá");
        }

    }

    @Override
    public void findTruck() {
        truckList = truckRepository.displayTruck();
        System.out.print("nhập biển kiểm soát: ");
        String seaOfControl = scanner.nextLine();
        for (int i = 0; i < truckList.size(); i++) {
            if(seaOfControl.equals(truckList.get(i).getSeaOfControl())){
                truckRepository.findTruck(seaOfControl);
            }
        }
    }
}
