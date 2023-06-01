package casestudy.model;

public class House extends Facility {
    private String roomStandardHouse;
    private int numberFloors;

    public House(){

    }

    public House(String idService, String nameService, double area, double rentalCosts, int numberPerson,
                 String typeRental, String roomStandardHouse, int numberFloors) {
        super(idService, nameService, area, rentalCosts, numberPerson, typeRental);
        this.roomStandardHouse = roomStandardHouse;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandardHouse() {
        return roomStandardHouse;
    }

    public void setRoomStandardHouse(String roomStandardHouse) {
        this.roomStandardHouse = roomStandardHouse;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString()+
                "roomStandardHouse='" + roomStandardHouse + '\'' +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
