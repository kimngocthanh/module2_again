package ss10.bai1.service;

import ss10.bai1.model.Fruit;
import ss10.bai1.repository.FruitRepository;

import java.util.List;
import java.util.Scanner;

public class FruitService implements IFruitService {
    Scanner scanner = new Scanner(System.in);
    private FruitRepository fruitRepository = new FruitRepository();


    @Override
    public void add() {
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
        Fruit fruit = new Fruit(fruitName,fruitType,dateOfManufacture,expiry,origin,price);
        fruitRepository.fruitAdd(fruit);
        System.out.println("add thành công");
    }

    @Override
    public void display() {
        List<Fruit> fruitList = fruitRepository.display();
        for (Fruit f : fruitList) {
            System.out.println(f);
        }
    }
}
