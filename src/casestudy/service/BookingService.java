package casestudy.service;


import casestudy.model.*;
import casestudy.repository.BooKingRepository;
import casestudy.repository.CustomerRepository;
import casestudy.repository.FacilityRepository;
import casestudy.validate.CustomerRegex;

import java.io.Serializable;
import java.util.*;

public class BookingService implements IBookingService {
    private final BooKingRepository booKingRepository = new BooKingRepository();

    private final CustomerRepository customerRepository = new CustomerRepository();

    private final FacilityRepository facilityRepository = new FacilityRepository();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayBooking() {
        TreeSet<Booking> bookingTreeSet = booKingRepository.displayBooing();
        System.out.println("+--------------+---------------+-----------------------+-----------------+----------------+--------------+");
        System.out.println("| Mã booking   | Ngày Booking  | Ngày bắt đầu booking  | Ngày kết thúc   | Mã khách hàng  | Mã dịch vụ   |");
        for (Booking b : bookingTreeSet) {
            System.out.println("+--------------+---------------+-----------------------+-----------------+----------------+--------------+");
            System.out.printf("|%-14s|%-15s|%-23s|%-16s|%-16s|%-14s|\n",
                    b.getIdBooking(), b.getDateBooking(), b.getDayStartRental(), b.getDayEndRental(), b.getIdCustomer(), b.getIdService());
        }
        System.out.println("+--------------+---------------+-----------------------+-----------------+----------------+--------------+");
    }

    @Override
    public void addBooking() {
        //String idBooking, String dateBooking, String dayStartRental, String dayEndRental, String idCustomer, String idService
        System.out.print("Nhập id booking: ");
        String idBooking = scanner.nextLine();
        String dateBooking = "";
        do {
            System.out.print("Nhập ngày booking đúng định dạng YYYY-MM-DD: ");
            dateBooking = scanner.nextLine();
            if (!CustomerRegex.checkOld(dateBooking)) {
                System.out.println("nhập sai định dạng mời nhập lại! ");
            }
        } while (!CustomerRegex.checkOld(dateBooking));
        String dayStartRental = "";
        do {
            System.out.print("Nhập ngày bắt đầu booking đúng định dạng YYYY-MM-DD: ");
            dayStartRental = scanner.nextLine();
            if (!CustomerRegex.checkOld(dayStartRental)) {
                System.out.println("nhập sai định dạng mời nhập lại! ");
            }
        } while (!CustomerRegex.checkOld(dayStartRental));
        String dayEndRental = "";
        do {
            System.out.print("Nhập ngày bắt đầu booking đúng định dạng YYYY-MM-DD: ");
            dayEndRental = scanner.nextLine();
            if (!CustomerRegex.checkOld(dayStartRental)) {
                System.out.println("nhập sai định dạng mời nhập lại! ");
            }
        } while (!CustomerRegex.checkOld(dayEndRental));
        String idCustomer = "";
        List<Customer> customerList = customerRepository.displayCustomer();
        boolean flag = false;
        do {
            System.out.println("+----------------+--------------------+----------------+-------------+--------------------+---------------+" +
                    "---------------+-------------------+---------------+");
            System.out.println("| Mã khách hàng  | Tên khách hàng     | Ngày sinh      | Giới tính   | Căn cước công dân  | Số điện thoại |" +
                    " Email         | Loại khách hàng   | Địa chỉ       |");
            for (Customer c : customerList) {
                System.out.println("+----------------+--------------------+----------------+-------------+--------------------+---------------+" +
                        "---------------+-------------------+---------------+");
                System.out.printf("|%-16s|%-20s|%-16s|%-13s|%-20s|%-15s|%-15s|%-19s|%-15s|\n",
                        c.getId(), c.getName(), c.getDate(), c.getGender(), c.getCode(), c.getTelephone(),
                        c.getEmail(), c.getTypeCustomer(), c.getAddress());
            }
            System.out.println("+----------------+--------------------+----------------+-------------+--------------------+---------------+" +
                    "---------------+-------------------+---------------+");
            System.out.print("nhập mã khách hàng muốn booking: ");
            idCustomer = scanner.nextLine();
            for (Customer customer : customerList) {
                if (idCustomer.equals(customer.getId())) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("ko có mã khách hàng muốn booking!");
            }
        } while (!flag);
        String idService = "";
        Map<Facility, Integer> map = facilityRepository.displayFacility();
        Set<Facility> facilitySet = map.keySet();
        boolean flagIdService = false;
        do {
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
                            , ((Room) f).getFreeService(), map.get(f));
                } else if (f instanceof House) {
                    System.out.printf("|%-15s|%-15s|%-18s|%-16s|%-11s|%-18s|%-19s|%-18s|%-10s|%-20s|%-18s|\n",
                            f.getIdService(), f.getNameService(), f.getArea(),
                            f.getRentalCosts(), f.getNumberPerson(), f.getTypeRental(),
                            ((House) f).getRoomStandardHouse(), "", ((House) f).getNumberFloors(), " ", map.get(f));
                } else {
                    System.out.printf("|%-15s|%-15s|%-18s|%-16s|%-11s|%-18s|%-19s|%-18s|%-10s|%-20s|%-18s|\n",
                            f.getIdService(), f.getNameService(), f.getArea(),
                            f.getRentalCosts(), f.getNumberPerson(), f.getTypeRental(),
                            ((Villa) f).getRoomStandardVilla(), ((Villa) f).getAreaPool(),
                            ((Villa) f).getNumberFloors(), " ", map.get(f));
                }
            }
            System.out.println("+---------------+---------------+------------------+----------------+-----------+------------------+ " +
                    "------------------+------------------+----------+--------------------+------------------");

            System.out.print("Nhập mã dịch vụ khách muốn booking: ");
            idService = scanner.nextLine();
            for (Facility f : facilitySet) {
                if (f.getIdService().equals(idService)) {
                    flagIdService = true;
                    break;
                }
            }
            if (!flagIdService) {
                System.out.println("KO có mã dịch vụ khách muốn sử dụng! ");
            }
        } while (!flagIdService);

        Booking booking = new Booking(idBooking, dateBooking, dayStartRental, dayEndRental, idCustomer, idService);

        booKingRepository.addBooking(booking);
        booKingRepository.addFacilityMaintenance(booking);
        System.out.println("Thêm mới thành công!");
    }
}
