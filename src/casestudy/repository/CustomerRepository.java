package casestudy.repository;

import casestudy.common.ReadAndWriteCustomer;
import casestudy.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {


    @Override
    public List<Customer> displayCustomer() {
        List<Customer> customerList = ReadAndWriteCustomer.readToFile("src/casestudy/data/customer.csv");
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        List<Customer> customerList = ReadAndWriteCustomer.readToFile("src/casestudy/data/customer.csv");
        customerList.add(customer);
        ReadAndWriteCustomer.writeToFile("src/casestudy/data/customer.csv", customerList);
    }

    @Override
    public void editCustomer(int index, Customer customer) {
        List<Customer> customerList = ReadAndWriteCustomer.readToFile("src/casestudy/data/customer.csv");
        customerList.set(index, customer);
        ReadAndWriteCustomer.writeToFile("src/casestudy/data/customer.csv", customerList);
    }

    @Override
    public void removeCustomer(int index) {
        List<Customer> customerList = ReadAndWriteCustomer.readToFile("src/casestudy/data/customer.csv");
        customerList.remove(index);
        ReadAndWriteCustomer.writeToFile("src/casestudy/data/customer.csv", customerList);
    }

    @Override
    public List<Customer> customerSearch(String nameCustomer) {
        List<Customer> customerList = ReadAndWriteCustomer.readToFile("src/casestudy/data/customer.csv");
        List<Customer> customerListSearch = new ArrayList<>();
        for (Customer c : customerList) {
            if (c.getName().contains(nameCustomer)) {
                customerListSearch.add(c);
            }
        }
        return customerListSearch;
    }
}
