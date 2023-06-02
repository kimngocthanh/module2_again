package casestudy.repository;

import casestudy.common.ReadAndWriteFacility;
import casestudy.model.Facility;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class FacilityRepository implements IFacilityRepository {
    private static final String PATH_FACILITY = "src/casestudy/data/facility.csv";

    @Override
    public Map<Facility, Integer> displayFacility() {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        return facilityIntegerMap;
    }

    @Override
    public void addRoom(Facility room, int index) {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        facilityIntegerMap.put(room, 5);
        ReadAndWriteFacility.writeToFileFacility(PATH_FACILITY, facilityIntegerMap);
    }

    @Override
    public void addVilla(Facility villa, int index) {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        facilityIntegerMap.put(villa, 0);
        ReadAndWriteFacility.writeToFileFacility(PATH_FACILITY, facilityIntegerMap);
    }

    @Override
    public void addHouse(Facility house, int index) {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        facilityIntegerMap.put(house, 0);
        ReadAndWriteFacility.writeToFileFacility(PATH_FACILITY, facilityIntegerMap);
    }

    @Override
    public void removeFacility(String id) {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility f : facilitySet) {
            if (id.equals(f.getIdService())) {
                facilityIntegerMap.remove(f);
            }
        }
        ReadAndWriteFacility.writeToFileFacility(PATH_FACILITY, facilityIntegerMap);
    }

    @Override
    public Map<Facility, Integer> displayFacilityMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        Map<Facility, Integer> facilityIntegerMapMaintenance = new LinkedHashMap<>();
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility f : facilitySet) {
            if (facilityIntegerMap.get(f) >= 5) {
                facilityIntegerMapMaintenance.put(f, facilityIntegerMap.get(f));
            }
        }
        return facilityIntegerMapMaintenance;

    }


}
