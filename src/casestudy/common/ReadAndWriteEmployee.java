package casestudy.common;

import casestudy.model.Customer;
import casestudy.model.Employee;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployee {
    public static void writeToFileEmployee(String Path, List<Employee> employeeList) {
        File file = new File(Path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee c : employeeList) {
                bufferedWriter.write(c.getId() + "," + c.getName() + "," + c.getDate() + "," + c.getGender() + "," +
                        c.getCode() + "," + c.getTelephone() + "," + c.getEmail() + "," + c.getLevel() + "," +
                        c.getLocation() + "," + c.getWage());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readToFileEmployee(String Path) {
        List<Employee> employeeList = new ArrayList<>();
        File file = new File(Path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null && !line.equals("")) {
                String[] arr = line.split(",");
                Employee employee = new Employee(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8],
                        Double.parseDouble(arr[9]));
                employeeList.add(employee);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
