package casestudy.repository;

import casestudy.common.ReadAndWriteBooking;
import casestudy.model.Booking;

import java.util.TreeSet;

public class BooKingRepository implements IBookingRepository {
    private static final String PATH_BOOKING = "src/casestudy/data/booking.csv";

    @Override
    public TreeSet<Booking> displayBooing() {
        TreeSet<Booking> bookingSet = ReadAndWriteBooking.readToFile(PATH_BOOKING);
        return bookingSet;
    }

    @Override
    public void addBooking(Booking booking) {
        TreeSet<Booking> bookingSet = ReadAndWriteBooking.readToFile(PATH_BOOKING);
        bookingSet.add(booking);
        ReadAndWriteBooking.writeToFile(PATH_BOOKING, bookingSet);
    }
}
