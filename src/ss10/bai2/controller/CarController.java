package ss10.bai2.controller;

import ss10.bai2.service.CarService;
import ss10.bai2.service.MotoBikerService;
import ss10.bai2.service.TruckService;

import java.util.Scanner;

public class CarController {
    Scanner scanner = new Scanner(System.in);
    CarService carService = new CarService();
    MotoBikerService motoBikerService = new MotoBikerService();
    TruckService truckService = new TruckService();
    public void carController(){
        boolean flag = true;
        do {
            System.out.print("1. Thêm xe Ô tô\n" +
                    "2. hiển thị o to\n" +
                    "3. xoá o to\n" +
                    "4. tìm kiếm\n" +
                    "5. thoát" +
                    "Nhập xe muốn thêm: ");
            String chose = scanner.nextLine();
            switch (chose){
                case "1":
                    carService.addCar();
                    break;
                case "2":
                    carService.displayCar();
                    break;
                case "3":
                    carService.removeCar();
                    break;
                case "4":
                    carService.findCar();
                    break;
                case "5":
                    flag=false;
                    break;
                default:
                    System.out.println("nhập sai mời nhập lại! ");
                    break;
            }
        }while (flag);
    }
}
