package casestudy.model;

public class Room extends FuramaResort {
    private String freeService;

    public Room() {

    }

    public Room(String idService, String nameService, String area, double rentalCosts, int numberPerson,
                String typeRental, String freeService) {
        super(idService, nameService, area, rentalCosts, numberPerson, typeRental);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString() +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
