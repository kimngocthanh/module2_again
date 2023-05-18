package ss10.bai2.controller;

import ss10.bai2.model.Truck;
import ss10.bai2.service.CarService;
import ss10.bai2.service.MotoBikerService;
import ss10.bai2.service.TruckService;

import java.util.Scanner;

public class MotoBikerControler {
    Scanner scanner = new Scanner(System.in);
    MotoBikerService motoBikerService = new MotoBikerService();
    public void motoBikerController(){
        boolean flag = true;
        do {
            System.out.print("1. Thêm xe motobiker\n" +
                    "2. hiển thị motobiker\n" +
                    "3. xoá motobiker\n" +
                    "4. tìm kiếm motobiker\n" +
                    "5. thoát" +
                    "Nhập xe muốn thêm: ");
            String chose = scanner.nextLine();
            switch (chose){
                case "1":
                    motoBikerService.addMotoBiker();
                    break;
                case "2":
                    motoBikerService.displayMotoBiker();
                    break;
                case "3":
                    motoBikerService.removeMotoBiker();
                    break;
                case "4":
                    motoBikerService.findMotoBiker();
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
