package ss10.bai2.model;

public class Car extends Transportation{
    private int numberOfSeats;
    private String typeCar;

    public Car() {

    }


    public Car(String seaOfControl, String nameCompany, String yearOfManufacture, String owner, int numberOfSeats, String typeCar) {
        super(seaOfControl, nameCompany, yearOfManufacture, owner);
        this.numberOfSeats = numberOfSeats;
        this.typeCar = typeCar;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getTypeCar() {
        return typeCar;
    }

    public void setTypeCar(String typeCar) {
        this.typeCar = typeCar;
    }

    @Override
    public String toString() {
        return "Car{" +
                super.toString() +
                "numberOfSeats=" + numberOfSeats +
                ", typeCar='" + typeCar + '\'' +
                '}';
    }
}
