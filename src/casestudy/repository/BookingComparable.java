package casestudy.repository;

import casestudy.model.Booking;

import java.util.Comparator;

public class BookingComparable implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getDateBooking().compareTo(o2.getDateBooking());
    }
}
