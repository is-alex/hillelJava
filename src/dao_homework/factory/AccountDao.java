package dao_homework.factory;

import dao_homework.Account;

import java.util.Collection;

public interface AccountDao {
    boolean insertAccount(Account account);
    boolean deleteAccount(Account account);
    Account findAccount(long id);
    boolean updateAccount(Account account);
    Collection<Account> getAccounts();
}