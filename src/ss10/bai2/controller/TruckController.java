package ss10.bai2.controller;

import ss10.bai2.service.CarService;
import ss10.bai2.service.MotoBikerService;
import ss10.bai2.service.TruckService;

import java.util.Scanner;

public class TruckController {
    Scanner scanner = new Scanner(System.in);
    TruckService truckService = new TruckService();
    public void truckController(){
        boolean flag = true;
        do {
            System.out.print("1. Thêm xe tải\n" +
                    "2. hiển thị tải\n" +
                    "3. xoá tải\n" +
                    "4. tìm kiếm\n" +
                    "5. thoát" +
                    "Nhập xe muốn thêm: ");
            String chose = scanner.nextLine();
            switch (chose){
                case "1":
                    truckService.addTruck();
                    break;
                case "2":
                    truckService.displayTruck();
                    break;
                case "3":
                    truckService.removeTruck();
                    break;
                case "4":
                    truckService.findTruck();
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
