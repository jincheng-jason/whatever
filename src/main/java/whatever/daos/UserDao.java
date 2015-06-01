package whatever.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import whatever.models.User;

import javax.transaction.Transactional;

/**
 * Created by lijc on 15/4/5.
 */
@Transactional
public interface UserDao extends JpaRepository<User, Long> {
    /**
     * This method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     *
     * @param phoneNum the user phoneNum.
     * @return the user having the passed email or null if no user is found.
     */
    public User findByPhoneNum(String phoneNum);

    public Iterable<User> findByWeiboAndWeiboIsNotNull(String weibo);

    public Iterable<User> findByWeixinAndWeixinIsNotNull(String weixin);

    public Iterable<User> findByWeiboOrWeixin(String weibo, String weixin);

    public User findById(long id);

    public User findByPhoneNumAndPassword(String phoneNum,String passWord);
}
