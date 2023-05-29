package ss15.service;

import ss15.model.Expense;
import ss15.repository.ExpenseRepository;

import java.util.Collections;
import java.util.Comparator;
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
        String id;
        boolean flag = false;
        List<Expense> expenseList = expenseRepository.display();
        do {
            System.out.print("nhập id: ");
            id = scanner.nextLine();
            try {
                for (Expense e : expenseList) {
                    if (id.equals(e.getId())) {
                        throw new UniqueException("trùng id");
                    }
                }
                flag = true;
            } catch (UniqueException uniqueException) {
                System.out.println(uniqueException.getMessage());
                System.out.println("Mời nhập lại");
            }
        } while (!flag);
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
        List<Expense> expenseList = expenseRepository.display();
        String id = null;
        boolean check = false;
        do {
            System.out.print("nhập id muốn xoá: ");
            id = scanner.nextLine();
            boolean flag1 = false;
            try {
                for (int i = 0; i<expenseList.size(); i++ ) {
                    if (id.equals(expenseList.get(i).getId())) {
                        flag1 = true;
                        check = true;
                        System.out.print("bạn có chắc muốn xoá\n" +
                                "1. Có\n" +
                                "2. Không\n" +
                                "mời bạn chọn: ");
                        String chose = scanner.nextLine();
                        if (chose.equals("1")) {
                            expenseRepository.delete(i);
                            System.out.println("xoá oke!");
                        } else {
                            break;
                        }
                    }
                }
                if (!flag1) {
                    throw new IdNotFoundException("ko có id muốn xoá");
                }
            } catch (IdNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println("mời nhập lại id muốn xoá");
            }
        } while (!check);

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
        }
        if (!flag1) {
            System.out.println("ko có id muốn xoá!");
        }
    }

    @Override
    public void findId() {
        System.out.print("nhập id muốn tìm kiếm: ");
        String id = scanner.nextLine();
        Expense expense = expenseRepository.findId(id);
        if (expense == null) {
            System.out.println("ko có chi tiêu cần tìm. ");
        } else {
            System.out.println(expense);
        }
    }

    @Override
    public void findName() {
        System.out.print("nhập name muốn tìm kiếm: ");
        String name = scanner.nextLine();
        List<Expense> expenseList = expenseRepository.findName(name);
        if (expenseList.size() == 0) {
            System.out.println("ko có chi tiêu cần tìm");
        } else {

            for (Expense e : expenseList) {
                System.out.println(e);
            }
        }

    }

    @Override
    public void sortName() {
        List<Expense> expenseNameList = expenseRepository.display();
        Collections.sort(expenseNameList, new Comparator<Expense>() {
            @Override
            public int compare(Expense o1, Expense o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        expenseRepository.sortName(expenseNameList);
        for (Expense e : expenseNameList) {
            System.out.println(e);
        }
    }

    @Override
    public void sortPrice() {
        List<Expense> expensePriceList = expenseRepository.display();
        Collections.sort(expensePriceList, new Comparator<Expense>() {
            @Override
            public int compare(Expense o1, Expense o2) {
                if (o1.getPrice() - o2.getPrice() == 0) {
                    return o1.getName().compareTo(o2.getName());
                } else if (o1.getPrice() - o2.getPrice() > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        expenseRepository.sortPrice(expensePriceList);
        for (Expense e : expensePriceList) {
            System.out.println(e);
        }
    }
}