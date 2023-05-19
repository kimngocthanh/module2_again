package ss10.bai2.repository;

import ss10.bai2.model.Car;
import ss10.bai2.model.MotoBiker;

import java.util.ArrayList;
import java.util.List;

public class MotoBikerRepository implements IMotoBiker{
    private static List<MotoBiker> motoBikers = new ArrayList<>();
    static {
        MotoBiker motoBiker = new MotoBiker("28A-1234", "honda", "2018", "Kim Ngọc Thành", "10");
        MotoBiker motoBiker1 = new MotoBiker("28A-4321", "vison", "2018", "Kim Ngọc ", "10");
        MotoBiker motoBiker2 = new MotoBiker("28A-1264", "sh", "2014", "Kim  Thành", "10");
        MotoBiker motoBiker3 = new MotoBiker("28A-1674", "ab", "2016", " Ngọc Thành", "10");
        MotoBiker motoBiker4 = new MotoBiker("28A-7894", "honda", "2019", "Nguyễn Thanhd Thân", "10");

        motoBikers.add(motoBiker);
        motoBikers.add(motoBiker1);
        motoBikers.add(motoBiker2);
        motoBikers.add(motoBiker3);
        motoBikers.add(motoBiker4);
    }

    @Override
    public List<MotoBiker> displayMotoBiker() {
        return motoBikers;
    }

    @Override
    public void addMotoBiker(MotoBiker motoBiker) {
        motoBikers.add(motoBiker);

    }

    @Override
    public void removeMotoBiker(int index) {
        motoBikers.remove(index);
    }

    @Override
    public boolean findMotoBiker(String seaOfControl) {
        for (int i = 0; i < motoBikers.size(); i++) {
            if(seaOfControl.equals(motoBikers.get(i).getSeaOfControl())){
                System.out.println(motoBikers.get(i));
                return true;
            }
        }return false;
    }

}
