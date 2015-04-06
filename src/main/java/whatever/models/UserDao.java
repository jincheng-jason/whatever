package whatever.models;

import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;

/**
 * Created by lijc on 15/4/5.
 */
@Transactional
public interface UserDao extends CrudRepository<User, Long> {
    /**
     * This method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     *
     * @param phoneNum the user phoneNum.
     * @return the user having the passed email or null if no user is found.
     */
    public User findByPhoneNum(String phoneNum);

    public User findById(String id);
}
