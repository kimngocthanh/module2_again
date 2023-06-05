package casestudy.model;

public class Contract {
    private int numberContact;
    private String idBooking;
    private double depositAmount;
    private double totalPayment;

    public Contract(){

    }

    public Contract(int numberContact, String idBooking, double depositAmount, double totalPayment) {
        this.numberContact = numberContact;
        this.idBooking = idBooking;
        this.depositAmount = depositAmount;
        this.totalPayment = totalPayment;
    }

    public int getNumberContact() {
        return numberContact;
    }

    public void setNumberContact(int numberContact) {
        this.numberContact = numberContact;
    }

    public String getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(String idBooking) {
        this.idBooking = idBooking;
    }

    public double getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(double depositAmount) {
        this.depositAmount = depositAmount;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "numberContact=" + numberContact +
                ", idBooking='" + idBooking + '\'' +
                ", depositAmount=" + depositAmount +
                ", totalPayment=" + totalPayment +
                '}';
    }
}
