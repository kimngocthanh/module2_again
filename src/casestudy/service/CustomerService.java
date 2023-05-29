package casestudy.service;


import casestudy.model.Customer;
import casestudy.repository.CustomerRepository;

import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private Scanner scanner = new Scanner(System.in);
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public void displayCustomer() {
        List<Customer> customerList = customerRepository.displayCustomer();
        for (Customer c: customerList) {
            System.out.println(c);
        }
    }

    @Override
    public void addCustomer() {
        List<Customer> customerList = customerRepository.displayCustomer();

    }

    @Override
    public void editCustomer() {

    }
}
