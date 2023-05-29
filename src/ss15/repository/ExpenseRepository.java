package ss15.repository;

import casestudy.common.ReadAndWriteCustomer;
import ss15.common.ReadAndWriteToFile;
import ss15.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository implements IExpenseRepository {


    @Override
    public List<Expense> display() {
        List<Expense> expenseList = ReadAndWriteToFile.readToFile("D:\\Module2_again\\src\\ss15\\data\\expense.dat");
        return expenseList;
    }

    @Override
    public void add(Expense expense) {
        List<Expense> expenseList = ReadAndWriteToFile.readToFile("D:\\Module2_again\\src\\ss15\\data\\expense.dat");
        expenseList.add(expense);
        ReadAndWriteToFile.writeToFile(expenseList,"D:\\Module2_again\\src\\ss15\\data\\expense.dat");
    }

    @Override
    public void delete(int index) {
        List<Expense> expenseList = ReadAndWriteToFile.readToFile("D:\\Module2_again\\src\\ss15\\data\\expense.dat");
        expenseList.remove(index);
        ReadAndWriteToFile.writeToFile(expenseList,"D:\\Module2_again\\src\\ss15\\data\\expense.dat");
    }

    @Override
    public void edit(int index, Expense expense) {
        List<Expense> expenseList = ReadAndWriteToFile.readToFile("D:\\Module2_again\\src\\ss15\\data\\expense.dat");
        expenseList.set(index, expense);
        ReadAndWriteToFile.writeToFile(expenseList,"D:\\Module2_again\\src\\ss15\\data\\expense.dat");
    }

    @Override
    public Expense findId(String id) {
        List<Expense> expenseList = ReadAndWriteToFile.readToFile("D:\\Module2_again\\src\\ss15\\data\\expense.dat");
        for (Expense e : expenseList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Expense> findName(String name) {
        List<Expense> expenseList = ReadAndWriteToFile.readToFile("D:\\Module2_again\\src\\ss15\\data\\expense.dat");
        List<Expense> list = new ArrayList<>();
        for (Expense e : expenseList) {
            if (e.getName().contains(name)) {
                list.add(e);
            }
        }
        return list;
    }

    @Override
    public List<Expense> sortName(List<Expense> expenseNameList) {
        return expenseNameList;
    }

    @Override
    public List<Expense> sortPrice(List<Expense> expensePriceList) {
        return expensePriceList;
    }
}
