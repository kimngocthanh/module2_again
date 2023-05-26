package ss16.model;

public class Expense {
    private String id;
    private String name;
    private String date;
    private double price;
    private String describe;

    public Expense() {

    }

    public Expense(String id, String name, String date, double price, String describe) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.price = price;
        this.describe = describe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", price=" + price +
                ", describe='" + describe + '\'' +
                '}';
    }

    public String readAndWriteToFile() {
        return id + "," + name + "," + date + "," + price + "," + describe;
    }
}