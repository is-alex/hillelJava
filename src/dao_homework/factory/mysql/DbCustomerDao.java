package dao_homework.factory.mysql;


import dao_homework.Customer;
import dao_homework.HibernateUtil;
import dao_homework.factory.CustomerDao;
import org.hibernate.Session;

import java.util.Collection;

public class DbCustomerDao implements CustomerDao {
    @Override
    public boolean insertCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(customer);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(customer);
        session.getTransaction().commit();
        session.close();
        return true;
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