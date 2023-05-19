package ss10.bai2.repository;

import ss10.bai2.model.Manufacturer;

import java.util.ArrayList;
import java.util.List;

public class ManufacturerRepository implements IManufacturerRepository {
    private static List<Manufacturer> manufacturerList = new ArrayList<>();
    static {
        ss10.bai2.model.Manufacturer manufacturer = new ss10.bai2.model.Manufacturer("001", " honda", "hàn quốc");
        ss10.bai2.model.Manufacturer manufacturer1 = new ss10.bai2.model.Manufacturer("002", " honda", "nhật bản");
        ss10.bai2.model.Manufacturer manufacturer2 = new ss10.bai2.model.Manufacturer("003", " honda", "việt nam");
        ss10.bai2.model.Manufacturer manufacturer3 = new ss10.bai2.model.Manufacturer("004", " honda", "trung quốc");
        ss10.bai2.model.Manufacturer manufacturer4 = new ss10.bai2.model.Manufacturer("005", " honda", "hàn quốc");
        manufacturerList.add(manufacturer);
        manufacturerList.add(manufacturer1);
        manufacturerList.add(manufacturer2);
        manufacturerList.add(manufacturer3);
        manufacturerList.add(manufacturer4);
    }

    @Override
    public List<Manufacturer> display() {
        return manufacturerList;
    }
}
