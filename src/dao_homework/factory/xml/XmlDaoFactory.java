package dao_homework.factory.xml;

import dao_homework.factory.AccountDao;
import dao_homework.factory.CustomerDao;
import dao_homework.factory.DaoFactory;

public class XmlDaoFactory extends DaoFactory {
    @Override
    public CustomerDao getCustomerDao() {
        return new XmlCustomerDao();
    }

    @Override
    public AccountDao getAccountDao() {
        return new XmlAccountDao();
    }
}