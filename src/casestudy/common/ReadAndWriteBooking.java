package casestudy.common;

import casestudy.model.Booking;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

public class ReadAndWriteBooking {
    public static void writeToFile(String path, Set<Booking> treeSet) {
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Booking b : treeSet) {
                bufferedWriter.write(b.getIdBooking() + "," + b.getDateBooking() + "," + b.getDayStartRental() + ","
                        + b.getDayEndRental() + "," + b.getIdCustomer() + "," + b.getIdService());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeSet<Booking> readToFile(String path) {
        TreeSet<Booking> bookingSet = new TreeSet<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] arr = line.split(",");
                Booking booking = new Booking(arr[0], arr[1], arr[2], arr[3],arr[4],arr[5]);
                bookingSet.add(booking);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }return bookingSet;
    }
}
