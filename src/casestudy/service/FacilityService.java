package casestudy.service;


import casestudy.model.Facility;
import casestudy.model.House;
import casestudy.model.Room;
import casestudy.model.Villa;
import casestudy.repository.FacilityRepository;
import casestudy.validate.FacilityRegex;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityService implements IFacilityService {
    Scanner scanner = new Scanner(System.in);

    private FacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void displayFacility() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.displayFacility();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        System.out.println("+---------------+---------------+------------------+----------------+-----------+------------------+ " +
                "------------------+------------------+----------+--------------------+------------------");
        System.out.println("| Mã dịch vụ    | Tên dịch vụ   | Diện tích phòng  | Chi phí thuê   | Số người  | Kiểu thuê        | " +
                "Tiêu chuẩn phòng  | Diện tích hồ bơi | Số Tầng  |  Dịch vụ miễn phí  | Số lần sử dụng   |");
        for (Facility f : facilitySet) {
            System.out.println("+---------------+---------------+------------------+----------------+-----------+------------------+ " +
                    "------------------+------------------+----------+--------------------+------------------");
            if (f instanceof Room) {
                System.out.printf("|%-15s|%-15s|%-18s|%-16s|%-11s|%-18s|%-19s|%-18s|%-10s|%-20s|%-18s|\n",
                        f.getIdService(), f.getNameService(), f.getArea(),
                        f.getRentalCosts(), f.getNumberPerson(), f.getTypeRental(), " ", " ", " "
                        , ((Room) f).getFreeService(), facilityIntegerMap.get(f));
            } else if (f instanceof House) {
                System.out.printf("|%-15s|%-15s|%-18s|%-16s|%-11s|%-18s|%-19s|%-18s|%-10s|%-20s|%-18s|\n",
                        f.getIdService(), f.getNameService(), f.getArea(),
                        f.getRentalCosts(), f.getNumberPerson(), f.getTypeRental(),
                        ((House) f).getRoomStandardHouse(), "", ((House) f).getNumberFloors(), " ",facilityIntegerMap.get(f));
            } else {
                System.out.printf("|%-15s|%-15s|%-18s|%-16s|%-11s|%-18s|%-19s|%-18s|%-10s|%-20s|%-18s|\n",
                        f.getIdService(), f.getNameService(), f.getArea(),
                        f.getRentalCosts(), f.getNumberPerson(), f.getTypeRental(),
                        ((Villa) f).getRoomStandardVilla(), ((Villa) f).getAreaPool(),
                        ((Villa) f).getNumberFloors(), " ",facilityIntegerMap.get(f));
            }
        }
        System.out.println("+---------------+---------------+------------------+----------------+-----------+------------------+ " +
                "------------------+------------------+----------+--------------------+------------------");
    }

    @Override
    public void addRoom() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.displayFacility();
        String idRoom = "";
        do {
            System.out.print("Mời Nhập Id room theo đúng định dạng RO-XXXX: ");
            idRoom = scanner.nextLine();
            if (!FacilityRegex.checkIdRoomRegex(idRoom)) {
                System.out.println("Nhập sai định dạng mời nhập lại cho đúng! ");
            }
            break;
        } while (true);

        String nameRoom = "";
        do {
            System.out.print("Mời nhập tên room viết hoa chữ cái đầu: ");
            nameRoom = scanner.nextLine();
            if (!FacilityRegex.checkNameFacility(nameRoom)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!FacilityRegex.checkNameFacility(nameRoom));

        double areaRoom = 0;
        do {
            try {
                System.out.print("Nhập diện tích phòng lớn hơn 30m2: ");
                areaRoom = Double.parseDouble(scanner.nextLine());
                if (areaRoom < 30) {
                    System.out.println("Nhập lại diện tích! ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Diện tích phải là số! ");
            }
        } while (areaRoom < 30);

        double rentalCosts = 0;
        do {
            try {
                System.out.print("Nhập chi phí thuê: ");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                if (rentalCosts < 0) {
                    System.out.println("Chi phí phải là số dương! ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chi phí phải là 1 số! ");
            }

        } while (rentalCosts < 0);

        int numberPerson = 0;
        do {
            try {
                System.out.print("Nhập số người thuê phòng: ");
                numberPerson = Integer.parseInt(scanner.nextLine());
                if (numberPerson < 0 || numberPerson > 20) {
                    System.out.println("Số người quy định lớn hơn 0 và nhỏ hơn 20!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Số người phải là số nguyên! ");
            }
        } while (numberPerson < 0 || numberPerson > 20);

        String typeRental = "";
        boolean flagTypeRental = false;
        do {
            System.out.print("1. Thuê theo năm\n" +
                    "2. Thuê theo tháng\n" +
                    "3. Thuê theo ngày\n" +
                    "4. Thuê theo giờ\n" +
                    "Mời chọn kiểu thuê: ");
            String choseType = scanner.nextLine();
            switch (choseType) {
                case "1":
                    typeRental = "Thuê theo năm";
                    flagTypeRental = true;
                    break;
                case "2":
                    typeRental = "Thuê theo tháng";
                    flagTypeRental = true;
                    break;
                case "3":
                    typeRental = "Thuê theo ngày";
                    flagTypeRental = true;
                    break;
                case "4":
                    typeRental = "Thuê theo giờ";
                    flagTypeRental = true;
                    break;
                default:
                    System.out.println("Chọn sai kiểu thuê mời chọn lại! ");
                    break;
            }
        } while (!flagTypeRental);

        System.out.print("Nhập dịch vụ miễn phí đi kèm : ");
        String freeService = scanner.nextLine();

        Room room = new Room(idRoom, nameRoom, areaRoom, rentalCosts, numberPerson, typeRental, freeService);
        facilityRepository.addRoom(room, 0);
        System.out.println("add room thành công!");
        //String idService, String nameService, String area, double rentalCosts, int numberPerson,
        //                String typeRental, String freeService
    }

    @Override
    public void addHouse() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.displayFacility();
        String idHouse = "";
        do {
            System.out.print("Mời Nhập Id house theo đúng định dạng HO-XXXX: ");
            idHouse = scanner.nextLine();
            if (!FacilityRegex.checkIdHouseRegex(idHouse)) {
                System.out.println("Nhập sai định dạng mời nhập lại cho đúng! ");
            }
        } while (!FacilityRegex.checkIdHouseRegex(idHouse));

        String nameHouse = "";
        do {
            System.out.print("Mời nhập tên house viết hoa chữ cái đầu: ");
            nameHouse = scanner.nextLine();
            if (!FacilityRegex.checkNameFacility(nameHouse)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!FacilityRegex.checkNameFacility(nameHouse));

        double areaHouse = 0;
        do {
            try {
                System.out.print("Nhập diện tích phòng lớn hơn 30m2: ");
                areaHouse = Double.parseDouble(scanner.nextLine());
                if (areaHouse < 30) {
                    System.out.println("Nhập lại diện tích! ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Diện tích phải là kiểu số! ");
            }

        } while (areaHouse < 30);

        double rentalCosts = 0;
        do {
            try {
                System.out.print("Nhập chi phí thuê: ");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                if (rentalCosts < 0) {
                    System.out.println("Chi phí phải là số dương! ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chi phí phải là dạng số! ");
            }
        } while (rentalCosts < 0);

        int numberPerson = 0;
        do {
            try {
                System.out.print("Nhập số người thuê phòng: ");
                numberPerson = Integer.parseInt(scanner.nextLine());
                if (numberPerson < 0 || numberPerson > 20) {
                    System.out.println("Số người quy định lớn hơn 0 và nhỏ hơn 20!");
                }
            }catch (NumberFormatException e){
                System.out.println("Người phải là 1 số! ");
            }
        } while (numberPerson < 0 || numberPerson > 20);

        String typeRental = "";
        boolean flagTypeRental = false;
        do {
            System.out.print("1. Thuê theo năm\n" +
                    "2. Thuê theo tháng\n" +
                    "3. Thuê theo ngày\n" +
                    "4. Thuê theo giờ\n" +
                    "Mời chọn kiểu thuê: ");
            String choseType = scanner.nextLine();
            switch (choseType) {
                case "1":
                    typeRental = "Thuê theo năm";
                    flagTypeRental = true;
                    break;
                case "2":
                    typeRental = "Thuê theo tháng";
                    flagTypeRental = true;
                    break;
                case "3":
                    typeRental = "Thuê theo ngày";
                    flagTypeRental = true;
                    break;
                case "4":
                    typeRental = "Thuê theo giờ";
                    flagTypeRental = true;
                    break;
                default:
                    System.out.println("Chọn sai kiểu thuê mời chọn lại! ");
                    break;
            }
        } while (!flagTypeRental);

        String roomStandardHouse = "";
        do {
            System.out.print("Mời nhập tiêu chuẩn phòng viết hoa chữ cái đầu: ");
            roomStandardHouse = scanner.nextLine();
            if (!FacilityRegex.checkNameFacility(roomStandardHouse)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!FacilityRegex.checkNameFacility(roomStandardHouse));

        int numberFloors = 0;
        do {
            try {
                System.out.print("Nhập số tầng thuê phòng: ");
                numberFloors = Integer.parseInt(scanner.nextLine());
                if (numberFloors < 0 || numberFloors > 5) {
                    System.out.println("Số tầng lớn hơn 0 và nhỏ hơn 5!");
                }
            }catch (NumberFormatException e){
                System.out.println("Số tầng phải là 1 số nguyên! ");
            }

        } while (numberFloors < 0 || numberFloors > 5);

        House house = new House(idHouse, nameHouse, areaHouse, rentalCosts, numberPerson, typeRental,
                roomStandardHouse, numberFloors);
        facilityRepository.addHouse(house, 0);
        System.out.println("Thêm mới house thành công! ");
    }

    @Override
    public void addVilla() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.displayFacility();
        String idVilla = "";
        do {
            System.out.print("Mời Nhập Id villa theo đúng định dạng VI-XXXX: ");
            idVilla = scanner.nextLine();
            if (!FacilityRegex.checkIdVillaRegex(idVilla)) {
                System.out.println("Nhập sai định dạng mời nhập lại cho đúng! ");
            }
        } while (!FacilityRegex.checkIdVillaRegex(idVilla));

        String nameVilla = "";
        do {
            System.out.print("Mời nhập tên villa viết hoa chữ cái đầu: ");
            nameVilla = scanner.nextLine();
            if (!FacilityRegex.checkNameFacility(nameVilla)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!FacilityRegex.checkNameFacility(nameVilla));

        double areaVilla = 0;
        do {
            try {
                System.out.print("Nhập diện tích phòng lớn hơn 30m2: ");
                areaVilla = Double.parseDouble(scanner.nextLine());
                if (areaVilla < 30) {
                    System.out.println("Nhập lại diện tích! ");
                }
            }catch (NumberFormatException e){
                System.out.println("Diện tích phải là số thực! ");
            }

        } while (areaVilla < 30);

        double rentalCosts = 0;
        do {
            try {
                System.out.print("Nhập chi phí thuê: ");
                rentalCosts = Double.parseDouble(scanner.nextLine());
                if (rentalCosts < 0) {
                    System.out.println("Chi phí phải là số dương! ");
                }
            }catch (NumberFormatException e){
                System.out.println("Chi phí thuê phải là dạng số! ");
            }

        } while (rentalCosts < 0);

        int numberPerson = 0;
        do {
            try {
                System.out.print("Nhập số người thuê phòng: ");
                numberPerson = Integer.parseInt(scanner.nextLine());
                if (numberPerson < 0 || numberPerson > 20) {
                    System.out.println("Số người quy định lớn hơn 0 và nhỏ hơn 20!");
                }
            }catch (NumberFormatException e){
                System.out.println("Người phải là số nguyên! ");
            }

        } while (numberPerson < 0 || numberPerson > 20);

        String typeRental = "";
        boolean flagTypeRental = false;
        do {
            System.out.print("1. Thuê theo năm\n" +
                    "2. Thuê theo tháng\n" +
                    "3. Thuê theo ngày\n" +
                    "4. Thuê theo giờ\n" +
                    "Mời chọn kiểu thuê: ");
            String choseType = scanner.nextLine();
            switch (choseType) {
                case "1":
                    typeRental = "Thuê theo năm";
                    flagTypeRental = true;
                    break;
                case "2":
                    typeRental = "Thuê theo tháng";
                    flagTypeRental = true;
                    break;
                case "3":
                    typeRental = "Thuê theo ngày";
                    flagTypeRental = true;
                    break;
                case "4":
                    typeRental = "Thuê theo giờ";
                    flagTypeRental = true;
                    break;
                default:
                    System.out.println("Chọn sai kiểu thuê mời chọn lại! ");
                    break;
            }
        } while (!flagTypeRental);

        String roomStandardVilla = "";
        do {
            System.out.print("Mời nhập tiêu chuẩn phòng viết hoa chữ cái đầu: ");
            roomStandardVilla = scanner.nextLine();
            if (!FacilityRegex.checkNameFacility(roomStandardVilla)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!FacilityRegex.checkNameFacility(roomStandardVilla));

        double areaPool = 0;
        do {
            try {
                System.out.print("Nhập diện tích hồ bơi lớn hơn 30m2: ");
                areaPool = Double.parseDouble(scanner.nextLine());
                if (areaPool < 30) {
                    System.out.println("Nhập lại diện tích! ");
                }
            }catch (NumberFormatException e){
                System.out.println("Diện tích hồ bơi phải là dạng số! ");
            }

        } while (areaPool < 30);

        int numberFloors = 0;
        do {
            try {
                System.out.print("Nhập số tầng thuê phòng: ");
                numberFloors = Integer.parseInt(scanner.nextLine());
                if (numberFloors < 0 || numberFloors > 5) {
                    System.out.println("Số tầng lớn hơn 0 và nhỏ hơn 5!");
                }
            }catch (NumberFormatException e){
                System.out.println("Số tầng phải là số nguyên dương");
            }

        } while (numberFloors < 0 || numberFloors > 5);

        Villa villa = new Villa(idVilla, nameVilla, areaVilla, rentalCosts, numberPerson, typeRental,
                roomStandardVilla, areaPool, numberFloors);
        facilityRepository.addHouse(villa, 0);
        System.out.println("Thêm mới villa thành công! ");
    }

    @Override
    public void removeFacility() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.displayFacility();
        System.out.print("Nhập id dịch vụ muốn xoá: ");
        String idFacility = scanner.nextLine();
        boolean flag = false;
        do {
            System.out.print("Bạn có chắc muốn xoá ko\n" +
                    "1. Xoá\n" +
                    "2. Không xoá\n" +
                    "Mời bạn chọn : ");
            String chose = scanner.nextLine();
            switch (chose){
                case "1":
                    facilityRepository.removeFacility(idFacility);
                    System.out.println("Bạn đã xoá thành công!");
                    flag = true;
                    break;
                case "2":
                    System.out.println("Không xoá dịch vụ! ");
                    flag=true;
                    break;
                default:
                    System.out.println("Nhập sai chức năng mời bạn nhập lại cho đúng!");
                    break;
            }
        }while (!flag);
    }

    @Override
    public void displayFacilityMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.displayFacilityMaintenance();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        System.out.println("+---------------+---------------+------------------+----------------+-----------+------------------+ " +
                "------------------+------------------+----------+--------------------+------------------");
        System.out.println("| Mã dịch vụ    | Tên dịch vụ   | Diện tích phòng  | Chi phí thuê   | Số người  | Kiểu thuê        | " +
                "Tiêu chuẩn phòng  | Diện tích hồ bơi | Số Tầng  |  Dịch vụ miễn phí  | Số lần sử dụng   |");
        for (Facility f : facilitySet) {
            System.out.println("+---------------+---------------+------------------+----------------+-----------+------------------+ " +
                    "------------------+------------------+----------+--------------------+------------------");
            if (f instanceof Room) {
                System.out.printf("|%-15s|%-15s|%-18s|%-16s|%-11s|%-18s|%-19s|%-18s|%-10s|%-20s|%-18s|\n",
                        f.getIdService(), f.getNameService(), f.getArea(),
                        f.getRentalCosts(), f.getNumberPerson(), f.getTypeRental(), " ", " ", " "
                        , ((Room) f).getFreeService(), facilityIntegerMap.get(f));
            } else if (f instanceof House) {
                System.out.printf("|%-15s|%-15s|%-18s|%-16s|%-11s|%-18s|%-19s|%-18s|%-10s|%-20s|%-18s|\n",
                        f.getIdService(), f.getNameService(), f.getArea(),
                        f.getRentalCosts(), f.getNumberPerson(), f.getTypeRental(),
                        ((House) f).getRoomStandardHouse(), "", ((House) f).getNumberFloors(), " ",facilityIntegerMap.get(f));
            } else {
                System.out.printf("|%-15s|%-15s|%-18s|%-16s|%-11s|%-18s|%-19s|%-18s|%-10s|%-20s|%-18s|\n",
                        f.getIdService(), f.getNameService(), f.getArea(),
                        f.getRentalCosts(), f.getNumberPerson(), f.getTypeRental(),
                        ((Villa) f).getRoomStandardVilla(), ((Villa) f).getAreaPool(),
                        ((Villa) f).getNumberFloors(), " ",facilityIntegerMap.get(f));
            }
        }
        System.out.println("+---------------+---------------+------------------+----------------+-----------+------------------+ " +
                "------------------+------------------+----------+--------------------+------------------");
    }
}
