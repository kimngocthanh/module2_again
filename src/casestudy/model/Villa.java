package casestudy.model;

public class Villa extends Facility {
    private String roomStandardVilla;
    private double areaPool;
    private int numberFloors;

    public Villa(){

    }

    public Villa(String idService, String nameService, double area, double rentalCosts, int numberPerson,
                 String typeRental, String roomStandard, double areaPool, int numberFloors) {
        super(idService, nameService, area, rentalCosts, numberPerson, typeRental);
        this.roomStandardVilla = roomStandard;
        this.areaPool = areaPool;
        this.numberFloors = numberFloors;
    }

    public String getRoomStandardVilla() {
        return roomStandardVilla;
    }

    public void setRoomStandardVilla(String roomStandardVilla) {
        this.roomStandardVilla = roomStandardVilla;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumberFloors() {
        return numberFloors;
    }

    public void setNumberFloors(int numberFloors) {
        this.numberFloors = numberFloors;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString()+
                "roomStandardVilla='" + roomStandardVilla + '\'' +
                ", areaPool=" + areaPool +
                ", numberFloors=" + numberFloors +
                '}';
    }
}
