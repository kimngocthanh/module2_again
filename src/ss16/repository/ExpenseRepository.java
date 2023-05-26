package ss16.repository;

import ss16.common.Common;
import ss16.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository implements IExpenseRepository {
    private List<Expense> expenseList = new ArrayList<>();
    @Override
    public List<Expense> display() {
        expenseList = Common.readToFile("src/ss16/utils/data.csv");
        return expenseList;
    }

    @Override
    public void add(Expense expense) {
        expenseList.add(expense);
        Common.writeToFile("src/ss16/utils/data.csv", expenseList);
    }

    @Override
    public void delete(int index) {
        expenseList.remove(index);
        Common.writeToFile("src/ss16/utils/data.csv",expenseList);
    }

    @Override
    public void edit(int index, Expense expense) {
        expenseList.set(index, expense);
        Common.writeToFile("src/ss16/utils/data.csv",expenseList);
    }

    @Override
    public Expense findId(String id) {
        for (Expense e : expenseList) {
            if (e.getId().equals(id)) {
                expenseList = Common.readToFile("src/ss16/utils/data.csv");
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Expense> findName(String name) {
        List<Expense> list = new ArrayList<>();
        for (Expense e : expenseList) {
            if (e.getName().contains(name)) {
                list.add(e);
            }
        }
        expenseList = Common.readToFile("src/ss16/utils/data.csv");
        return list;
    }

    public List<Expense> sortName(List<Expense> expenseNameList) {
        expenseList = Common.readToFile("src/ss16/utils/data.csv");
        return expenseNameList;
    }

    @Override
    public List<Expense> sortPrice(List<Expense> expensePriceList) {
        expenseList = Common.readToFile("src/ss16/utils/data.csv");
        return expensePriceList;
    }
}

