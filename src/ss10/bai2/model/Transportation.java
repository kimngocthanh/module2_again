package ss10.bai2.model;

public abstract class Transportation {
    private String seaOfControl;
    private String nameCompany;
    private String yearOfManufacture;
    private String owner;

    public Transportation(){

    }

    public Transportation(String seaOfControl, String nameCompany, String yearOfManufacture, String owner) {
        this.seaOfControl = seaOfControl;
        this.nameCompany = nameCompany;
        this.yearOfManufacture = yearOfManufacture;
        this.owner = owner;
    }

    public String getSeaOfControl() {
        return seaOfControl;
    }

    public void setSeaOfControl(String seaOfControl) {
        this.seaOfControl = seaOfControl;
    }

    public String getNameCompany() {
        return nameCompany;
    }

    public void setNameCompany(String nameCompany) {
        this.nameCompany = nameCompany;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Transportation{" +
                "seaOfControl='" + seaOfControl + '\'' +
                ", nameCompany='" + nameCompany + '\'' +
                ", yearOfManufacture='" + yearOfManufacture + '\'' +
                ", owner='" + owner + '\'' +
                '}';
    }
}
