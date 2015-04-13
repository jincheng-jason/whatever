package whatever.controllers;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.javasimon.aop.Monitored;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whatever.models.User;
import whatever.services.UserService;


/**
 * Created by lijc on 15/4/4.
 */
@Api(basePath = "/user", value = "user", description = "用户", produces = "application/json")
@RestController
@RequestMapping("/user")
public class UserController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;


    @Monitored
    @RequestMapping(value = "/findByPhoneNum/{phoneNum}", method = RequestMethod.GET)
    @ApiOperation(httpMethod = "GET", value = "通过电话号码查询用户信息", response = User.class)
    public
    @ResponseBody
    User findByPhoneNum(@PathVariable String phoneNum) {
        return userService.findByPhoneNum(phoneNum);
    }

    /**
     * 用户登录,包括：手机号登录、微博联合登录、微信联合登录
     *
     * @param user
     * @return
     */
    @Monitored
    @RequestMapping(value = "/check", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户登录,包括：手机号登录、微博联合登录、微信联合登录", response = User.class)
    public
    @ResponseBody
    User check(@RequestBody User user) {

        if (!"".equals(user.getWeixin()) && null != user.getWeixin()) {
            //如果微信号不为空，微信号联合登录
            log.info("check by weixin:{}", user.getWeixin());

        } else if (!"".equals(user.getWeibo()) && null != user.getWeibo()) {
            //微博号不为空，则微博联合登录
            log.info("check by weibo:{}", user.getWeibo());

        } else if (!"".equals(user.getPhoneNum()) && null != user.getPhoneNum()) {
            //否则，用手机号登录
            log.info("check by phoneNum:{}", user.getPhoneNum());
            User checkUser = userService.findByPhoneNum(user.getPhoneNum());
            if (null != checkUser && user.getPassword().equals(checkUser.getPassword()))
                return checkUser;
        } else {
            //参数为空

        }
        return user;
    }

    /**
     * 用户新增
     *
     * @param user
     * @return
     */
    @Monitored
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户新增", response = User.class)
    public
    @ResponseBody
    User create(@RequestBody User user) {
        try {
            if (!"".equals(user.getPhoneNum()) && null != user.getPhoneNum()) {
                userService.save(user);
                log.info("user update:{}", user.getPhoneNum());
            }
            return user;
        } catch (Exception ex) {
            log.error(ex.toString());
            return user;
        }

    }

    /**
     * 用户信息更新
     *
     * @param user
     * @return
     */
    @Monitored
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ApiOperation(httpMethod = "POST", value = "用户信息更新", response = User.class)
    public
    @ResponseBody
    User update(@RequestBody User user) {
        try {
            if (user.getId() > 0) {
                user = userService.update(user);
            }
            return user;
        } catch (Exception ex) {
            log.error(ex.toString());
            return user;
        }

    }
}
