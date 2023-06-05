package casestudy.model;

public class Booking implements Comparable<Booking> {
    private String idBooking;
    private String dateBooking;
    private String dayStartRental;
    private String dayEndRental;
    private String idCustomer;
    private String idService;

    public Booking() {

    }

    public Booking(String idBooking, String dateBooking, String dayStartRental, String dayEndRental, String idCustomer, String idService) {
        this.idBooking = idBooking;
        this.dateBooking = dateBooking;
        this.dayStartRental = dayStartRental;
        this.dayEndRental = dayEndRental;
        this.idCustomer = idCustomer;
        this.idService = idService;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public String getDateBooking() {
        return dateBooking;
    }

    public void setDateBooking(String dateBooking) {
        this.dateBooking = dateBooking;
    }

    public String getDayStartRental() {
        return dayStartRental;
    }

    public void setDayStartRental(String dayStartRental) {
        this.dayStartRental = dayStartRental;
    }

    public String getDayEndRental() {
        return dayEndRental;
    }

    public void setDayEndRental(String dayEndRental) {
        this.dayEndRental = dayEndRental;
    }

    public String getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking='" + idBooking + '\'' +
                ", dateBooking='" + dateBooking + '\'' +
                ", dayStartRental='" + dayStartRental + '\'' +
                ", dayEndRental='" + dayEndRental + '\'' +
                ", idCustomer='" + idCustomer + '\'' +
                ", idService='" + idService + '\'' +
                '}';
    }

    @Override
    public int compareTo(Booking o) {
        if (this.dayStartRental.equals(o.dayStartRental)) {
            return this.getDayEndRental().compareTo(o.getDayEndRental());
        }
        return this.getDayStartRental().compareTo(o.getDayStartRental());
    }
}
