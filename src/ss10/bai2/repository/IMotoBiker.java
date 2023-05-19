package ss10.bai2.repository;

import ss10.bai2.model.Car;
import ss10.bai2.model.MotoBiker;

import java.util.List;

public interface IMotoBiker {
    List<MotoBiker> displayMotoBiker();

    void addMotoBiker(MotoBiker motoBiker);

    void removeMotoBiker(int index);

    boolean findMotoBiker(String seaOfControl);
}
