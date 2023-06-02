package casestudy.repository;

import casestudy.model.Booking;

import java.util.TreeSet;

public interface IBookingRepository {
    TreeSet<Booking> displayBooing();

    void addBooking(Booking booking);
}
