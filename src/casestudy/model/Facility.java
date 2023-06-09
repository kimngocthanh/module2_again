package casestudy.model;

public abstract class Facility {
    private String idService;
    private String nameService;
    private double area;
    private double rentalCosts;
    private int numberPerson;
    private String typeRental;

    public Facility() {

    }

    public Facility(String idService, String nameService, double area, double rentalCosts, int numberPerson, String typeRental) {
        this.idService = idService;
        this.nameService = nameService;
        this.area = area;
        this.rentalCosts = rentalCosts;
        this.numberPerson = numberPerson;
        this.typeRental = typeRental;
    }

    public String getIdService() {
        return idService;
    }

    public void setIdService(String idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getRentalCosts() {
        return rentalCosts;
    }

    public void setRentalCosts(double rentalCosts) {
        this.rentalCosts = rentalCosts;
    }

    public int getNumberPerson() {
        return numberPerson;
    }

    public void setNumberPerson(int numberPerson) {
        this.numberPerson = numberPerson;
    }

    public String getTypeRental() {
        return typeRental;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    @Override
    public String toString() {
        return "idService='" + idService + '\'' +
                ", nameService='" + nameService + '\'' +
                ", area='" + area + '\'' +
                ", rentalCosts=" + rentalCosts +
                ", numberPerson=" + numberPerson +
                ", typeRental='" + typeRental + '\'' +
                '}';
    }
}
