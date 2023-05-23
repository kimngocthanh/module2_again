package ss13.service;

import ss13.model.Expense;
import ss13.repository.ExpenseRepository;

import java.util.List;
import java.util.Scanner;

public class ExpenseService implements IExpenseService {
    private Scanner scanner = new Scanner(System.in);
    private ExpenseRepository expenseRepository = new ExpenseRepository();


    @Override
    public void display() {
        List<Expense> expenseList = expenseRepository.display();
        for (Expense e : expenseList) {
            System.out.println(e);
        }
    }

    @Override
    public void add() {
        System.out.print("nhập id: ");
        String id = scanner.nextLine();
        System.out.print("nhập tên: ");
        String name = scanner.nextLine();
        System.out.print("nhập ngày chi tiêU: ");
        String date = scanner.nextLine();
        System.out.print("nhập giá: ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.print("nhập mô tả: ");
        String describe = scanner.nextLine();
        Expense expense = new Expense(id, name, date, price, describe);
        expenseRepository.add(expense);
        System.out.println("Thêm mới thành công!");
    }

    @Override
    public void remove() {
        boolean flag = false;
        List<Expense> expenseList = expenseRepository.display();
        System.out.print("nhập id muốn xoá: ");
        String id = scanner.nextLine();
        for (int i = 0; i < expenseList.size(); i++) {
            if (id.equals(expenseList.get(i).getId())) {
                System.out.print("bạn có chắc muốn xoá\n" +
                        "1. Có\n" +
                        "2. Không\n" +
                        "mời bạn chọn: ");
                String chose = scanner.nextLine();
                if (chose.equals("1")) {
                    expenseRepository.delete(i);
                    System.out.println("xoá oke!");
                } else {
                    flag = true;
                    break;
                }
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("ko có id muốn xoá");
        }
    }

    @Override
    public void edit() {
        List<Expense> expenseList = expenseRepository.display();
        System.out.print("Nhập id muốn sửa: ");
        String id = scanner.nextLine();
        boolean flag = true;
        boolean flag1 = false;
        for (int i = 0; i < expenseList.size(); i++) {
            if (id.equals(expenseList.get(i).getId())) {
                do {
                    System.out.print("1. Sửa tên\n" +
                            "2. Sửa ngày chi tiêu \n" +
                            "3. Sửa giá\n" +
                            "4. Sửa mô tả\n" +
                            "5. Thoát\n " +
                            "chọn thuộc tính cần sửa: ");
                    String chose = scanner.nextLine();
                    switch (chose) {
                        case "1":
                            System.out.print("nhập tên cần sửa: ");
                            String name = scanner.nextLine();
                            Expense expense = new Expense(id, name, expenseList.get(i).getDate(),
                                    expenseList.get(i).getPrice(), expenseList.get(i).getDescribe());
                            expenseRepository.edit(i, expense);
                            System.out.println("sửa thành công!");
                            break;
                        case "2":
                            System.out.print("nhập ngày cần sửa: ");
                            String date = scanner.nextLine();
                            expense = new Expense(id, expenseList.get(i).getName(), date, expenseList.get(i).getPrice(),
                                    expenseList.get(i).getDescribe());
                            expenseRepository.edit(i, expense);
                            System.out.println("sửa thành công!");
                            break;
                        case "3":
                            System.out.print("nhập giá cần sửa: ");
                            double price = Double.parseDouble(scanner.nextLine());
                            expense = new Expense(id, expenseList.get(i).getName(), expenseList.get(i).getDate(), price,
                                    expenseList.get(i).getDescribe());
                            expenseRepository.edit(i, expense);
                            System.out.println("sửa thành công!");
                            break;
                        case "4":
                            System.out.print("nhập mô tả cần sửa: ");
                            String describe = scanner.nextLine();
                            expense = new Expense(id, expenseList.get(i).getName(), expenseList.get(i).getDate(),
                                    expenseList.get(i).getPrice(), describe);
                            expenseRepository.edit(i, expense);
                            System.out.println("sửa thành công!");
                            break;
                        case "5":
                            flag = false;
                            break;
                        default:
                            System.out.println("nhập sai mời nhập lại! ");
                            break;
                    }
                } while (flag);
                flag1 = true;
            }
        }if(!flag1){
            System.out.println("ko có id muốn xoá!");
        }
    }

    @Override
    public void findId() {
        System.out.print("nhập id muốn tìm kiếm: ");
        String id = scanner.nextLine();
        Expense expense = expenseRepository.findId(id);
        if(expense==null){
            System.out.println("ko có chi tiêu cần tìm. ");
        }else {
            System.out.println(expense);
        }
    }

    @Override
    public void findName() {
        System.out.print("nhập name muốn tìm kiếm: ");
        String name = scanner.nextLine();
        if(expenseRepository.findName(name).size()==0){
            System.out.println("ko có chi tiêu cần tìm");
        }else {
            List<Expense> expenseList = expenseRepository.findName(name);
            for (Expense e: expenseList) {
                System.out.println(e);
            }
        }

    }
}
