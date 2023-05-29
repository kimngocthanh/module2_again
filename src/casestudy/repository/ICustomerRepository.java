package casestudy.repository;

import casestudy.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> displayCustomer();

    void addCustomer(Customer customer);

    void editCustomer(int index, Customer customer);
}
