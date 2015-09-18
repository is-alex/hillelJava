package dao_homework.factory.mysql;


import dao_homework.Customer;
import dao_homework.HibernateUtil;
import dao_homework.factory.CustomerDao;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.Collection;

public class DbCustomerDao implements CustomerDao {

    @Override
    public boolean insertCustomer(Customer customer) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(customer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean deleteCustomer(Customer customer) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(customer);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;
    }

    @Override
    public Customer findCustomer(long id) {

        Session session = null;
        Customer customer = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            customer = (Customer) session.get(Customer.class, id);
            Hibernate.initialize(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return customer;
    }

    @Override
    public boolean updateCustomer(Customer customer) {

        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(session.merge(customer));
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return true;

    }

    @Override
    public Collection<Customer> getCustomers() {

        Session session = null;
        Collection<Customer> result = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Query query = session.createQuery("from Customer");
            result = query.list();
            session.getTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return result;
    }
}