package casestudy.repository;

import casestudy.common.ReadAndWriteFacility;
import casestudy.model.Facility;

import java.util.Map;

public class FacilityRepository implements IFacilityRepository {
    private static final String PATH_FACILITY = "src/casestudy/data/facility.csv";

    @Override
    public Map<Facility, Integer> displayFacility() {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        return facilityIntegerMap;
    }

    @Override
    public void addRoom(Facility room,int index) {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        facilityIntegerMap.put(room,0);
        ReadAndWriteFacility.writeToFileFacility(PATH_FACILITY,facilityIntegerMap);
    }

    @Override
    public void addVilla(Facility villa, int index) {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        facilityIntegerMap.put(villa,0);
        ReadAndWriteFacility.writeToFileFacility(PATH_FACILITY,facilityIntegerMap);
    }

    @Override
    public void addHouse(Facility house, int index) {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        facilityIntegerMap.put(house,0);
        ReadAndWriteFacility.writeToFileFacility(PATH_FACILITY,facilityIntegerMap);
    }

    @Override
    public void removeFacility(Facility facility) {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteFacility.readToFileFacility(PATH_FACILITY);
        facilityIntegerMap.remove(facility);
        ReadAndWriteFacility.writeToFileFacility(PATH_FACILITY,facilityIntegerMap);
    }


}
