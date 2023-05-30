package ss16.repository;

import ss16.common.Common;
import ss16.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository implements IExpenseRepository {
    @Override
    public List<Expense> display() {
        List<Expense> expenseList = Common.readToFile("src/ss16/utils/data.csv");
        return expenseList;
    }

    @Override
    public void add(Expense expense) {
        List<Expense> expenseList = Common.readToFile("src/ss16/utils/data.csv");
        expenseList.add(expense);
        Common.writeToFile("src/ss16/utils/data.csv", expenseList);
    }

    @Override
    public void delete(int index) {
        List<Expense> expenseList = Common.readToFile("src/ss16/utils/data.csv");
        expenseList.remove(index);
        Common.writeToFile("src/ss16/utils/data.csv",expenseList);
    }

    @Override
    public void edit(int index, Expense expense) {
        List<Expense> expenseList = Common.readToFile("src/ss16/utils/data.csv");
        expenseList.set(index, expense);
        Common.writeToFile("src/ss16/utils/data.csv",expenseList);
    }

    @Override
    public Expense findId(String id) {
        List<Expense> expenseList = Common.readToFile("src/ss16/utils/data.csv");
        for (Expense e : expenseList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Expense> findName(String name) {
        List<Expense> expenseList = Common.readToFile("src/ss16/utils/data.csv");
        List<Expense> list = new ArrayList<>();
        for (Expense e : expenseList) {
            if (e.getName().contains(name)) {
                list.add(e);
            }
        }
        return list;
    }

    public List<Expense> sortName(List<Expense> expenseNameList) {
        List<Expense> expenseList = Common.readToFile("src/ss16/utils/data.csv");
        return expenseNameList;
    }

    @Override
    public List<Expense> sortPrice(List<Expense> expensePriceList) {
        List<Expense> expenseList = Common.readToFile("src/ss16/utils/data.csv");
        return expensePriceList;
    }
}

