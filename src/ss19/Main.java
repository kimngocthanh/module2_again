package ss19;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập email muốn kiểm tra định dạng: ");
        String email = scanner.nextLine();
        System.out.println(ValidateRegex.checkRegexEmailCustomer(email));
    }
}
