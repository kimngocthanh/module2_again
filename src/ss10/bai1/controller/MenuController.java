package ss10.bai1.controller;

import ss10.bai1.service.FruitService;

import java.util.Scanner;

public class MenuController {
    Scanner scanner =new Scanner(System.in);
    FruitService fruitService = new FruitService();
    public void menuController() {
        boolean flag = true;
        do{
            System.out.print("1. hiển thị\n" +
                    "2. thêm\n" +
                    "3. thoát\n" +
                    "nhập chức năng: ");
            String chose = scanner.nextLine();
            switch (chose){
                case "1":
                    //hiển thị
                    fruitService.display();
                    break;
                case "2":
                    //thêm
                    fruitService.add();
                    break;
                case "3":
                    flag=false;
                    break;
                default:
                    System.out.println("nhập ko đúng mời nhập lại");
                    break;
            }
        }while (flag);
    }
}
