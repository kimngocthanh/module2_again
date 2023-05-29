package casestudy.common;

import casestudy.model.Customer;
import casestudy.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCustomer {
    public static void writeToFile(String Path, List<Customer> customerList){
        File file = new File(Path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer c: customerList) {
                bufferedWriter.write(c.writeAndReadCustomer());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readToFile(String Path){
        List<Customer> customerList = new ArrayList<>();
        File file = new File(Path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line=bufferedReader.readLine()) != null && !line.equals("")){
                String[] arr = line.split(",");
                Customer customer = new Customer(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8]);
                customerList.add(customer);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
