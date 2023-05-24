package casestudy.controller;

import java.util.Scanner;

public class CustomerManagement {
    Scanner scanner = new Scanner(System.in);
    public void CustomerManagement() {
        boolean flag = true;
        do {
            System.out.print("----------CustomerManagement----------\n" +
                    "1. Display list customer\n" +
                    "2. Add new customer\n" +
                    "3. Edit customer\n" +
                    "4. Return Menu\n" +
                    "Mời bạn chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    // display
                    break;
                case "2":
                    //add
                    break;
                case "3":
                    //edit
                    break;
                case "4":
                    flag = false;
                    break;
                default:
                    System.out.println("nhập sai chức năng mời bạn nhập lại !");
            }
        } while (flag);
    }
}
