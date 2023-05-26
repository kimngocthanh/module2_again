package ss16.controller;

import ss16.service.ExpenseService;

import java.util.Scanner;


public class MenuController {
    private ExpenseService expenseService = new ExpenseService();
    public void menuController() {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("----------Quản Lý Công Việc----------\n" +
                    "1. Hiển Thị \n" +
                    "2. Thêm \n" +
                    "3. Xoá\n" +
                    "4. Sửa\n" +
                    "5. Tìm Kiếm Theo Mã\n" +
                    "6. Tìm Kiếm gần đúng theo tên: \n" +
                    "7. Sắp xếp theo tên\n" +
                    "8. Sắp xếp theo giá\n" +
                    "0. Thoát\n" +
                    "Mời bạn chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    //hiển thị
                    expenseService.display();
                    break;
                case "2":
                    //thên
                    expenseService.add();
                    break;
                case "3":
                    //xoá
                    expenseService.remove();
                    break;
                case "4":
                    //sửa
                    expenseService.edit();
                    break;
                case "5":
                    //tìm kiếm theo mã
                    expenseService.findId();
                    break;
                case "6":
                    //tìm kiếm gần đúng theo tên
                    expenseService.findName();
                    break;
                case "7":
                    //sắp xếp theo tên
                    expenseService.sortName();
                    break;
                case "8":
                    //sắp xếp theo giá
                    expenseService.sortPrice();
                    break;
                case "0":
                    flag = false;
                    break;
                default:
                    System.out.println("nhập sai chức năng mời nhập lại!");
                    break;
            }
        } while (flag);

    }
}


