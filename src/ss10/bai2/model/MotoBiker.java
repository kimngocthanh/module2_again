package ss10.bai2.model;

public class MotoBiker extends Transportation {
    private String wattage;

    public MotoBiker() {

    }

    public MotoBiker(String seaOfControl, String nameCompany, String yearOfManufacture, String owner, String wattage) {
        super(seaOfControl, nameCompany, yearOfManufacture, owner);
        this.wattage = wattage;
    }

    public String getWattage() {
        return wattage;
    }

    public void setWattage(String wattage) {
        this.wattage = wattage;
    }

    @Override
    public String toString() {
        return "MotoBiker{" +
                super.toString() +
                "wattage='" + wattage + '\'' +
                '}';
    }
}
