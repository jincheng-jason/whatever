package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatever.daos.AccountDao;
import whatever.models.Account;

/**
 * Created by lijc on 15/4/7.
 */
@Service
public class AccountService {
    @Autowired
    AccountDao accountDao;

    public void save(Account account){
        accountDao.save(account);
    }

    public Account findByAccountName(String accountName){
        return accountDao.findByAccountName(accountName);
    }

    public Account findByAccount(String account){
        return accountDao.findByAccount(account);
    }
}
