package dao_homework.factory;

import dao_homework.factory.mysql.DbDaoFactory;
import dao_homework.factory.xml.XmlDaoFactory;

public abstract class DaoFactory {
    public enum DataSourceType{
        XML,
        RDB
    }
    public abstract CustomerDao getCustomerDao();
    public abstract AccountDao getAccountDao();

    public static DaoFactory getDaoFactory(DataSourceType dataSourceType){
        switch (dataSourceType){
            case XML:
                return new XmlDaoFactory();
            case RDB:
                return new DbDaoFactory();
            default:
                throw new RuntimeException("Please specify correct exception and data source");
        }
    }
}