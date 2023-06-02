package casestudy.service;


import casestudy.model.Booking;
import casestudy.model.Customer;
import casestudy.model.Facility;
import casestudy.repository.BooKingRepository;
import casestudy.repository.CustomerRepository;
import casestudy.repository.FacilityRepository;

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
        for (Booking b : bookingTreeSet) {
            System.out.println(b);
        }
    }

    @Override
    public void addBooking() {
        //String idBooking, String dateBooking, String dayStartRental, String dayEndRental, String idCustomer, String idService
        System.out.print("Nhập id booking: ");
        String idBooking = scanner.nextLine();
        System.out.print("Nhập ngày booking: ");
        String dateBooking = scanner.nextLine();
        System.out.print("Nhập ngày bắt đầu booking: ");
        String dayStartRental = scanner.nextLine();
        System.out.print("Nhập ngày kết thúc booking: ");
        String dayEndRental = scanner.nextLine();
        String idCustomer = "";
        List<Customer> customerList = customerRepository.displayCustomer();
        boolean flag = false;
        do {
            for (Customer c : customerList) {
                System.out.println(c);
            }
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
            for (Facility f : facilitySet) {
                System.out.println(f);
            }
            System.out.print("Nhập mã dịch vụ khách muốn booking: ");
            idService = scanner.nextLine();
            for (Facility f : facilitySet) {
                if(f.getIdService().equals(idService)){
                    flagIdService = true;
                    break;
                }
            }
            if(!flagIdService) {
                System.out.println("KO có mã dịch vụ khách muốn sử dụng! ");
            }
        }while (!flagIdService);

        Booking booking = new Booking(idBooking,dateBooking,dayStartRental,dayEndRental,idCustomer,idService);

        booKingRepository.addBooking(booking);
        System.out.println("Thêm mới thành công!");
    }
}
