package casestudy.controller;

import java.util.Scanner;

public class EmployeeManagement {
    public void employeeManagement(){
        Scanner scanner = new Scanner(System.in);
        boolean flag =true;
        do {
            System.out.print("----------EmployeeManagement----------\n" +
                    "1. Display list empolyee\n" +
                    "2. Add new employee\n" +
                    "3. Edit empployee\n" +
                    "4. Return Menu\n" +
                    "Mời bạn chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose){
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
                    flag=false;
                    break;
                default:
                    System.out.println("nhập sai chức năng mời bạn nhập lại !");
            }
        }while (flag);

    }
}
