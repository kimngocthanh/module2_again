package ss16.common;

import ss16.model.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Common {
    public static void writeToFile(String path, List<Expense> expenseList){
        File file = new File(path);
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Expense e: expenseList) {
                bufferedWriter.write(e.readAndWriteToFile());
                bufferedWriter.newLine();
            }
            bufferedWriter.flush();
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Expense> readToFile(String path){
        List<Expense> expenseList = new ArrayList<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            while ((line = bufferedReader.readLine())!= null && !line.equals("")){
                String[] arr = line.split(",");
                Expense expense = new Expense(arr[0],arr[1], arr[2], Double.parseDouble(arr[3]), arr[4]);
                expenseList.add(expense);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return expenseList;
    }
}
