package casestudy.repository;

import casestudy.model.Facility;

import java.util.Map;

public interface IFacilityRepository {
    Map<Facility, Integer> displayFacility();

    void addRoom(Facility room, int integer);

    void addVilla(Facility villa, int integer);

    void addHouse(Facility house, int integer);

    void removeFacility(Facility facility);
}
