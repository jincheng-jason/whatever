package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatever.models.User;
import whatever.daos.UserDao;

/**
 * Created by lijc on 15/4/6.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User save(User user){
        User result = userDao.save(user);
        userDao.flush();
        return result;
    }

    public User update(User user){
        User updatingUser = userDao.findByPhoneNumAndPassword(user.getPhoneNum(),user.getPassword());
        if (!"".equals(user.getWeixin()) && null != user.getWeixin())
            updatingUser.setWeixin(user.getWeixin());
        if (!"".equals(user.getWeibo()) && null != user.getWeibo())
            updatingUser.setWeibo(user.getWeibo());

        return userDao.save(updatingUser);
    }

    public User findByPhoneNum(String phoneNum){
        return userDao.findByPhoneNum(phoneNum);
    }

    public Iterable<User> findByWeibo(String weibo){
        return userDao.findByWeiboAndWeiboIsNotNull(weibo);
    }

    public Iterable<User> findByWeixin(String weixin){
        return userDao.findByWeixinAndWeixinIsNotNull(weixin);
    }

    public Iterable<User> findByWeiboOrWeixin(String weibo,String weixin){
        return userDao.findByWeiboOrWeixin(weibo,weixin);
    }

}
