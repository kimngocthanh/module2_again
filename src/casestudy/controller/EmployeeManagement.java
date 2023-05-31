package casestudy.controller;

import casestudy.service.EmployeeService;

import java.util.Scanner;

public class EmployeeManagement {
    private EmployeeService employeeService = new EmployeeService();

    public void employeeManagement(){
        Scanner scanner = new Scanner(System.in);
        boolean flag =true;
        do {
            System.out.print("----------EmployeeManagement----------\n" +
                    "1. Display list empolyee\n" +
                    "2. Add new employee\n" +
                    "3. Edit employee\n" +
                    "4. Return Menu\n" +
                    "Mời bạn chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose){
                case "1":
                    // display
                    employeeService.displayEmployee();
                    break;
                case "2":
                    //add
                    employeeService.addEmployee();
                    break;
                case "3":
                    //edit
                    employeeService.setEmployee();
                    break;
                case "4":
                    flag=false;
                    break;
                default:
                    System.out.println("nhập sai chức năng mời bạn nhập lại !");
            }
        }while (flag);

    }
}
