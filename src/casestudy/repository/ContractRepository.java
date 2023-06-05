package casestudy.repository;

import casestudy.model.Booking;
import casestudy.model.Contract;

import java.util.*;

public class ContractRepository implements IContractRepository {
    private static final  BooKingRepository bookingRepository = new BooKingRepository();
    private static final Queue<Booking> bookingQueue = new LinkedList<>();
    private static final List<Contract> contractQueue = new ArrayList<>();

    static {
        Set<Booking> bookingSet = bookingRepository.displayBooing();
        List<Booking> bookingList = new ArrayList<>();
        for (Booking b : bookingSet) {
            bookingList.add(b);
        }
        Collections.sort(bookingList, new BookingComparable());
        for (Booking b : bookingList) {
            bookingQueue.add(b);
        }
    }

    @Override
    public List<Contract> displayContact() {
        return contractQueue;
    }

    @Override
    public void addContract(Contract contract) {
        contractQueue.add(contract);
    }

    @Override
    public Queue<Booking> displayBooking() {
        return bookingQueue;
    }

    @Override
    public void editContract(int numberContract, Contract contract) {
        for (int i = 0; i < contractQueue.size(); i++) {
            if (numberContract == contractQueue.get(i).getNumberContact()) {
                contractQueue.set(i, contract);
            }
        }
    }
}
