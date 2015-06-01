package whatever.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import whatever.models.UserBookAccount;

import javax.transaction.Transactional;

/**
 * Created by lijc on 15/4/25.
 */
@Transactional
public interface BookDao  extends JpaRepository<UserBookAccount,Long> {

    public UserBookAccount findById(long id);

    public Iterable<UserBookAccount> findByUserId(long userId);

}
