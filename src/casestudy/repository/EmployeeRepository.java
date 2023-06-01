package casestudy.repository;

import casestudy.common.ReadAndWriteEmployee;
import casestudy.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private static final String PATH_EMPLOYEE = "src/casestudy/data/employee.csv";

    @Override
    public List<Employee> displayEmployee() {
        List<Employee> employeeList = ReadAndWriteEmployee.readToFileEmployee(PATH_EMPLOYEE);
        return employeeList;
    }

    @Override
    public void addEmployee(Employee employee) {
        List<Employee> employeeList = ReadAndWriteEmployee.readToFileEmployee(PATH_EMPLOYEE);
        employeeList.add(employee);
        ReadAndWriteEmployee.writeToFileEmployee(PATH_EMPLOYEE, employeeList);
    }

    @Override
    public void editEmployee(int index, Employee employee) {
        List<Employee> employeeList = ReadAndWriteEmployee.readToFileEmployee(PATH_EMPLOYEE);
        employeeList.set(index, employee);
        ReadAndWriteEmployee.writeToFileEmployee(PATH_EMPLOYEE, employeeList);
    }

    @Override
    public void removeEmployee(int index) {
        List<Employee> employeeList = ReadAndWriteEmployee.readToFileEmployee(PATH_EMPLOYEE);
        employeeList.remove(index);
        ReadAndWriteEmployee.writeToFileEmployee(PATH_EMPLOYEE, employeeList);
    }

    @Override
    public List<Employee> employeeListSearch(String nameEmployee) {
        List<Employee> employeeList = ReadAndWriteEmployee.readToFileEmployee(PATH_EMPLOYEE);
        List<Employee> employeesSearch = new ArrayList<>();
        for (Employee e: employeeList) {
            if(e.getName().contains(nameEmployee)){
                employeesSearch.add(e);
            }
        }
        return employeesSearch;
    }
}
