package ss10.bai2.service;

import ss10.bai2.model.Car;
import ss10.bai2.model.Manufacturer;
import ss10.bai2.model.MotoBiker;
import ss10.bai2.repository.ManufacturerRepository;
import ss10.bai2.repository.MotoBikerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotoBikerService implements IMotoBikerService{
    private MotoBikerRepository motoBikerRepository = new MotoBikerRepository();
    private List<MotoBiker> motoBikerList = motoBikerRepository.displayMotoBiker();
    private Scanner scanner = new Scanner(System.in);
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private List<Manufacturer> manufacturerRepositoryList = manufacturerRepository.display();

    @Override
    public void addMotoBiker() {
        motoBikerList = motoBikerRepository.displayMotoBiker();
        System.out.print("nhập biển kiểm soát: ");
        String seaOfControl = scanner.nextLine();
        manufacturerRepositoryList = manufacturerRepository.display();
        for (Manufacturer m : manufacturerRepositoryList) {
            System.out.println(m);
        }
        boolean flag = true;
        String nameFacturer = null;
        do {
            System.out.print("chọn hãng sản xuất theo id: ");
            String id = scanner.nextLine();
            boolean check = false;
            for (int i = 0; i < manufacturerRepositoryList.size(); i++) {
                if (id.equals(manufacturerRepositoryList.get(i).getIdFacturer())) {
                    nameFacturer = manufacturerRepositoryList.get(i).getNameFacrure();
                    flag = false;
                    check = true;
                }
            }if(!check){
                System.out.println("ko có id mời nhập lại!");
            }
        } while (flag);
        System.out.print("nhập năm sản xuất: ");
        String yearOfManufacture = scanner.nextLine();
        System.out.print("nhập chủ sở hữu: ");
        String owner = scanner.nextLine();
        System.out.print("nhập công suất: ");
        String wattage = scanner.nextLine();
        MotoBiker motoBiker = new MotoBiker(seaOfControl,nameFacturer,yearOfManufacture,owner,wattage);
        motoBikerList.add(motoBiker);
        System.out.println("add oke");
    }

    @Override
    public void displayMotoBiker() {
        motoBikerList = motoBikerRepository.displayMotoBiker();
        for (MotoBiker m: motoBikerList) {
            System.out.println(m);
        }
    }

    @Override
    public void removeMotoBiker() {
        motoBikerList = motoBikerRepository.displayMotoBiker();
        boolean flag = true;
        System.out.print("nhập biển kiểm soát muốn xoá: ");
        String seaOfControl = scanner.nextLine();
        for (int i = 0; i< motoBikerList.size();i++) {
            flag = true;
            if (seaOfControl.equals(motoBikerList.get(i).getSeaOfControl())) {
                flag = true;
                System.out.print("bạn có chắc muốn xoá!\n" +
                        "1. Có\n" +
                        "2. Không\n" +
                        "chọn: ");
                String chose = scanner.nextLine();
                switch (chose) {
                    case "1":
                        motoBikerRepository.removeMotoBiker(i);
                        System.out.println("xoá thành công!");
                    case "2":
                        break;
                }
            }
        }
        if (!flag) {
            System.out.print("ko có biển muốn xoá");
        }

    }

    @Override
    public void findMotoBiker() {
        motoBikerList = motoBikerRepository.displayMotoBiker();
        System.out.print("nhập biển kiểm soát: ");
        String seaOfControl = scanner.nextLine();
        for (int i = 0; i < motoBikerList.size(); i++) {
            if(seaOfControl.equals(motoBikerList.get(i).getSeaOfControl())){
                motoBikerRepository.findMotoBiker(seaOfControl);
            }
        }
    }

}
