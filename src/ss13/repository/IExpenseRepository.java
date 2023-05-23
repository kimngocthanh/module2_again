package ss13.repository;

import ss13.model.Expense;

import java.util.List;
import java.util.Map;

public interface IExpenseRepository {
    List<Expense> display();

    void add(Expense expense);

    void delete(int index);

    void edit(int index, Expense expense);

    Expense findId(String id);

    List<Expense> findName(String name);

}
