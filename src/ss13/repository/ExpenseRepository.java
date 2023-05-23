package ss13.repository;

import ss13.model.Expense;

import java.util.ArrayList;
import java.util.List;

public class ExpenseRepository implements IExpenseRepository {
    private static List<Expense> expenseList = new ArrayList<>();

    static {
        Expense expense = new Expense("001", "hoa quả", "23/05/2023", 5000, "hoa quả");
        Expense expense1 = new Expense("002", "laptop", "23/05/2023", 5000, "laptop");
        Expense expense2 = new Expense("003", "bàn phím", "23/05/2023", 5000, "bàn phím");
        Expense expense3 = new Expense("004", "chuột", "23/05/2023", 5000, "chuột");
        Expense expense4 = new Expense("005", "ram", "23/05/2023", 5000, "ram");
        Expense expense5 = new Expense("006", "ssd", "23/05/2023", 5000, "ssd");
        expenseList.add(expense);
        expenseList.add(expense1);
        expenseList.add(expense2);
        expenseList.add(expense3);
        expenseList.add(expense4);
        expenseList.add(expense5);
    }

    @Override
    public List<Expense> display() {
        return expenseList;
    }

    @Override
    public void add(Expense expense) {
        expenseList.add(expense);
    }

    @Override
    public void delete(int index) {
        expenseList.remove(index);
    }

    @Override
    public void edit(int index, Expense expense) {
        expenseList.set(index, expense);
    }

    @Override
    public Expense findId(String id) {
        for (Expense e : expenseList) {
            if (e.getId().equals(id)) {
                return e;
            }
        }
        return null;
    }

    @Override
    public List<Expense> findName(String name) {
        List<Expense> list = new ArrayList<>();
        for (Expense e: expenseList) {
            if(e.getName().contains(name)){
                list.add(e);
            }
        }return list;

    }
}
