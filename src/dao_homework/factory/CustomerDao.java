package dao_homework.factory;

import dao_homework.Customer;

import java.util.Collection;

public interface CustomerDao {
    boolean insertCustomer(Customer customer);
    boolean deleteCustomer(Customer customer);
    Customer findCustomer(long id);
    boolean updateCustomer(Customer customer);
    Collection<Customer> getCustomers();
}