package ss15.common;

import ss15.model.Expense;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteToFile {
    public static void writeToFile(List<Expense> exceptionList, String path){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(path);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(exceptionList);
            objectOutputStream.flush();
            objectOutputStream.close();
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Expense> readToFile(String path){
        List<Expense> expenseList = new ArrayList<>();
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(path);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            expenseList = (List<Expense>) objectInputStream.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return expenseList;
    }
}
