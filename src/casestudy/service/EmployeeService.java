package casestudy.service;

import casestudy.model.Customer;
import casestudy.model.Employee;
import casestudy.repository.EmployeeRepository;
import casestudy.validate.CustomerRegex;
import casestudy.validate.EmployeeRegex;
import casestudy.validate.UniqueException;

import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private Scanner scanner = new Scanner(System.in);
    private EmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void displayEmployee() {
        List<Employee> employeeList = employeeRepository.displayEmployee();
        System.out.println("+---------------+--------------------+----------------+-------------+--------------------+----------------+" +
                "--------------------+--------------------+-------------+------------+");
        System.out.println("| Mã nhân viên  | Tên nhân viên      | Ngày sinh      | Giới tính   | Căn cước công dân  | Số điện thoại  |" +
                " Email              | Trình độ           | Vị Trí      | Lương      |");
        for (Employee e : employeeList) {
            System.out.println("+---------------+--------------------+----------------+-------------+--------------------+----------------+" +
                    "--------------------+--------------------+-------------+------------+");
            System.out.printf("|%-15s|%-20s|%-16s|%-13s|%-20s|%-16s|%-20s|%-20s|%-13s|%-12s|\n",
                    e.getId(), e.getName(), e.getDate(), e.getGender(), e.getCode(), e.getTelephone(),
                    e.getEmail(), e.getLevel(), e.getLocation(), e.getWage());
        }
        System.out.println("+---------------+--------------------+----------------+-------------+--------------------+----------------+" +
                "--------------------+--------------------+-------------+------------+");
    }

    @Override
    public void addEmployee() {
        List<Employee> employeeList = employeeRepository.displayEmployee();
        String idEmployee = "";
        do {
            try {
                System.out.print("Nhập id nhân viên theo đúng định dạng NV-XXXX: ");
                idEmployee = scanner.nextLine();
                if (!EmployeeRegex.checkRegexIdEmployee(idEmployee)) {
                    System.out.println("Nhập sai định dạng mời nhập lại!");
                    continue;
                }
                for (Employee e : employeeList) {
                    if (e.getId().equals(idEmployee)) {
                        throw new UniqueException("Trùng id mời nhập lại! ");
                    }
                }
                break;
            } catch (UniqueException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        String nameEmployee = "";
        do {
            System.out.print("Nhập tên nhân viên chữ cái đầu phải viết hoa: ");
            nameEmployee = scanner.nextLine();
            if (!EmployeeRegex.checkRegexNameEmployee(nameEmployee)) {
                System.out.println("nhập sai định dạng của tên mời nhập lại! ");
            }
        } while (!EmployeeRegex.checkRegexNameEmployee(nameEmployee));

        String dateEmployee = "";
        do {
            System.out.print("Nhập năm sinh nhân viên theo đúng định dạng YYYY-MM-DD: ");
            dateEmployee = scanner.nextLine();
            if (!EmployeeRegex.checkOld(dateEmployee)) {
                System.out.println("nhập sai định dạng mời nhập lại! ");
            } else {
                if (!EmployeeRegex.checkRegexOldEmployee(dateEmployee)) {
                    System.out.println("Tuổi chưa đủ mời nhập lại! ");
                }
            }
        } while (!EmployeeRegex.checkRegexOldEmployee(dateEmployee));

        String genderEmployee = "";
        boolean flag = false;
        do {
            System.out.print("1. nam\n" +
                    "2. nữ\n" +
                    "mời chọn giới tính: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    genderEmployee = "nam";
                    flag = true;
                    break;
                case "2":
                    genderEmployee = "nữ";
                    flag = true;
                    break;
                default:
                    System.out.println("nhập sai mời chọn lại giới tính! ");
                    break;
            }
        } while (!flag);

        String codeEmployee = "";
        do {
            System.out.print("Nhập Căn cước công dân 9 số hoặc 12 số: ");
            codeEmployee = scanner.nextLine();
            if (!EmployeeRegex.checkRegexCodeEmployee(codeEmployee)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!EmployeeRegex.checkRegexCodeEmployee(codeEmployee));

        String telephoneEmployee = "";
        do {
            System.out.print("Nhập số điện thoại bắt đầu từ 0 và đủ 10 số: ");
            telephoneEmployee = scanner.nextLine();
            if (!EmployeeRegex.checkRegexTelephoneEmployee(telephoneEmployee)) {
                System.out.println("Nhập sai số điện thoại mời nhập lại! ");
            }
        } while (!EmployeeRegex.checkRegexTelephoneEmployee(telephoneEmployee));

        String emailEmployee = "";
        do {
            System.out.print("Nhập email nhân viên theo định dạng username@domain.extension: ");
            emailEmployee = scanner.nextLine();
            if (!EmployeeRegex.checkRegexEmailEmployee(emailEmployee)) {
                System.out.println("Nhập sai định dạng mời nhập lại! ");
            }
        } while (!EmployeeRegex.checkRegexEmailEmployee(emailEmployee));

        String levelEmployee = "";
        do {
            System.out.print("1. Trung cấp\n" +
                    "2. Cao đẳng \n" +
                    "3. Đại học\n" +
                    "4, Sau đại học\n" +
                    "Chọn trình độ của nhân viên: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    levelEmployee = "Trung cấp";
                    flag = true;
                    break;
                case "2":
                    levelEmployee = "Cao đẳng";
                    flag = true;
                    break;
                case "3":
                    levelEmployee = "Đại học";
                    flag = true;
                    break;
                case "4":
                    levelEmployee = "Sau đại học";
                    flag = true;
                    break;
                default:
                    System.out.println("Chọn sai trình độ mời nhập lại! ");
                    break;
            }
        } while (!flag);

        String locationEmployee = "";
        do {
            System.out.print("1. Lễ tân\n" +
                    "2. Phục vụ\n" +
                    "3. Chuyên viên\n" +
                    "4. Giám sát\n" +
                    "5. Quản lý\n" +
                    "6. Giám đốc\n" +
                    "Chọn vị trí làm việc của nhân viên: ");
            String chose = scanner.nextLine();
            switch (chose) {
                case "1":
                    locationEmployee = "Lễ tân";
                    flag = true;
                    break;
                case "2":
                    locationEmployee = "Phục vụ";
                    flag = true;
                    break;
                case "3":
                    locationEmployee = "Chuyên viên";
                    flag = true;
                    break;
                case "4":
                    locationEmployee = "Giám sát";
                    flag = true;
                    break;
                case "5":
                    locationEmployee = "Quản lý";
                    flag = true;
                    break;
                case "6":
                    locationEmployee = "Giám đốc";
                    flag = true;
                    break;
                default:
                    System.out.println("Chọn sai vị trí nhân viên mời nhập lại!");
                    break;
            }
        } while (!flag);

        double wageEmployee = 0;
        do {
            try {
                System.out.print("Nhập lương nhân viên :");
                wageEmployee = Double.parseDouble(scanner.nextLine());
                if (wageEmployee <= 0) {
                    System.out.println("Lương nhân viên phải lớn hơn 0");
                }
            } catch (NumberFormatException e) {
                System.out.println("Lương Nhân viên phải là số ");
            }

        } while (wageEmployee <= 0);
        //String id, String name, String date, String gender, String code, String telephone, String email, String level, double wage
        Employee employee = new Employee(idEmployee, nameEmployee, dateEmployee, genderEmployee, codeEmployee, telephoneEmployee,
                emailEmployee, levelEmployee, locationEmployee, wageEmployee);
        employeeRepository.addEmployee(employee);
        System.out.println("Thêm mới nhân viên thành công! ");
    }

    @Override
    public void setEmployee() {
        List<Employee> employeeList = employeeRepository.displayEmployee();
        System.out.println("+---------------+--------------------+----------------+-------------+--------------------+----------------+" +
                "--------------------+--------------------+-------------+------------+");
        System.out.println("| Mã nhân viên  | Tên nhân viên      | Ngày sinh      | Giới tính   | Căn cước công dân  | Số điện thoại  |" +
                " Email              | Trình độ           | Vị Trí      | Lương      |");
        for (Employee e : employeeList) {
            System.out.println("+---------------+--------------------+----------------+-------------+--------------------+----------------+" +
                    "--------------------+--------------------+-------------+------------+");
            System.out.printf("|%-15s|%-20s|%-16s|%-13s|%-20s|%-16s|%-20s|%-20s|%-13s|%-12s|\n",
                    e.getId(), e.getName(), e.getDate(), e.getGender(), e.getCode(), e.getTelephone(),
                    e.getEmail(), e.getLevel(), e.getLocation(), e.getWage());
        }
        System.out.println("+---------------+--------------------+----------------+-------------+--------------------+----------------+" +
                "--------------------+--------------------+-------------+------------+");
        System.out.print("Nhập id nhân viên cần sửa: ");
        String idEmployee = scanner.nextLine();
        boolean checkid = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (idEmployee.equals(employeeList.get(i).getId())) {
                boolean flag = false;
                checkid = true;
                do {
                    System.out.print("1. Tên nhân viên.\n" +
                            "2. Ngày sinh nhân viên\n" +
                            "3. Giới tính nhân viên\n" +
                            "4. Căn cước công dân\n" +
                            "5. Số điện thoại nhân viên\n" +
                            "6. Email nhân viên\n" +
                            "7. Trình độ học vấn nhân viên\n" +
                            "8. Vị trí nhân viên\n" +
                            "9. Lương nhân viên\n" +
                            "10. Thoát sửa nhân viên\n" +
                            "Nhập thuộc tính muốn sửa: ");
                    String chose = scanner.nextLine();
                    switch (chose) {
                        case "1":
                            String nameEmployee = "";
                            do {
                                System.out.print("Nhập lại tên nhân viên muốn sửa theo định dạng viết hoa chứ đầu: ");
                                nameEmployee = scanner.nextLine();
                                if (!CustomerRegex.checkRegexNameCustomer(nameEmployee)) {
                                    System.out.println("Nhập sai định dạng tên! ");
                                }
                            } while (!CustomerRegex.checkRegexNameCustomer(nameEmployee));
                            Employee employee = new Employee(idEmployee, nameEmployee, employeeList.get(i).getDate(),
                                    employeeList.get(i).getGender(), employeeList.get(i).getCode(),
                                    employeeList.get(i).getTelephone(), employeeList.get(i).getEmail(),
                                    employeeList.get(i).getLevel(), employeeList.get(i).getLocation(),
                                    employeeList.get(i).getWage());
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("sửa tên thành công! ");
                            break;
                        case "2":
                            String dateEmployee = "";
                            do {
                                System.out.print("Nhập năm sinh nhân viên theo đúng định dạng YYYY-MM-DD: ");
                                dateEmployee = scanner.nextLine();
                                if (!EmployeeRegex.checkOld(dateEmployee)) {
                                    System.out.println("nhập sai định dạng mời nhập lại! ");
                                } else {
                                    if (!EmployeeRegex.checkRegexOldEmployee(dateEmployee)) {
                                        System.out.println("Tuổi chưa đủ mời nhập lại! ");
                                    }
                                }
                            } while (!EmployeeRegex.checkRegexOldEmployee(dateEmployee));
                            employee = new Employee(idEmployee, employeeList.get(i).getName(),
                                    dateEmployee, employeeList.get(i).getGender(), employeeList.get(i).getCode(),
                                    employeeList.get(i).getTelephone(), employeeList.get(i).getEmail(),
                                    employeeList.get(i).getLevel(), employeeList.get(i).getLocation(),
                                    employeeList.get(i).getWage());
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("Sửa ngày sinh thành công! ");
                            break;
                        case "3":
                            boolean choce = false;
                            String genderEmployee = "";
                            do {
                                System.out.print("1. nam\n" +
                                        "2. nữ\n" +
                                        "mời chọn giới tính: ");
                                String check = scanner.nextLine();
                                switch (check) {
                                    case "1":
                                        genderEmployee = "nam";
                                        choce = true;
                                        break;
                                    case "2":
                                        genderEmployee = "nữ";
                                        choce = true;
                                        break;
                                    default:
                                        System.out.println("nhập sai mời chọn lại giới tính! ");
                                        break;
                                }
                            } while (!choce);
                            employee = new Employee(idEmployee, employeeList.get(i).getName(),
                                    employeeList.get(i).getDate(), genderEmployee, employeeList.get(i).getCode(),
                                    employeeList.get(i).getTelephone(), employeeList.get(i).getEmail(),
                                    employeeList.get(i).getLevel(), employeeList.get(i).getLocation(),
                                    employeeList.get(i).getWage());
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("Sửa giới tính thành công! ");
                            break;
                        case "4":
                            String codeEmployee = "";
                            do {
                                System.out.print("Nhập Căn cước công dân muốn sửa 9 số hoặc 12 số: ");
                                codeEmployee = scanner.nextLine();
                                if (!EmployeeRegex.checkRegexCodeEmployee(codeEmployee)) {
                                    System.out.println("Nhập sai định dạng căn cước công dân nhập lại !");
                                }
                            } while (!EmployeeRegex.checkRegexCodeEmployee(codeEmployee));
                            employee = new Employee(idEmployee, employeeList.get(i).getName(),
                                    employeeList.get(i).getDate(), employeeList.get(i).getGender(), codeEmployee,
                                    employeeList.get(i).getTelephone(), employeeList.get(i).getEmail(),
                                    employeeList.get(i).getLevel(), employeeList.get(i).getLocation(),
                                    employeeList.get(i).getWage());
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("Sửa Căn cước công dân thành công! ");
                            break;
                        case "5":
                            String telephoneEmployee = "";
                            do {
                                System.out.print("Nhập số điện thoạt cần sửa bắt đầu từ 0 và đủ 10 số: ");
                                telephoneEmployee = scanner.nextLine();
                                if (!EmployeeRegex.checkRegexTelephoneEmployee(telephoneEmployee)) {
                                    System.out.println("Nhập sai định dạng số điện thoại mời nhập lại! ");
                                }
                            } while (!EmployeeRegex.checkRegexTelephoneEmployee(telephoneEmployee));
                            employee = new Employee(idEmployee, employeeList.get(i).getName(),
                                    employeeList.get(i).getDate(), employeeList.get(i).getGender(),
                                    employeeList.get(i).getCode(), telephoneEmployee, employeeList.get(i).getEmail(),
                                    employeeList.get(i).getLevel(), employeeList.get(i).getLocation(),
                                    employeeList.get(i).getWage());
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("Sửa số điện thoại thành công! ");
                            break;
                        case "6":
                            String emailEmployee = "";
                            do {
                                System.out.print("Nhập lại email nhân viên theo dúng định dạng username@domain.extension: ");
                                emailEmployee = scanner.nextLine();
                                if (!EmployeeRegex.checkRegexEmailEmployee(emailEmployee)) {
                                    System.out.println("Nhập sai định dạng mời nhập lại! ");
                                }
                            } while (!EmployeeRegex.checkRegexEmailEmployee(emailEmployee));
                            employee = new Employee(idEmployee, employeeList.get(i).getName(),
                                    employeeList.get(i).getDate(), employeeList.get(i).getGender(),
                                    employeeList.get(i).getCode(), employeeList.get(i).getTelephone(), emailEmployee,
                                    employeeList.get(i).getLevel(), employeeList.get(i).getLocation(),
                                    employeeList.get(i).getWage());
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("Sửa email nhân viên thành công! ");
                            break;
                        case "7":
                            String levelEmployee = "";
                            boolean flagLevel = false;
                            do {
                                System.out.print("1. Trung cấp\n" +
                                        "2. Cao đẳng \n" +
                                        "3. Đại học\n" +
                                        "4, Sau đại học\n" +
                                        "Chọn trình độ muốn sửa nhân viên: ");
                                chose = scanner.nextLine();
                                switch (chose) {
                                    case "1":
                                        levelEmployee = "Trung cấp";
                                        flagLevel = true;
                                        break;
                                    case "2":
                                        levelEmployee = "Cao đẳng";
                                        flagLevel = true;
                                        break;
                                    case "3":
                                        levelEmployee = "Đại học";
                                        flagLevel = true;
                                        break;
                                    case "4":
                                        levelEmployee = "Sau đại học";
                                        flagLevel = true;
                                        break;
                                    default:
                                        System.out.println("Chọn sai trình độ mời nhập lại! ");
                                        break;
                                }
                            } while (!flagLevel);
                            employee = new Employee(idEmployee, employeeList.get(i).getName(),
                                    employeeList.get(i).getDate(), employeeList.get(i).getGender(),
                                    employeeList.get(i).getCode(), employeeList.get(i).getTelephone(),
                                    employeeList.get(i).getEmail(), levelEmployee, employeeList.get(i).getLocation(),
                                    employeeList.get(i).getWage());
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("Sửa trình độ nhân viên thành công! ");
                            break;
                        case "8":
                            String locationEmployee = "";
                            boolean flagLocation = false;
                            do {
                                System.out.print("1. Lễ tân\n" +
                                        "2. Phục vụ\n" +
                                        "3. Chuyên viên\n" +
                                        "4. Giám sát\n" +
                                        "5. Quản lý\n" +
                                        "6. Giám đốc\n" +
                                        "Chọn vị trí làm việc muốn sửa của nhân viên: ");
                                chose = scanner.nextLine();
                                switch (chose) {
                                    case "1":
                                        locationEmployee = "Lễ tân";
                                        flagLocation = true;
                                        break;
                                    case "2":
                                        locationEmployee = "Phục vụ";
                                        flagLocation = true;
                                        break;
                                    case "3":
                                        locationEmployee = "Chuyên viên";
                                        flagLocation = true;
                                        break;
                                    case "4":
                                        locationEmployee = "Giám sát";
                                        flagLocation = true;
                                        break;
                                    case "5":
                                        locationEmployee = "Quản lý";
                                        flagLocation = true;
                                        break;
                                    case "6":
                                        locationEmployee = "Giám đốc";
                                        flagLocation = true;
                                        break;
                                    default:
                                        System.out.println("Chọn sai vị trí nhân viên mời nhập lại!");
                                        break;
                                }
                            } while (!flagLocation);
                            employee = new Employee(idEmployee, employeeList.get(i).getName(),
                                    employeeList.get(i).getDate(), employeeList.get(i).getGender(),
                                    employeeList.get(i).getCode(), employeeList.get(i).getTelephone(),
                                    employeeList.get(i).getEmail(), employeeList.get(i).getLevel(), locationEmployee,
                                    employeeList.get(i).getWage());
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("Sửa vị trí nhân viên thành công! ");
                            break;
                        case "9":
                            double wageEmployee = 0;
                            do {
                                try {
                                    System.out.print("Nhập lương nhân viên muốn thay đổi:");
                                    wageEmployee = Double.parseDouble(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Lương Nhân viên phải là số ");
                                }
                                if (wageEmployee <= 0) {
                                    System.out.println("Lương nhân viên phải lớn hơn 0");
                                }

                            } while (wageEmployee <= 0);
                            employee = new Employee(idEmployee, employeeList.get(i).getName(),
                                    employeeList.get(i).getDate(), employeeList.get(i).getGender(),
                                    employeeList.get(i).getCode(), employeeList.get(i).getTelephone(),
                                    employeeList.get(i).getEmail(), employeeList.get(i).getLevel(),
                                    employeeList.get(i).getLocation(), wageEmployee);
                            employeeRepository.editEmployee(i, employee);
                            System.out.println("Sửa lương nhân viên thành công! ");
                            break;
                        case "10":
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
                            break;
                        default:
                            System.out.println("Chọn sai chức năng mời chọn lại thuộc tính muốn sửa! ");
                            break;
                    }
                } while (!flag);
            }
        }
        if (!checkid) {
            System.out.println("ko có id bạn muốn xoá. ");
        }
    }
}
