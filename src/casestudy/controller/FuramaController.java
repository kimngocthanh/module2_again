package casestudy.controller;

import casestudy.service.EmployeeService;

import java.util.Scanner;

public class FuramaController {
    private CustomerManagement customerManagement = new CustomerManagement();

    private EmployeeManagement employeeManagement = new EmployeeManagement();
    public void menuFuramaResort(){
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.print("----------FuramaResort----------\n" +
                    "1. Employee Management\n" +
                    "2. Customer Management\n" +
                    "3. Facility Management\n" +
                    "4. Booking Management\n" +
                    "5. Promotion Management\n" +
                    "6. exit\n" +
                    "Mời bạn chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose){
                case "1":
                    //employee management
                    employeeManagement.employeeManagement();
                    break;
                case "2":
                    // Customer
                    customerManagement.customerManagement();
                    break;
                case "3":
                    //Facility
                    break;
                case "4":
                    //booking
                    break;
                case "5":
                    //promotion
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("nhập sai chức năng mời bạn nhập lại!");
                    break;
            }
        }while (flag);

    }
}
