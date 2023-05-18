package ss10.bai1.repository;

import ss10.bai1.model.Fruit;

import java.util.ArrayList;
import java.util.List;

public class FruitRepository implements IFruitRepository{
    private static List<Fruit> fruitList = new ArrayList<>();
    static {
        Fruit fruit = new Fruit("1","1","1","1","1",1);
        Fruit fruit1 = new Fruit("1","1","1","1","1",1);
        Fruit fruit2 = new Fruit("1","1","1","1","1",1);
        Fruit fruit3 = new Fruit("1","1","1","1","1",1);
        fruitList.add(fruit);
        fruitList.add(fruit1);
        fruitList.add(fruit2);
        fruitList.add(fruit3);
    }


    @Override
    public List<Fruit> display() {
        return fruitList;
    }

    @Override
    public void fruitAdd(Fruit fruit) {
        fruitList.add(fruit);
    }
}
