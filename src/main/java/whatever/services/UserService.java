package whatever.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whatever.models.User;
import whatever.models.UserDao;

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
        User updateingUser = userDao.findById(user.getId());
        updateingUser.setWeibo(user.getWeibo());
        updateingUser.setWeixin(user.getWeixin());
        return userDao.save(updateingUser);
    }

    public User findByPhoneNum(String phoneNum){
        return userDao.findByPhoneNum(phoneNum);
    }

}
