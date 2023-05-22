package ss12.repository;

import ss12.model.Fruit;

import java.util.Map;

public interface IFruitRepository {
    Map<Fruit, String> display();

    void addFruit(Fruit fruit, String typeFruit);

    void deleteFruit(Fruit fruit);

    void editFruit(Fruit fruit);

    Fruit getIdFruid(String idFruit);

}
