package dao_homework.factory.mysql;


import dao_homework.Customer;
import dao_homework.factory.CustomerDao;

import java.util.Collection;


public class DbCustomerDao implements CustomerDao {
    @Override
    public boolean insertCustomer(Customer customer) {
        return false;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        return false;
    }

    @Override
    public Customer findCustomer(long id) {
        return null;
    }

    @Override
    public boolean updateCustomer(Customer customer) {
        return false;
    }

    @Override
    public Collection<Customer> getCustomers() {
        return null;
    }
}