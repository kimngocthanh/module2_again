package ss10.bai2.controller;

import ss10.bai2.service.CarService;
import ss10.bai2.service.TruckService;

import java.util.Scanner;

public class MenuController {
    Scanner scanner = new Scanner(System.in);
    CarController carController = new CarController();
    MotoBikerControler motoBikerControler = new MotoBikerControler();
    TruckController truckController = new TruckController();
    public void menuController(){
        boolean flag = true;
        do {
            System.out.print("1. Oto\n" +
                    "2. xe máy\n" +
                    "3. xe tải\n" +
                    "4. thoát\n" +
                    "chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose){
                case "1":
                    carController.carController();
                    break;
                case "2":
                    motoBikerControler.motoBikerController();
                    break;
                case "3":
                    truckController.truckController();
                    break;
                case "4":
                    flag=false;
                    break;
                default:
                    System.out.println("nhập sai chức năng mời nhập lại");
                    break;
            }
        }while (flag);
    }
}
