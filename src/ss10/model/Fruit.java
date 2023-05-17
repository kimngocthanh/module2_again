package ss10.model;

public class Fruit {
    private String nameFruit;
    private String typeFruit;
    private String dateOfManufacture;
    private String expiry;
    private String origin;
    private double price;

    public Fruit(){

    }

    public Fruit(String nameFruit, String typeFruit, String dateOfManufacture, String expiry, String origin, double price) {
        this.nameFruit = nameFruit;
        this.typeFruit = typeFruit;
        this.dateOfManufacture = dateOfManufacture;
        this.expiry = expiry;
        this.origin = origin;
        this.price = price;
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
        return "Fruit{" +
                "nameFruit='" + nameFruit + '\'' +
                ", typeFruit='" + typeFruit + '\'' +
                ", dateOfManufacture='" + dateOfManufacture + '\'' +
                ", expiry='" + expiry + '\'' +
                ", origin='" + origin + '\'' +
                ", price=" + price +
                '}';
    }
}
