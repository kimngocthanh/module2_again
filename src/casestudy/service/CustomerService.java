package casestudy.service;


import casestudy.model.Customer;
import casestudy.repository.CustomerRepository;
import casestudy.validate.CustomerRegex;
import casestudy.validate.UniqueException;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private final Scanner scanner = new Scanner(System.in);
    private final CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void displayCustomer() {
        List<Customer> customerList = customerRepository.displayCustomer();
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
    }

    @Override
    public void addCustomer() {
        List<Customer> customerList = customerRepository.displayCustomer();
        //String id, String name, String date, String gender, String code, String telephone, String email,
        // String typeCustomer, String address
        String idCustomer;
        do {
            try {
                System.out.print("Nhập id khách hàng theo đúng định dạng KH-XXXX: ");
                idCustomer = scanner.nextLine();
                if (!CustomerRegex.checkRegexIdCustomer(idCustomer)) {
                    System.out.println("Nhập sai định dạng mời nhập lại!");
                    continue;
                }
                for (Customer c : customerList) {
                    if (idCustomer.equals(c.getId())) {
                        throw new UniqueException("Id khách hàng bị trùng nhập lại id! ");
                    }
                }
                break;
            } catch (UniqueException e) {
                System.out.println(e.getMessage());
            }

        } while (true);

        String nameCustomer;
        do {
            System.out.print("Nhập tên khách hàng chữ cái đầu phải viết hoa: ");
            nameCustomer = scanner.nextLine();
            if (!CustomerRegex.checkRegexNameCustomer(nameCustomer)) {
                System.out.println("nhập sai định dạng của tên mời nhập lại! ");
            }
        } while (!CustomerRegex.checkRegexNameCustomer(nameCustomer));

        String dateCustomer;
        do {
            System.out.print("Nhập năm sinh khách hàng theo đúng định dạng YYYY-MM-DD: ");
            dateCustomer = scanner.nextLine();
            if (!CustomerRegex.checkOld(dateCustomer)) {
                System.out.println("nhập sai định dạng mời nhập lại! ");
            } else {
                if (!CustomerRegex.checkRegexOldCustomer(dateCustomer)) {
                    System.out.println("Tuổi chưa đủ mời nhập lại! ");
                }
            }
        } while (!CustomerRegex.checkRegexOldCustomer(dateCustomer));

        String genderCustomer = "";
        boolean flag = false;
        do {
            System.out.print("1. nam\n" +
                    "2. nữ\n" +
                    "mời chọn giới tính: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    genderCustomer = "nam";
                    flag = true;
                    break;
                case "2":
                    genderCustomer = "nữ";
                    flag = true;
                    break;
                default:
                    System.out.println("nhập sai mời chọn lại giới tính! ");
                    break;
            }
        } while (!flag);

        String codeCustomer;
        do {
            System.out.print("Nhập Căn cước công dân 9 số hoặc 12 số: ");
            codeCustomer = scanner.nextLine();
            if (!CustomerRegex.checkRegexCodeCusTomer(codeCustomer)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!CustomerRegex.checkRegexCodeCusTomer(codeCustomer));

        String telephoneCustomer;
        do {
            System.out.print("Nhập số điện thoại bắt đầu từ 0 và đủ 10 số: ");
            telephoneCustomer = scanner.nextLine();
            if (!CustomerRegex.checkRegexTelephoneCustomer(telephoneCustomer)) {
                System.out.println("Nhập sai số điện thoại mời nhập lại! ");
            }
        } while (!CustomerRegex.checkRegexTelephoneCustomer(telephoneCustomer));

        String emailCustomer;
        do {
            System.out.print("Nhập email khách hàng theo định dạng username@domain.extension: ");
            emailCustomer = scanner.nextLine();
            if (!CustomerRegex.checkRegexEmailCustomer(emailCustomer)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!CustomerRegex.checkRegexEmailCustomer(emailCustomer));

        String typeCustomer = "";
        do {
            System.out.print("1. Diamond\n" +
                    "2. Platinum\n" +
                    "3. Gold\n" +
                    "4. Silver\n" +
                    "5. Member\n" +
                    "Chọn loại khách hàng: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    typeCustomer = "Diamond";
                    flag = true;
                    break;
                case "2":
                    typeCustomer = "Platinum";
                    flag = true;
                    break;
                case "3":
                    typeCustomer = "Gold";
                    flag = true;
                    break;
                case "4":
                    typeCustomer = "Silver";
                    flag = true;
                    break;
                case "5":
                    typeCustomer = "Member";
                    flag = true;
                    break;
                default:
                    System.out.println("Chọn sai loại khách hàng mời nhập lại! ");
                    break;
            }
        } while (!flag);

        System.out.print("Nhập địa chỉ khách hàng: ");
        String address = scanner.nextLine();

        Customer customer = new Customer(idCustomer, nameCustomer, dateCustomer, genderCustomer, codeCustomer,
                telephoneCustomer, emailCustomer, typeCustomer, address);
        customerRepository.addCustomer(customer);
        System.out.println("Thêm mới khách hàng thành công! ");
    }

    @Override
    public void editCustomer() {
        List<Customer> customerList = customerRepository.displayCustomer();
        System.out.println("+----------------+--------------------+----------------+-------------+--------------------"
                + "+---------------+---------------+-------------------+---------------+");
        System.out.println("| Mã khách hàng  | Tên khách hàng     | Ngày sinh      | Giới tính   | Căn cước công dân  "
                + "| Số điện thoại | Email         | Loại khách hàng   | Địa chỉ       |");
        for (Customer c : customerList) {
            System.out.println("+----------------+--------------------+----------------+-------------+------------------"
                    + "--+---------------+---------------+-------------------+---------------+");
            System.out.printf("|%-16s|%-20s|%-16s|%-13s|%-20s|%-15s|%-15s|%-19s|%-15s|\n",
                    c.getId(), c.getName(), c.getDate(), c.getGender(), c.getCode(), c.getTelephone(),
                    c.getEmail(), c.getTypeCustomer(), c.getAddress());
        }
        System.out.println("+----------------+--------------------+----------------+-------------+--------------------+---------------+" +
                "---------------+-------------------+---------------+");
        System.out.print("Nhập idCustomer cần sửa: ");
        String idCustomer = scanner.nextLine();
        boolean checkid = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (idCustomer.equals(customerList.get(i).getId())) {
                boolean flag = false;
                checkid = true;
                do {
                    System.out.print("1. Tên khách hàng.\n" +
                            "2. Ngày sinh khách hàng\n" +
                            "3. Giới tính khách hàng\n" +
                            "4. Căn cước công dân\n" +
                            "5. Số điện thoại khách hàng\n" +
                            "6. Email khách hàng\n" +
                            "7. Loại khách hàng\n" +
                            "8. Địa chỉ khách hàng\n" +
                            "9. Thoát sửa khách hàng\n" +
                            "Nhập thuộc tính muốn sửa: ");
                    String chose = scanner.nextLine();
                    switch (chose) {
                        case "1":
                            String nameCustomer = "";
                            do {
                                System.out.println("Nhập lại tên khách hàng muốn sửa theo định dạng viết hoa chứ đầu: ");
                                nameCustomer = scanner.nextLine();
                                if (!CustomerRegex.checkRegexNameCustomer(nameCustomer)) {
                                    System.out.println("Nhập sai định dạng tên! ");
                                }
                            } while (!CustomerRegex.checkRegexNameCustomer(nameCustomer));
                            Customer customer = new Customer(idCustomer, nameCustomer, customerList.get(i).getDate(),
                                    customerList.get(i).getGender(), customerList.get(i).getCode(),
                                    customerList.get(i).getTelephone(), customerList.get(i).getEmail(),
                                    customerList.get(i).getTypeCustomer(), customerList.get(i).getAddress());
                            customerRepository.editCustomer(i, customer);
                            System.out.println("sửa tên thành công! ");
                            break;
                        case "2":
                            String dateCustomer = "";
                            do {
                                System.out.print("Nhập năm sinh khách hàng theo đúng định dạng YYYY-MM-DD: ");
                                dateCustomer = scanner.nextLine();
                                if (!CustomerRegex.checkOld(dateCustomer)) {
                                    System.out.println("nhập sai định dạng mời nhập lại! ");
                                } else {
                                    if (!CustomerRegex.checkRegexOldCustomer(dateCustomer)) {
                                        System.out.println("Tuổi chưa đủ mời nhập lại! ");
                                    }
                                }
                            } while (!CustomerRegex.checkRegexOldCustomer(dateCustomer));
                            customer = new Customer(idCustomer, customerList.get(i).getName(), dateCustomer,
                                    customerList.get(i).getGender(), customerList.get(i).getCode(),
                                    customerList.get(i).getTelephone(), customerList.get(i).getEmail(),
                                    customerList.get(i).getTypeCustomer(), customerList.get(i).getAddress());
                            customerRepository.editCustomer(i, customer);
                            System.out.println("Sửa ngày sinh khách hàng thành công! ");
                            break;
                        case "3":
                            String genderCustomer = "";
                            boolean flagGender = false;
                            do {
                                System.out.print("1. nam\n" +
                                        "2. nữ\n" +
                                        "mời chọn giới tính: ");
                                String check = scanner.nextLine();
                                switch (check) {
                                    case "1":
                                        genderCustomer = "nam";
                                        flagGender = true;
                                        break;
                                    case "2":
                                        genderCustomer = "nữ";
                                        flagGender = true;
                                        break;
                                    default:
                                        System.out.println("nhập sai mời chọn lại giới tính! ");
                                        break;
                                }
                            } while (!flagGender);
                            customer = new Customer(idCustomer, customerList.get(i).getName(),
                                    customerList.get(i).getDate(), genderCustomer, customerList.get(i).getCode(),
                                    customerList.get(i).getTelephone(), customerList.get(i).getEmail(),
                                    customerList.get(i).getTypeCustomer(), customerList.get(i).getAddress());
                            customerRepository.editCustomer(i, customer);
                            System.out.println("Sửa giới tính thành công! ");
                            break;
                        case "4":
                            String codeCustomer = "";
                            do {
                                System.out.print("Nhập Căn cước công dân muốn sửa 9 số hoặc 12 số: ");
                                codeCustomer = scanner.nextLine();
                                if (!CustomerRegex.checkRegexCodeCusTomer(codeCustomer)) {
                                    System.out.println("Nhập sai định dạng căn cước công dân nhập lại !");
                                }
                            } while (!CustomerRegex.checkRegexCodeCusTomer(codeCustomer));
                            customer = new Customer(idCustomer, customerList.get(i).getName(),
                                    customerList.get(i).getDate(), customerList.get(i).getGender(), codeCustomer,
                                    customerList.get(i).getTelephone(), customerList.get(i).getEmail(),
                                    customerList.get(i).getTypeCustomer(), customerList.get(i).getAddress());
                            customerRepository.editCustomer(i, customer);
                            System.out.println("Sửa Căn cước công dân thành công! ");
                            break;
                        case "5":
                            String telephoneCustomer = "";
                            do {
                                System.out.print("Nhập số điện thoạt cần sửa bắt đầu từ 0 và đủ 10 số: ");
                                telephoneCustomer = scanner.nextLine();
                                if (!CustomerRegex.checkRegexTelephoneCustomer(telephoneCustomer)) {
                                    System.out.println("Nhập sai định dạng số điện thoại mời nhập lại! ");
                                }
                            } while (!CustomerRegex.checkRegexTelephoneCustomer(telephoneCustomer));
                            customer = new Customer(idCustomer, customerList.get(i).getName(),
                                    customerList.get(i).getDate(), customerList.get(i).getGender(),
                                    customerList.get(i).getCode(), telephoneCustomer, customerList.get(i).getEmail(),
                                    customerList.get(i).getTypeCustomer(), customerList.get(i).getAddress());
                            customerRepository.editCustomer(i, customer);
                            System.out.println("Sửa số điện thoại thành công! ");
                            break;
                        case "6":
                            String emailCustomer = "";
                            do {
                                System.out.print("Nhập lại email khách hàng theo dúng định dạng username@domain.extension: ");
                                emailCustomer = scanner.nextLine();
                                if (!CustomerRegex.checkRegexEmailCustomer(emailCustomer)) {
                                    System.out.println("Nhập sai định dạng mời nhập lại! ");
                                }
                            } while (!CustomerRegex.checkRegexEmailCustomer(emailCustomer));
                            customer = new Customer(idCustomer, customerList.get(i).getName(),
                                    customerList.get(i).getDate(), customerList.get(i).getGender(),
                                    customerList.get(i).getCode(), customerList.get(i).getTelephone(), emailCustomer,
                                    customerList.get(i).getTypeCustomer(), customerList.get(i).getAddress());
                            customerRepository.editCustomer(i, customer);
                            System.out.println("Sửa email khách hàng thành công! ");
                            break;
                        case "7":
                            String typeCustomer = "";
                            boolean flagType = false;
                            do {
                                System.out.print("1. Diamond\n" +
                                        "2. Platinum\n" +
                                        "3. Gold\n" +
                                        "4. Silver\n" +
                                        "5. Member\n" +
                                        "Chọn loại khách hàng: ");
                                String check = scanner.nextLine();
                                switch (check) {
                                    case "1":
                                        typeCustomer = "Diamond";
                                        flagType = true;
                                        break;
                                    case "2":
                                        typeCustomer = "Platinum";
                                        flagType = true;
                                        break;
                                    case "3":
                                        typeCustomer = "Gold";
                                        flagType = true;
                                        break;
                                    case "4":
                                        typeCustomer = "Silver";
                                        flagType = true;
                                        break;
                                    case "5":
                                        typeCustomer = "Member";
                                        flagType = true;
                                        break;
                                    default:
                                        System.out.println("Chọn sai loại khách hàng mời nhập lại! ");
                                        break;
                                }
                            } while (!flagType);
                            customer = new Customer(idCustomer, customerList.get(i).getName(),
                                    customerList.get(i).getDate(), customerList.get(i).getGender(),
                                    customerList.get(i).getCode(), customerList.get(i).getTelephone(),
                                    customerList.get(i).getEmail(), typeCustomer, customerList.get(i).getAddress());
                            customerRepository.editCustomer(i, customer);
                            System.out.println("Sửa loại khách hàng thành công! ");
                            break;
                        case "8":
                            System.out.print("Nhập lại địa chỉ khách hàng muốn thay đổi: ");
                            String addressCustomer = scanner.nextLine();
                            customer = new Customer(idCustomer, customerList.get(i).getName(),
                                    customerList.get(i).getDate(), customerList.get(i).getGender(),
                                    customerList.get(i).getCode(), customerList.get(i).getTelephone(),
                                    customerList.get(i).getEmail(), customerList.get(i).getTypeCustomer(), addressCustomer);
                            customerRepository.editCustomer(i, customer);
                            System.out.println("Sửa địa chỉ khách hàng thành công! ");
                            break;
                        case "9":
                            System.out.print("Bạn có chắc muốn thoát chỉnh sửa\n" +
                                    "1. Có\n" +
                                    "2. Không\n" +
                                    "Mời bạn chọn: ");
                            chose = scanner.nextLine();
                            switch (chose) {
                                case "1":
                                    flag = true;
                                    break;
                                case "2":
                                    break;
                                default:
                                    System.out.println("Chọn sai mời chọn lại chức năng! ");
                                    break;
                            }
                        default:
                            System.out.println("Chọn sai chức năng mời chọn lại thuộc tính muốn sửa! ");
                            break;
                    }
                } while (!flag);
            }
        }
        if (!checkid) {
            System.out.println("ko có id bạn muốn sửa. ");
        }
    }

    @Override
    public void removeCustomer() {
        List<Customer> customerList = customerRepository.displayCustomer();
        System.out.print("Nhập id muốn xoá: ");
        String idCustomer = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equals(idCustomer)) {
                flag = true;
                System.out.print("Bạn có chắc muốn xoá " + customerList.get(i).getName() + " khỏi danh sách nhân viên không\n" +
                        "1. Xoá nhân viên\n" +
                        "2. Không xoá\n" +
                        "Mời chọn chức năng: ");
                String chose = scanner.nextLine();
                switch (chose) {
                    case "1":
                        customerRepository.removeCustomer(i);
                        System.out.println("bạn xoá thành công!");
                        break;
                    case "2":
                        break;
                }
            }
        }
        if (!flag) {
            System.out.println("Không có id muốn xoá! ");
        }
    }

    @Override
    public void searchCustomer() {
        System.out.print("Nhập tên muốn tìm kiếm: ");
        String nameCustomer = scanner.nextLine();
        List<Customer> customers = customerRepository.customerSearch(nameCustomer);
        if (customers.size() == 0) {
            System.out.println("Ko có tên nhân viên muốn tìm!");
        } else {
            for (Customer e : customers) {
                System.out.println(e);
            }
        }
    }
}
