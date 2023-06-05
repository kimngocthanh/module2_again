package casestudy.controller;

import casestudy.service.CustomerService;

import java.util.Scanner;

public class CustomerManagement {
    Scanner scanner = new Scanner(System.in);
    private final CustomerService customerService = new CustomerService();

    public void customerManagement() {
        boolean flag = true;
        do {
            System.out.print("----------CustomerManagement----------\n" +
                    "1. Display list customer\n" +
                    "2. Add new customer\n" +
                    "3. Edit customer\n" +
                    "4. Remove customer\n" +
                    "5. Search customer\n" +
                    "6. Return Menu\n" +
                    "Mời bạn chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    // display
                    customerService.displayCustomer();
                    break;
                case "2":
                    //add
                    customerService.addCustomer();
                    break;
                case "3":
                    //edit
                    customerService.editCustomer();
                    break;
                case "4":
                    customerService.removeCustomer();
                    break;
                case "5":
                    customerService.searchCustomer();
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("nhập sai chức năng mời bạn nhập lại !");
            }
        } while (flag);
    }
}
