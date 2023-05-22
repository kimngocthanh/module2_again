package ss12.controller;

import ss12.service.FruitService;

import java.util.Scanner;

public class MenuController {
    Scanner scanner = new Scanner(System.in);
    FruitService fruitService = new FruitService();
    public void displayMenu() {
        boolean flag = true;
        do {
            System.out.print("----------Quản lý trái cây----------\n" +
                    "1. Hiển thị danh sách theo keyset.\n" +
                    "2. Hiển thị danh sách theo entrySet\n" +
                    "3. Thêm mới trái cây\n" +
                    "4. Xoá trái cây\n" +
                    "5. Sửa thông tin\n" +
                    "0. Thoát.\n" +
                    "Chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    //hiển thị
                    fruitService.displayKeySet();
                    break;
                case "2":
                    //hiển thị
                    fruitService.displayEntrySet();
                    break;
                case "3":
                    // thêm
                    fruitService.addFruit();
                    break;
                case "4":
                    // xoá
                    fruitService.removeFruit();
                    break;
                case "5":
                    //sửa
                    fruitService.editFruit();
                    break;
                case "0":
                    flag=false;
                    break;
                default:
                    System.out.println("nhập sai chức năng mời nhập lại!");
                    break;
            }
        }while (flag);
    }
}
