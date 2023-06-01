package casestudy.common;

import casestudy.model.Facility;
import casestudy.model.House;
import casestudy.model.Room;
import casestudy.model.Villa;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteFacility {
    public static void writeToFileFacility(String path, Map<Facility, Integer> facilityIntegerMap) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            Set<Facility> facilitySet = facilityIntegerMap.keySet();
            for (Facility f : facilitySet) {
                //String idService, String nameService, String area, double rentalCosts, int numberPerson,
                //                String typeRental, String freeService
                if (f instanceof Room) {
                    bufferedWriter.write(f.getIdService() + "," + f.getNameService() + "," + f.getArea() + "," +
                            f.getRentalCosts() + "," + f.getNumberPerson() + "," + f.getTypeRental() + ","
                            + ((Room) f).getFreeService());
                    bufferedWriter.newLine();
                } else if (f instanceof House) {
                    //String idService, String nameService, String area, double rentalCosts, int numberPerson,
                    // String typeRental, String roomStandardHouse, int numberFloors
                    bufferedWriter.write(f.getIdService() + "," + f.getNameService() + "," + f.getArea() + "," +
                            f.getRentalCosts() + "," + f.getNumberPerson() + "," + f.getTypeRental() + "," +
                            ((House) f).getRoomStandardHouse() + "," + ((House) f).getNumberFloors());
                    bufferedWriter.newLine();
                } else {
                    //String idService, String nameService, String area, double rentalCosts, int numberPerson,
                    //                 String typeRental, String roomStandard, double areaPool, int numberFloors
                    bufferedWriter.write(f.getIdService() + "," + f.getNameService() + "," + f.getArea() + "," +
                            f.getRentalCosts() + "," + f.getNumberPerson() + "," + f.getTypeRental() + "," +
                            ((Villa) f).getRoomStandardVilla() + "," + ((Villa) f).getAreaPool() + "," +
                            ((Villa) f).getNumberFloors());
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Facility, Integer> readToFileFacility(String path) {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            Set<Facility> facilitySet = facilityIntegerMap.keySet();
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] arr = line.split(",");
                if(arr[0].contains("RO")){
                    Room room = new Room(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Integer.parseInt(arr[4]), arr[5], arr[6]);
                    facilityIntegerMap.put(room, 0);
                }
                else if( arr[0].contains("VI")){
                    Villa villa = new Villa(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Integer.parseInt(arr[4]), arr[5], arr[6], Double.parseDouble(arr[7]),
                            Integer.parseInt(arr[8]));
                    facilityIntegerMap.put(villa, 0);
                }
                else {
                    House house = new House(arr[0], arr[1], Double.parseDouble(arr[2]), Double.parseDouble(arr[3]),
                            Integer.parseInt(arr[4]), arr[5], arr[6], Integer.parseInt(arr[7]));
                    facilityIntegerMap.put(house, 0);
                }
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return facilityIntegerMap;
    }
}
