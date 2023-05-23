package ss12.service;

import ss12.model.Fruit;
import ss12.repository.FruitRepository;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FruitService implements IFruitService {
    Scanner scanner = new Scanner(System.in);
    private FruitRepository fruitRepository = new FruitRepository();

    @Override
    public void displayKeySet() {
        Map<Fruit, String> fruitStringMap = fruitRepository.display();
        Set<Fruit> fruitSet = fruitStringMap.keySet();
        for (Fruit f : fruitSet) {
            System.out.println(f + "  " + "loại: " + fruitStringMap.get(f));
        }
    }

    @Override
    public void displayEntrySet() {
        Map<Fruit, String> fruitStringMap = fruitRepository.display();
        for (Map.Entry<Fruit, String> entry : fruitStringMap.entrySet()) {
            Fruit fruit = entry.getKey();
            String type = entry.getValue();
            System.out.println(fruit + "  " + " loại: " + type);
        }
    }

    @Override
    public void addFruit() {
        System.out.print("Nhập mã quả: ");
        String idFruit = scanner.nextLine();
        System.out.print("nhập tên hoa quả: ");
        String fruitName = scanner.nextLine();
        System.out.print("nhập loại hoa quả: ");
        String fruitType = scanner.nextLine();
        System.out.print("nhập ngày sản xuất hoa quả: ");
        String dateOfManufacture = scanner.nextLine();
        System.out.print("nhập ngày hết hạn hoa quả: ");
        String expiry = scanner.nextLine();
        System.out.print("nhập xuất xứ hoa quả: ");
        String origin = scanner.nextLine();
        System.out.print("nhập giá hoa quả: ");
        int price = Integer.parseInt(scanner.nextLine());
        Fruit fruit = new Fruit(idFruit, fruitName, fruitType, dateOfManufacture, expiry, origin, price);
        fruitRepository.addFruit(fruit, fruitType);
        System.out.println("add thành công");
    }

    @Override
    public void removeFruit() {
        System.out.print("nhập id muốn xoá: ");
        String idFruit = scanner.nextLine();
        Fruit fruit = fruitRepository.getIdFruid(idFruit);
        if (fruit == null) {
            System.out.println(" ko có sp muốn xoá!");
        } else {
            System.out.print("bạn có chắc muốn xoá\n");
            System.out.print("1. có\n" +
                    "2. ko\n");
            System.out.print("nhập chọn:");
            int chose = Integer.parseInt(scanner.nextLine());
            if (chose == 1) {
                fruitRepository.deleteFruit(fruit);
                System.out.println("xoá thành công!");
            }
        }


    }

    @Override
    public void editFruit() {
        System.out.print("nhập id muốn edit: ");
        String idFruit = scanner.nextLine();
        Fruit fruit = fruitRepository.getIdFruid(idFruit);
        if (fruit == null) {
            System.out.println("ko có sp muốn sửa");
        } else {
            fruitRepository.deleteFruit(fruit);
            System.out.print("nhập tên hoa quả: ");
            String fruitName = scanner.nextLine();
            System.out.print("nhập loại hoa quả: ");
            String fruitType = scanner.nextLine();
            System.out.print("nhập ngày sản xuất hoa quả: ");
            String dateOfManufacture = scanner.nextLine();
            System.out.print("nhập ngày hết hạn hoa quả: ");
            String expiry = scanner.nextLine();
            System.out.print("nhập xuất xứ hoa quả: ");
            String origin = scanner.nextLine();
            System.out.print("nhập giá hoa quả: ");
            int price = Integer.parseInt(scanner.nextLine());
            Fruit fruit1 = new Fruit(idFruit, fruitName, fruitType, dateOfManufacture, expiry, origin, price);
            fruitRepository.addFruit(fruit1, fruitType);
            System.out.println("sửa thành công");
        }
    }
}
