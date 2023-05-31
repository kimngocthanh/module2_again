package casestudy.repository;

import casestudy.model.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> displayEmployee();

    void addEmployee(Employee employee);

    void editEmployee(int index, Employee employee);
}
