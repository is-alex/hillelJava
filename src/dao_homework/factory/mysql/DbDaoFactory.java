package dao_homework.factory.mysql;

import dao_homework.factory.AccountDao;
import dao_homework.factory.CustomerDao;
import dao_homework.factory.DaoFactory;

public class DbDaoFactory extends DaoFactory {
    @Override
    public CustomerDao getCustomerDao() {
        return new DbCustomerDao();
    }

    @Override
    public AccountDao getAccountDao() {
        return new DbAccountDao();
    }
}