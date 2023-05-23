package ss12.repository;

import ss12.model.Fruit;

import java.util.*;

public class FruitRepository implements IFruitRepository {
    private static Map<Fruit, String> fruitStringMap = new HashMap<>();

    static {
        Fruit fruit = new Fruit("001", "Cam sành          ", "Cam    ", "2022/09/09", "2023/09/10", "Việt Nam", 50000);
        Fruit fruit1 = new Fruit("002", "Cam đỏ            ", "Cam    ", "2022/09/09", "2023/09/10", "Việt Nam", 60000);
        Fruit fruit2 = new Fruit("003", "Bưởi Năm Roi      ", "Bưởi   ", "2022/09/09", "2023/09/10", "Việt Nam", 40000);
        Fruit fruit3 = new Fruit("004", "Bưởi da xanh      ", "Bưởi   ", "2022/09/09", "2023/09/10", "Việt Nam", 70000);
        Fruit fruit4 = new Fruit("005", "Dưa hấu ruột đỏ   ", "Dưa Hấu", "2022/09/09", "2023/09/10", "Việt Nam", 50000);
        Fruit fruit5 = new Fruit("006", "Dưa hấu không hạt ", "Dưa Hấu", "2022/09/09", "2023/09/10", "Việt Nam", 80000);
        Fruit fruit6 = new Fruit("007", "Dưa hấu ruột vàng ", "Dưa Hấu", "2022/09/09", "2023/09/10", "Việt Nam", 100000);

        fruitStringMap.put(fruit, "Cam");
        fruitStringMap.put(fruit1, "Cam");
        fruitStringMap.put(fruit2, "Bưởi");
        fruitStringMap.put(fruit3, "Bưởi");
        fruitStringMap.put(fruit4, "Dưa Hấu");
        fruitStringMap.put(fruit5, "Dưa Hấu");
        fruitStringMap.put(fruit6, "Dưa Hấu");
    }

    @Override
    public Map<Fruit, String> display() {
        return fruitStringMap;
    }

    @Override
    public void addFruit(Fruit fruit, String typeFruit) {
        fruitStringMap.put(fruit, typeFruit);
    }

    @Override
    public void deleteFruit(Fruit fruit) {
        fruitStringMap.remove(fruit);
    }

    @Override
    public Fruit getIdFruid(String idFruit) {
        Set<Fruit> fruitSet = fruitStringMap.keySet();
        for (Fruit f : fruitSet) {
            if (f.getIdFruit().equals(idFruit)) {
                return f;
            }
        }
        return null;
    }
}
