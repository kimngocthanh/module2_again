package ss15.repository;

import ss15.model.Expense;

import java.util.List;

public interface IExpenseRepository {
    List<Expense> display();

    void add(Expense expense);

    void delete(int index);

    void edit(int index, Expense expense);

    Expense findId(String id);

    List<Expense> findName(String name);

    List<Expense> sortName(List<Expense> expenseNameList);

    List<Expense> sortPrice(List<Expense> expensePriceList);

}