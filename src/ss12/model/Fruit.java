package ss12.model;

public class Fruit {
    private String idFruit;
    private String nameFruit;
    private String typeFruit;
    private String dateOfManufacture;
    private String expiry;
    private String origin;
    private double price;

    public Fruit(){

    }

    public Fruit(String idFruit, String nameFruit, String typeFruit, String dateOfManufacture, String expiry, String origin, double price) {
        this.idFruit = idFruit;
        this.nameFruit = nameFruit;
        this.typeFruit = typeFruit;
        this.dateOfManufacture = dateOfManufacture;
        this.expiry = expiry;
        this.origin = origin;
        this.price = price;
    }

    public String getIdFruit() {
        return idFruit;
    }

    public void setIdFruit(String idFruit) {
        this.idFruit = idFruit;
    }

    public String getNameFruit() {
        return nameFruit;
    }

    public void setNameFruit(String nameFruit) {
        this.nameFruit = nameFruit;
    }

    public String getTypeFruit() {
        return typeFruit;
    }

    public void setTypeFruit(String typeFruit) {
        this.typeFruit = typeFruit;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "idFruit='" + idFruit + '\'' +
                ", nameFruit='" + nameFruit + '\'' +
                ", typeFruit='" + typeFruit + '\'' +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                ", expiry='" + expiry + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price ;
    }
}
