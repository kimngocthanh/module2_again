package ss10.bai2.model;

public class Truck extends Transportation{
    private String tonnage;

    public Truck() {

    }

    public Truck(String seaOfControl, String nameCompany, String yearOfManufacture, String owner, String tonnage) {
        super(seaOfControl, nameCompany, yearOfManufacture, owner);
        this.tonnage = tonnage;
    }

    public String getTonnage() {
        return tonnage;
    }

    public void setTonnage(String tonnage) {
        this.tonnage = tonnage;
    }

    @Override
    public String toString() {
        return "Truck{" +
                super.toString()+
                "tonnage='" + tonnage + '\'' +
                '}';
    }
}
