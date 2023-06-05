package casestudy.repository;

import casestudy.model.Booking;
import casestudy.model.Contract;

import java.util.List;
import java.util.Queue;

public interface IContractRepository {
    List<Contract> displayContact();

    void addContract(Contract contract);

    Queue<Booking> displayBooking();

    void editContract(int numberContract, Contract contract);
}
