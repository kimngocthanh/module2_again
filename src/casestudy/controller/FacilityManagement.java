package casestudy.controller;

import casestudy.service.FacilityService;

import java.util.Scanner;

public class FacilityManagement {
    Scanner scanner = new Scanner(System.in);
    private final FacilityService facilityService = new FacilityService();

    public void facilityManagement() {
        boolean flag = true;
        do{
            System.out.print("1. Hiển thị dịch vụ\n" +
                    "2. Thêm mới dịch vụ\n" +
                    "3. Xoá dịch vụ\n" +
                    "4. Hiển thị dịch vụ đã sử dụng 5 lần\n" +
                    "5. Thoát chức năng facility management\n" +
                    "Mời bạn chọn chức năng: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    //hiển thị
                    facilityService.displayFacility();
                    break;
                case "2":
                    boolean flagAdd = true;
                    do{
                        System.out.println("1. Thêm mới villa\n" +
                                "2. Thêm mới house\n" +
                                "3. Thêm mới room\n" +
                                "4. Thoát thêm mới: \n" +
                                "Mời bạn chọn chức năng: ");
                        String choseAdd = scanner.nextLine();
                        switch (choseAdd){
                            case "1":
                                //thêm villa
                                facilityService.addVilla();
                                break;
                            case "2":
                                //thêm house
                                facilityService.addHouse();
                                break;
                            case "3":
                                //thêm room
                                facilityService.addRoom();
                                break;
                            case "4":
                                flagAdd= false;
                                break;
                            default:
                                System.out.println("Chọn sai chức năng mời chọn lại cho đúng: ");
                                break;
                        }
                    }while (flagAdd);
                    break;
                case "3":
                    facilityService.removeFacility();
                    break;
                case "4":
                    //hiển thị danh sách sử dụng 5 lần
                    facilityService.displayFacilityMaintenance();
                    break;
                case "5":
                    flag = false;
                    break;
                default:
                    System.out.println("Chọn sai chức năng mời chọn lại chức năng cho đúng! ");
                    break;
            }
        }while (flag);

    }
}
