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

    public void save(User user){
        userDao.save(user);
    }

    public User update(User user){
        User updatingUser = userDao.findById(user.getId());
        if (!"".equals(user.getWeixin()) && null != user.getWeixin())
            updatingUser.setWeixin(user.getWeixin());
        if (!"".equals(user.getWeibo()) && null != user.getWeibo())
            updatingUser.setWeibo(user.getWeibo());

        return userDao.save(updatingUser);
    }

    public User findByPhoneNum(String phoneNum){
        return userDao.findByPhoneNum(phoneNum);
    }

}
