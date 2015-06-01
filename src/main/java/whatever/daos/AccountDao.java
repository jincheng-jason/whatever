package whatever.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import whatever.models.Account;

import javax.transaction.Transactional;

/**
 * Created by lijc on 15/4/7.
 */
@Transactional
public interface AccountDao extends JpaRepository<Account, Long> {

    public Account findByAccountName(String accountName);

    public Account findByAccount(String account);

    public Account findById(long id);

    public Account findByOpenId(String openId);

    public Iterable<Account> findByIsCommended(Boolean isCommend);

//    @Query("select a from Account a")
//    public Iterable<Account> JustFindAll();
}