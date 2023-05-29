package casestudy.repository;

import casestudy.common.ReadAndWriteCustomer;
import casestudy.model.Customer;

import java.util.List;

public class CustomerRepository implements ICustomerRepository{

    @Override
    public List<Customer> displayCustomer() {
        List<Customer> customerList = ReadAndWriteCustomer.readToFile("src/casestudy/data/customer.csv");
        return customerList;
    }

    @Override
    public void addCustomer(Customer customer) {
        List<Customer> customerList = ReadAndWriteCustomer.readToFile("src/casestudy/data/customer.csv");
        customerList.add(customer);
        ReadAndWriteCustomer.writeToFile("src/casestudy/data/customer.csv",customerList);
    }

    @Override
    public void editCustomer(int index, Customer customer) {
        List<Customer> customerList = ReadAndWriteCustomer.readToFile("src/casestudy/data/customer.csv");
        customerList.set(index,customer);
        ReadAndWriteCustomer.writeToFile("src/casestudy/data/customer.csv",customerList);
    }
}
