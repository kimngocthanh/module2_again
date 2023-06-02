package casestudy.controller;

import casestudy.service.BookingService;

import java.util.Scanner;

public class BookingManagement {
    Scanner scanner = new Scanner(System.in);
    private final BookingService bookingService = new BookingService();
    public void bookingManagement() {
        boolean flag = true;
        do {
            System.out.print("1. Add new booking\n" +
                    "2. Display list booking\n" +
                    "3. Create new contracts\n" +
                    "4. Display list contracts\n" +
                    "5. Edit contracts\n" +
                    "6. Return main menu\n" +
                    "Mời bạn chọn chức năng sử dụng: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    // add booking
                    bookingService.addBooking();
                    break;
                case "2":
                    // hiển thị lish booking
                    bookingService.displayBooking();
                    break;
                case "3":
                    //tạo mới hợp đồng
                    break;
                case "4":
                    //hiển hị hợp đồng
                case "5":
                    // sửa hợp đồng
                    break;
                case "6":
                    flag = false;
                    break;
                default:
                    System.out.println("Chọn sai chức năng mời nhập lại!");
                    break;
            }
        } while (flag);
    }
}
