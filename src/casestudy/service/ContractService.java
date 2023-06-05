package casestudy.service;

import casestudy.model.Contract;
import casestudy.repository.ContractRepository;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ContractService implements IContractService {
    private final ContractRepository contactRepository = new ContractRepository();

    private List<Contract> contractQueue = contactRepository.displayContact();

    Scanner scanner = new Scanner(System.in);

    @Override
    public void displayContract() {
        contractQueue = contactRepository.displayContact();
        System.out.println(contractQueue);
    }

    @Override
    public void addContract() {
        contractQueue = contactRepository.displayContact();
        if (Objects.requireNonNull(contactRepository.displayBooking().peek()).getIdService().contains("RO")) {
            System.out.println("không tạo hợp đồng cho Room!");
            contactRepository.displayBooking().remove();
        } else {
            System.out.print("nhập số hợp đồng: ");
            int numberContract = Integer.parseInt(scanner.nextLine());
            System.out.print("nhập số tiền cọc trước: ");
            int depositAmount = Integer.parseInt(scanner.nextLine());
            System.out.print("nhập số tiền tổng: ");
            int totalPayment = Integer.parseInt(scanner.nextLine());
            Contract contract = new Contract(numberContract, Objects.requireNonNull(contactRepository.displayBooking().poll()).getIdBooking(), depositAmount, totalPayment);
            contactRepository.addContract(contract);
            System.out.println("add thành công!");
        }
    }

    @Override
    public void editContract() {
        System.out.print("nhập số hợp đồng muốn edit: ");
        int numberContract = Integer.parseInt(scanner.nextLine());
        boolean flag = true;
        for (Contract value : contractQueue) {
            if (numberContract == value.getNumberContact()) {
                do {
                    System.out.print("1. nhập số tiền cọc muốn sửa\n" +
                            "2. nhập số tiền tổng muốn sửa\n" +
                            "3. thoát" +
                            "nhập trường muốn sửa: ");
                    String chose = scanner.nextLine();
                    switch (chose) {
                        case "1":
                            System.out.print("nhập số tiền cọc trước: ");
                            int depositAmount = Integer.parseInt(scanner.nextLine());
                            Contract contract = new Contract(value.getNumberContact(), value.getIdBooking(), depositAmount, value.getTotalPayment());
                            contactRepository.editContract(numberContract, contract);
                            break;
                        case "2":
                            System.out.print("nhập tiền tổng: ");
                            int totalPayment = Integer.parseInt(scanner.nextLine());
                            contract = new Contract(value.getNumberContact(), value.getIdBooking(), value.getDepositAmount(), totalPayment);
                            contactRepository.editContract(numberContract, contract);
                        case "3":
                            flag = false;
                            break;
                    }
                } while (flag);
            }
        }

    }
}


