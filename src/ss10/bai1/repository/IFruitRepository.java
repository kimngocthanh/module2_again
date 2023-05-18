package ss10.bai1.repository;

import ss10.bai1.model.Fruit;

import java.util.List;

public interface IFruitRepository {
    List<Fruit> display();

    void fruitAdd(Fruit fruit);
}
