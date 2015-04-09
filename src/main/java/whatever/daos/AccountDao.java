package whatever.daos;

import org.springframework.data.repository.CrudRepository;
import whatever.models.Account;

import javax.transaction.Transactional;

/**
 * Created by lijc on 15/4/7.
 */
@Transactional
public interface AccountDao extends CrudRepository<Account, Long> {
    public Account findById(String id);

    public Account findByAccountName(String accountName);

    public Account findByAccount(String account);
}
